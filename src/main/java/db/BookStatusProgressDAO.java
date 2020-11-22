package db;

import model.Book;
import model.BookStatusProgress;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookStatusProgressDAO extends DBConnector {
    public BookStatusProgressDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //독서 상황별 조회
    public ArrayList<Book> bookStatusProgressArrayList(String status, String userId) {
        String query = "SELECT * FROM ccd.bookstatusprogress WHERE status = \"" + status + "\" AND userID = \"" + userId + "\"";
        ArrayList<Book> result = new ArrayList<Book>();
        try {
            res = stmt.executeQuery(query);
            while(res.next()) {
                Book book = new Book();
                book.setTitle(res.getString("BookName"));
                book.setAuthor(res.getString("Author"));
                book.setBookID(res.getInt("BookID"));
                result.add(book);
            }

            for(int i=0;i<result.size();i++) {
                query = "SELECT bookCoverUrl FROM ccd.book WHERE bookID = \"" + result.get(i).getBookID() + "\"";
                res = stmt.executeQuery(query);
                result.get(i).setBookCoverUrl(res.getString("bookCoverUrl"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //책이름, 책사진, 저자
        finally {
            return result;
        }
    }

    //독서 상황 등록
    public boolean enrollStatus(BookStatusProgress status) {
        try {
            String query = "INSERT INTO ccd.bookprogressstaus(BookName,Author,Status) VALUES (?,?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,status.getBookName());
            pstmt.setString(2,status.getAuthor());
            pstmt.setString(3,"읽을 책");

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    //삭제
    public void deleteStatus(String name, String uid) {
        int uID = Integer.parseInt(uid);

        try {
            String query = "DELETE FROM ccd.bookprogressstaus WHERE BookName=? AND userID=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2,uID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    //update
    public void modifyStatus(String title, String author, String userID, String oldStatus) {
        try {
            pstmt = conn.prepareStatement("UPDATE ccd.bookprogressstatus SET Status=? WHERE title = ? and author = ? and memberID = ? and status = ?");

            String newStatus="";
            switch (oldStatus) {
                case "읽을 책":
                    newStatus="읽는 중";
                    break;
                case "읽는 중":
                    newStatus="읽은 책";
                    break;
            }

            pstmt.setString(1, newStatus);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, userID);
            pstmt.setString(5, oldStatus);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}

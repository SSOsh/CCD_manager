package db;

import model.Book;
import model.Like;

import java.sql.SQLException;
import java.util.ArrayList;

public class LikeDAO extends DBConnector {
    public LikeDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //좋아요 목록 조회
    public ArrayList<Book> lookupLikeList(String memberID) {
        try {
            String query = "SELECT bookID FROM ccd.like WHERE memberID=" + memberID;
            res = stmt.executeQuery(query);

            ArrayList<String> arr = new ArrayList<String>();
            while (res.next()) {
                arr.add(res.getString("bookID"));
            }

            ArrayList<Book> list = new ArrayList<Book>();

            for(int i=0;i<arr.size();i++) {
                query = "SELECT title, author FROM ccd.book WHERE bookID" + res.getString("bookID");
                res = stmt.executeQuery(query);
                list.add(new Book(res.getString("title"), res.getString("author")));
            }

            return list;

        } catch (SQLException e) {
            e.getStackTrace();
            return null;
        }
    }

    //좋아요 on
    public boolean enrollLike(String title, String author, String memberID) {
        try {
            String query = "SELECT bookID FROM ccd.book WHERE title = \"" + title + "\" AND author = \"" + author + "\"";
            res = stmt.executeQuery(query);
            int bookID = -1;
            if(res.next()) {
                bookID = res.getInt("bookID");
            }
            query = "INSERT INTO ccd.like(likeStatus, memberID, bookID) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,1);
            pstmt.setString(2, memberID);
            pstmt.setInt(3, bookID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    //좋아요 off
    public void deleteLike(String id) {
        int ID = Integer.parseInt(id);

        try {
            String query = "delete from ccd.like where like.likeID="+ID;
            pstmt=conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
}

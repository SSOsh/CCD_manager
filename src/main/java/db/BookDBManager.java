package db;

import model.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class BookDBManager extends DBConnector
{
    public BookDBManager() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //책 정보 관리 클릭하자 마자 전체 책 리스트 조회
    //아직 서블릿 구현 안함
    public ArrayList<Book> browseBookList()
    {
        try
        {
            String query="SELECT bookId, bookCoverUrl, title, author, starRating, summarize, publisher FROM ccd.book"; //쿼리 수정해야되누
            res=stmt.executeQuery(query);

            ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Book book=new Book();

                book.setBookId(res.getInt("bookId"));
                book.setBookCoverUrl(res.getString("bookCoverUrl"));
                book.setTitle(res.getString("title"));
                book.setAuthor(res.getString("author"));
                book.setStarRating(res.getDouble("starRating"));
                book.setSummarize(res.getString("summarize"));
                book.setPublisher(res.getString("publisher"));

                list.add(book);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }


    public ArrayList<Book> searchBookList(String t, String a)
    {
        try
        {
            if(t==null && a==null)
            {
                browseBookList();
            }
            String query= "SELECT * FROM ccd.book WHERE title LIKE \"%"+ t +"%\" and author LIKE \"%"+ a +"%\"";
            res=stmt.executeQuery(query);
            ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Book book=new Book();

                book.setBookId(res.getInt("bookId"));
                book.setBookCoverUrl(res.getString("bookCoverUrl"));
                book.setTitle(res.getString("title"));
                book.setAuthor(res.getString("author"));
                book.setStarRating(res.getDouble("starRating"));
                book.setSummarize(res.getString("summarize"));
                book.setPublisher(res.getString("publisher"));

                list.add(book);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

//    //책 정보 삭제
//    public boolean deleteBookInfo(Book book)
//    {
//        try
//        {
//            String query = "call ccd.deleteBook(?)";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, book.getBookId());
//            int result = pstmt.executeUpdate();
//
//            return true;
//        }
//        catch(SQLException e)
//        {
//            e.getStackTrace();
//            System.out.println("error");
//            return false;
//        }
//    }

}
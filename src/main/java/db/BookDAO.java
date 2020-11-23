package db;

import model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class BookDAO extends DBConnector
{
    public BookDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //책 등록 - 파싱할때 2020-11-22
    // 카테고리 ID, 제목, 구매 url, 작가, 요약설명, 북커버 url, 출판사 입력받음
    public void enrollBookList(String cID, String title,String link, String author, String dscp, String cover, String pbls)
    {
        try
        {
            String query = "INSERT INTO `ccd`.`book` (`categoryID`, `title`, `purchaseUrl`, `author`, `summarize`, `bookCoverUrl`," +
                    " `publisher`) VALUES (\""+cID+"\",\""+title+"\",\""+link+"\",\""+author+"\",\""+dscp+"\",\""+cover+"\",\""+pbls+"\")";

            pstmt = conn.prepareStatement(query);

//            pstmt.setString(1,cID);
//            pstmt.setString(2,title);
//            pstmt.setString(3,link);
//            pstmt.setString(4,author);
//            pstmt.setString(5,dscp);
//            pstmt.setString(6,cover);
//            pstmt.setString(7,pbls);

            pstmt.executeUpdate();

//            System.out.println("Enroll Success");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }

    //책 정보 관리 클릭하자 마자 전체 책 리스트 조회
    public ArrayList<Book> lookupBookList()
    {
        try
        {
            String query="SELECT * FROM ccd.book";
            res=stmt.executeQuery(query);

            ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Book book=new Book();

                book.setBookID(res.getInt("bookID"));
                book.setCategoryID(res.getString("categoryID"));
                book.setStarRating(res.getDouble("starRating"));
                book.setTitle(res.getString("title"));
                book.setTable(res.getString("table"));
                book.setPurchaseUrl(res.getString("purchaseUrl"));
                book.setAuthor(res.getString("author"));
                book.setSummarize(res.getString("summarize"));
                book.setBookCoverUrl(res.getString("bookCoverUrl"));
                book.setVideoUrl(res.getString("videoUrl"));
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
                lookupBookList();
            }
            String query= "SELECT * FROM ccd.book WHERE title LIKE \"%"+ t +"%\" and author LIKE \"%"+ a +"%\"";
            res=stmt.executeQuery(query);
            ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Book book=new Book();

                book.setBookID(res.getInt("bookID"));
                book.setCategoryID(res.getString("categoryID"));
                book.setStarRating(res.getDouble("starRating"));
                book.setTitle(res.getString("title"));
                book.setTable(res.getString("table"));
                book.setPurchaseUrl(res.getString("purchaseUrl"));
                book.setAuthor(res.getString("author"));
                book.setSummarize(res.getString("summarize"));
                book.setBookCoverUrl(res.getString("bookCoverUrl"));
                book.setVideoUrl(res.getString("videoUrl"));
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

    //20-11-17 승환 완료
    //책 정보 삭제
    public void deleteBookInfo(String id)
    {
        try
        {
            String query = "delete from ccd.book where book.bookID ="+id;
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            System.out.println("Delete Success");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }

    //20-11-20 영상파트 추가
    public ArrayList<Book> searchVideoList()
    {
            try
            {
                String query="SELECT * FROM ccd.book WHERE NOT videoUrl is NULL"; //videoUrl 없는 거 빼고 다 긁어오기
                res=stmt.executeQuery(query);

                ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

                while(res.next())      //얻어온 테이블의 행이 끝날때 까지
                {
                    Book book=new Book();

                    book.setBookID(res.getInt("bookID"));
                    book.setCategoryID(res.getString("categoryID"));
                    book.setStarRating(res.getDouble("starRating"));
                    book.setTitle(res.getString("title"));
                    book.setTable(res.getString("table"));
                    book.setPurchaseUrl(res.getString("purchaseUrl"));
                    book.setAuthor(res.getString("author"));
                    book.setSummarize(res.getString("summarize"));
                    book.setBookCoverUrl(res.getString("bookCoverUrl"));
                    book.setVideoUrl(res.getString("videoUrl"));
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

    //20-11-24 베스트셀러 파트 추가
    public ArrayList<Book> searchBestSellerList()
    {
        try
        {
            String query="SELECT * FROM ccd.book WHERE starRating >= 4.5"; //별점 4.5 이상 뽑아오기
            res=stmt.executeQuery(query);

            ArrayList<Book> list=new ArrayList<Book>();     //실행한 객체를 담을 list

            while(res.next())      //얻어온 테이블의 행이 끝날때 까지
            {
                Book book=new Book();

                book.setBookID(res.getInt("bookID"));
                book.setCategoryID(res.getString("categoryID"));
                book.setStarRating(res.getDouble("starRating"));
                book.setTitle(res.getString("title"));
                book.setTable(res.getString("table"));
                book.setPurchaseUrl(res.getString("purchaseUrl"));
                book.setAuthor(res.getString("author"));
                book.setSummarize(res.getString("summarize"));
                book.setBookCoverUrl(res.getString("bookCoverUrl"));
                book.setVideoUrl(res.getString("videoUrl"));
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

}

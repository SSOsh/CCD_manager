package controller.BookManagement;

import db.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//20-11-13 승환 - 서블릿 생성중 에러발생 이유가뭘까.. 57 = Java 13 자바 버전이 안맞는듯?
//20-11-16 승환 - Apache 폴더안에 mySQL DB Connecter.lib의 버전이 안맞아서 그랬었음 ==> 해결 ㄱㅇㄷ

@WebServlet("/LookupBook") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupBook extends HttpServlet
{
    BookDAO dao= new BookDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Book> bookList;
        Book book = new Book();
        book.setTitle(req.getParameter("title")); //jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것
        book.setAuthor(req.getParameter("author"));

        bookList= dao.searchBookList(book.getTitle(),book.getAuthor());

        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/BookView/bookMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

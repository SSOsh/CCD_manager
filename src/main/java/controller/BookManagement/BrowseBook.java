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

@WebServlet("/bookMain")
public class BrowseBook extends HttpServlet
{
    BookDAO dbManager= new BookDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Book> bookList;
        Book book = new Book();
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));

        bookList= dbManager.searchBookList(book.getTitle(),book.getAuthor());

        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/BookView/bookMain.jsp").forward(req,resp);
    }
}

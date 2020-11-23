package controller.BestSellerManagement;

import db.BookDAO;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LookupBestSeller") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupBestSeller extends HttpServlet
{
    BookDAO dao= new BookDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Book> bookList;

        bookList= dao.searchBestSellerList();

        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/BestSellerView/bestSellerMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

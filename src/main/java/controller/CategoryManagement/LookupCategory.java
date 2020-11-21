package controller.CategoryManagement;

import db.CategoryInfoDAO;
import model.CategoryInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LookupCategory") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupCategory extends HttpServlet
{
    CategoryInfoDAO dao= new CategoryInfoDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<CategoryInfo> categoryInfoList;

        //전체 조회로 리스트 받아옴
        categoryInfoList = dao.lookupCategoryInfoList();

        req.setAttribute("categoryInfoList",categoryInfoList);
        req.getRequestDispatcher("/CategoryView/categoryMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

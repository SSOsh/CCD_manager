package controller.ForumManagement;

import db.ForumDAO;
import model.Forum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/EnrollForum") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class EnrollForum extends HttpServlet
{
    ForumDAO dao= new ForumDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Forum> forumList;

        dao.enrollForum(req.getParameter("forumTitle")); //바로 name 속성의 value 받아와서 등록

        forumList = dao.lookupForumList(); //등록 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("forumList",forumList);
        req.getRequestDispatcher("/ForumView/forumMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

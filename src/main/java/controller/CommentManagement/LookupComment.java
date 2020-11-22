package controller.CommentManagement;

import db.CommentDAO;
import model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LookupComment") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupComment extends HttpServlet
{
    CommentDAO dao= new CommentDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        //commentID , postID, memberID
        req.setCharacterEncoding("utf-8");
        ArrayList<Comment> commentList;

        commentList= dao.searchCommentList(req.getParameter("cID"),
                req.getParameter("pID"),req.getParameter("mID"));

        req.setAttribute("commentList",commentList);
        req.getRequestDispatcher("/CommentView/commentMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

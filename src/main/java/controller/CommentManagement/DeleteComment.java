package controller.CommentManagement;

import db.CommentDAO;
import model.Comment;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteComment") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class DeleteComment extends HttpServlet
{
    CommentDAO dao= new CommentDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Comment> commentList;

        //jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것, 받아와서 바로 삭제에 파라미터로 넘겨줌
        dao.deleteComment(req.getParameter("userId"),("text")); //삭제 실행

        commentList = dao.lookupCommentList(); //삭제 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("commentList",commentList);
        req.getRequestDispatcher("/CommentView/commentMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

package controller.PostManagement;

import db.PostDAO;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LookupPostContents") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupPostContents extends HttpServlet
{
    PostDAO dao= new PostDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Post> postList;
        Post post = new Post();

        System.out.println(req.getParameter("onePost"));

        post.setTitle(req.getParameter("onePost"));
        postList= dao.searchPostByTitle(post.getTitle());

        req.setAttribute("postList",postList);
        req.getRequestDispatcher("/PostView/postLookupDetail.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

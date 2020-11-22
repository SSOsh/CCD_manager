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

@WebServlet("/LookupPost") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupPost extends HttpServlet
{
    PostDAO dao= new PostDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        //forumTitle(Model에 없는 값) , postTitle, nickName
        req.setCharacterEncoding("utf-8");
        ArrayList<Post> postList;
        Post post = new Post();

        String forumName=req.getParameter("forumTitle");//jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것
        post.setTitle(req.getParameter("postTitle"));
        post.setNickname(req.getParameter("nickName"));

        postList= dao.searchPostList(forumName,post.getTitle(),post.getNickname());

        req.setAttribute("postList",postList);
        req.getRequestDispatcher("/PostView/postMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

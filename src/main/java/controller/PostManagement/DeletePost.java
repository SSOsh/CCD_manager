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

@WebServlet("/DeletePost") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class DeletePost extends HttpServlet
{
    PostDAO dao= new PostDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Post> postList;

        //jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것, 받아와서 바로 삭제에 파라미터로 넘겨줌
        dao.deletePost(req.getParameter("selected")); //삭제 실행

        postList = dao.lookupPostList(); //삭제 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("postList",postList);
        req.getRequestDispatcher("/PostView/postMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

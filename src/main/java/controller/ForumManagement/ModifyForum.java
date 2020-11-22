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

@WebServlet("/ModifyForum") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class ModifyForum extends HttpServlet
{
    ForumDAO dao= new ForumDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Forum> forumList;

        String oldName =(String) req.getSession().getAttribute("selected"); //세션에서 깨진 값 받아온다.

        String newName = req.getParameter("newTitle");
        String encOld=makeKOR(oldName); //밑에 정의된 인코딩함수 돌려준다.

        System.out.println("이전 이름(깨짐) = " +oldName);
        System.out.println("바꿀 이름 = " +newName);
        System.out.println("이전 이름(복구) = " +encOld); //인코딩한 거


        //이전 게시판명으로 게시판 ID(PK)를 확인
        int fID = dao.getForumID(encOld);

        System.out.println(fID);

        //수정 실행하는 부분
        dao.modifyForum(fID, newName);

        forumList = dao.lookupForumList(); //수정 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("forumList",forumList);
        req.getRequestDispatcher("/ForumView/forumMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }

    String makeKOR(String str)throws java.io.UnsupportedEncodingException
    {
        String kor="";
        if(str==null)
            kor=null;
        else
            kor=new String(str.getBytes("ISO-8859-1"),"utf-8"); //바뀌면 에러나유
        return kor;
    }
}

package controller.NoticeManagement;

import db.ForumDAO;
import db.NoticeDAO;
import model.Forum;
import model.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteNotice") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class DeleteNotice extends HttpServlet
{
    NoticeDAO dao= new NoticeDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Notice> noticeList;

        //jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것, 받아와서 바로 삭제에 파라미터로 넘겨줌
        dao.deleteNotice(req.getParameter("selected")); //삭제 실행

        noticeList = dao.lookupNoticeList(); //삭제 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("noticeList",noticeList);
        req.getRequestDispatcher("/NoticeView/noticeMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

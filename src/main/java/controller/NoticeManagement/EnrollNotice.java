package controller.NoticeManagement;

import db.NoticeDAO;
import model.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/EnrollNotice") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class EnrollNotice extends HttpServlet
{
    NoticeDAO dao= new NoticeDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Notice> noticeList;

        dao.enrollNotice(req.getParameter("noticeTitle"),
                req.getParameter("noticeDivision"),req.getParameter("noticeContents")); //바로 name 속성의 value 받아와서 등록

        noticeList = dao.lookupNoticeList(); //등록 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("noticeList",noticeList);
        req.getRequestDispatcher("/NoticeView/noticeMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}
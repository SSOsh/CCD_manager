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

@WebServlet("/LookupNotice") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupNotice extends HttpServlet
{
    NoticeDAO dao= new NoticeDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        //아무것도 안받아와도 됨
        req.setCharacterEncoding("utf-8");
        ArrayList<Notice> noticeList;

        noticeList = dao.lookupNoticeList();

        req.setAttribute("noticeList",noticeList);
        req.getRequestDispatcher("/NoticeView/noticeMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

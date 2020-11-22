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

@WebServlet("/ModifyNotice") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class ModifyNotice extends HttpServlet
{
    NoticeDAO dao= new NoticeDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<Notice> noticeList;

        String modiID =(String) req.getSession().getAttribute("selected"); //세션에서 깨진 값 받아온다.

        System.out.println("입력받은 ID(깨질까유?) : "+modiID); //안깨지넹ㅋㅋ 근데 남겨놓을게

        String nT = req.getParameter("noticeTitle"); //수정할 제목
        String nD = req.getParameter("noticeDivision"); //수정할 구분
        String nC =  req.getParameter("noticeContents"); //수정할 내용

        String encID=makeKOR(modiID); //밑에 정의된 인코딩함수 돌려준다.

        System.out.println("입력받은 ID(디코딩) : "+encID);

        //수정 실행하는 부분
        dao.modifyNotice(encID,nT,nD,nC);

        noticeList = dao.lookupNoticeList(); //수정 후 전체 리스트 출력해주기 위해 담아옴

        req.setAttribute("noticeList",noticeList);
        req.getRequestDispatcher("/NoticeView/noticeMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }

    String makeKOR(String str) throws java.io.UnsupportedEncodingException
    {
        String kor="";
        if(str==null)
            kor=null;
        else
            kor=new String(str.getBytes("ISO-8859-1"),"utf-8"); //바뀌면 에러나유
        return kor;
    }
}

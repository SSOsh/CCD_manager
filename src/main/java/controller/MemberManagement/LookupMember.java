package controller.MemberManagement;

import db.MemberDAO;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LookupMember") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class LookupMember extends HttpServlet
{
    MemberDAO dao= new MemberDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        //memberName , nickName
        req.setCharacterEncoding("utf-8");
        ArrayList<Member> memberList;
        Member member = new Member();
        member.setName(req.getParameter("memberName")); //jsp파일에서 form태그 안에 넘겨주는데 있는 name 속성을 받아오는 것
        member.setNickname(req.getParameter("nickName"));

        memberList= dao.searchMemberList(member.getName(),member.getNickname());

        req.setAttribute("memberList",memberList);
        req.getRequestDispatcher("/MemberView/memberMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }
}

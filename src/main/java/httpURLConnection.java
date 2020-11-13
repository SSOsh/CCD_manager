
import model.Book;
import model.Member;
import org.json.simple.JSONObject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import db.DBConnector;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/http.jsp")
public class httpURLConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public httpURLConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("euc-kr");
        //앱에서 받은 값 처리
        Enumeration<String> parameterNames = request.getParameterNames();
        String name;
        while (parameterNames.hasMoreElements()) {
            name = (String) parameterNames.nextElement();
            System.out.println(name);
        }
//        //db처리
//        String query="SELECT memberId, password FROM ccd.member WHERE name = " + "name";
//
//        DBConnector conn = new DBConnector();
//
//        Statement stmt = conn.createStatement();
//        Resultset res = stmt.executeQuery(query);
//
//        ArrayList<Member> list=new ArrayList<Member>();     //실행한 객체를 담을 list
//
//        while(res.next())       //얻어온 테이블의 행이 끝날때 까지
//        {
//            Member member = new Member();
//
//            member.setMemberID(res.getInt("memberID"));
//            member.setMemberPW(res.getString("memberPW"));
//
//            list.add(book);
//        }


        //앱으로 줄 값 처리
        JSONObject jsonObject = new JSONObject();
        //여기서 for문 돌리면서 값 넣으면 될 듯
        jsonObject.put("name", "이름");
        jsonObject.put("country", "사는곳");
        jsonObject.put("twitter", "트위터");

        response.setContentType("application/json");
        response.setCharacterEncoding("euc-kr");
        PrintWriter out = response.getWriter();

        out.println(jsonObject.toJSONString());
    }
}

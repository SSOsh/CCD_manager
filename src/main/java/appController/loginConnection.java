package appController;

import db.MemberDAO;
import model.Member;
import org.json.simple.JSONObject;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/login.jsp")
public class loginConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public loginConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("euc-kr");

        //앱에서 받은 값 처리
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }


        JSONParser parser = null;
        JSONObject jsonObject = null;
        try {
            parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jb.toString());
        } catch (ParseException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");



        MemberDAO MemberDBM = new MemberDAO();
        Member member = new Member(jsonObject.get("id").toString(), jsonObject.get("pw").toString());
        Member check = null;
        try {
            check = MemberDBM.login(jsonObject.get("id").toString(), jsonObject.get("pw").toString());
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (check != null) {
            //성공
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("id", check.getMemberID());
            map.put("pw", check.getMemberPW());
            map.put("name", check.getName());
            map.put("nickname", check.getNickname());
            map.put("address", check.getAddress());
            map.put("result", "success");
            list.add(map);
            jsonObj.put("member", list);
            response.getWriter().write(jsonObj.toString());
            //앱으로 보내줌

        } else {
            //실패
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("id", check.getMemberID());
            map.put("pw", check.getMemberPW());
            map.put("name", check.getName());
            map.put("nickname", check.getNickname());
            map.put("address", check.getAddress());
            map.put("result", "fail");
            list.add(map);
            jsonObj.put("member", list);
            response.getWriter().write(jsonObj.toString());
        }
    }
}
package appController;

import db.MemberDAO;
import model.Member;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/myInfo.jsp")
public class myInfoConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public myInfoConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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

        String name, id, pw, nickname, address;
        name = jsonObject.get("name").toString();
        id = jsonObject.get("id").toString();
        pw = jsonObject.get("pw").toString();
        nickname = jsonObject.get("nickname").toString();
        address = jsonObject.get("address").toString();

        String oldname, oldid, oldpw, oldnickname, oldaddress;
        oldname = jsonObject.get("oldname").toString();
        oldid = jsonObject.get("oldid").toString();
        oldpw = jsonObject.get("oldpw").toString();
        oldnickname = jsonObject.get("oldnickname").toString();
        oldaddress = jsonObject.get("oldaddress").toString();


        MemberDAO dbManager = new MemberDAO();
        Member member = new Member(name, id, pw, nickname, address);
        Member oldMember = new Member(oldname, oldid, oldpw, oldnickname, oldaddress);
        boolean check = dbManager.MemberModify(member, oldMember);
        if(check) {
            //성공
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("result", "success");
            list.add(map);
            jsonObj.put("myInfo", list);
            response.getWriter().write(jsonObj.toString());
            System.out.println(jsonObj.toString());
        }else {
            //실패
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("result", "fail");
            list.add(map);
            jsonObj.put("myInfo", list);
            response.getWriter().write(jsonObj.toString());
            System.out.println(jsonObj.toString());
        }
    }
}

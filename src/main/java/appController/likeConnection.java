package appController;

import db.LikeDAO;
import db.MemberDAO;
import model.Like;
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
@WebServlet("/like.jsp")
public class likeConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public likeConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("like들어옴");

        //앱에서 받은 값 처리
        StringBuffer jb;
        jb = new StringBuffer();
        String line = "";
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONParser parser = null;
        JSONObject jsonObject = null;
        try {
            parser = new JSONParser();
            System.out.println("파싱되나");
            System.out.println(jb.toString());
            jsonObject = (JSONObject) parser.parse(jb.toString());
            System.out.println("파싱된다");
        } catch (ParseException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String title, author, memberID;
        title = jsonObject.get("title").toString();
        author = jsonObject.get("author").toString();
        memberID = jsonObject.get("memberID").toString();
        System.out.println("들어오나");

        LikeDAO likeDAO = new LikeDAO();

        boolean check = likeDAO.enrollLike(title, author, memberID);
        System.out.println(check);
        if(check) {
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("result", "success");
            list.add(map);
            jsonObj.put("like", list);
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
            jsonObj.put("like", list);
            response.getWriter().write(jsonObj.toString());
            System.out.println(jsonObj.toString());
        }
    }
}

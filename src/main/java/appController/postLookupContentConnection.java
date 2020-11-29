package appController;

import db.MemberDAO;
import db.PostDAO;
import model.Member;
import model.Post;
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

@WebServlet("/postLookupContent.jsp")
public class postLookupContentConnection extends HttpServlet {


    public postLookupContentConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("내용볼래");
        //앱에서 받은 값 처리
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            line = reader.readLine();
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }


        JSONParser parser = null;
        JSONObject jsonObject = null;
        try {
            parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jb.toString());
            System.out.println("hello");
        } catch (ParseException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("hello");
        String title = jsonObject.get("title").toString();
        System.out.println(title);
        PostDAO dbManager = new PostDAO();
        ArrayList<Post> check = dbManager.searchPostByTitle(title);
        System.out.println(check.get(0).toString());
        if(check.size() != 0) {
            //성공
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();

            for(int i=0;i<check.size();i++) {
                Map<String, String> map = new HashMap<>();
                map.put("content", check.get(i).getContents());

                list.add(map);
            }

            jsonObj.put("postLookup", list);
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
            jsonObj.put("postEnroll", list);
            response.getWriter().write(jsonObj.toString());
            System.out.println(jsonObj.toString());
        }
    }
}

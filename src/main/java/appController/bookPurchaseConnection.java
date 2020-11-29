package appController;

import db.BookDAO;
import db.LikeDAO;
import db.MemberDAO;
import model.Book;
import model.Like;
import model.Member;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/bookPurchase.jsp")
public class bookPurchaseConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public bookPurchaseConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("bookPurchase들어옴");
        //앱에서 받은 값 처리
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        System.out.println(jb.toString());
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



        BookDAO bookD = new BookDAO();

        Book check = null;
        check = bookD.lookupBook(jsonObject.get("bookName").toString(), jsonObject.get("author").toString());
        if (check != null) {
            System.out.println(check.getPurchaseUrl());
            //성공
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("purchaseUrl", check.getPurchaseUrl());
            map.put("result", "success");
            list.add(map);
            jsonObj.put("bookPurchase", list);
            response.getWriter().write(jsonObj.toString());
            //앱으로 보내줌

        } else {
            //실패
            //앱한테 줄 값 넘겨주기
            JSONObject jsonObj = new JSONObject();
            //여기서 for문 돌리면서 값 넣으면 될 듯
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("result", "fail");
            list.add(map);
            jsonObj.put("bookPurchase", list);
            response.getWriter().write(jsonObj.toString());
        }
    }
}
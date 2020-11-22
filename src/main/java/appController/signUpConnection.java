package appController;

import db.MemberDAO;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/signUp.jsp")
public class signUpConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public signUpConnection() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("들어옴");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("signup 들어옴");
        request.setCharacterEncoding("euc-kr");
        //앱에서 받은 값 처리
        Enumeration<String> parameterNames = request.getParameterNames();
        String str = "";
        String[] arr;
        int num = 0;
        while (parameterNames.hasMoreElements()) {
            str = (String) parameterNames.nextElement();
        }
        arr = str.split("/");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("euc-kr");
        PrintWriter out = response.getWriter();

        MemberDAO dbManager = new MemberDAO();
        Member member = new Member(arr[0], arr[1], arr[2], arr[3], arr[4]);
        boolean check = dbManager.MemberEnroll(member);
        System.out.println(check);
        if(check) {
            //성공
            //앱한테 줄 값 넘겨주기
            System.out.println("성공");
            out.println("성공");
        }else {
            //실패
            //앱한테 줄 값 넘겨주기
            System.out.println("실패");
            out.println("실패");
        }

//        //앱으로 줄 값 처리
//        JSONObject jsonObject = new JSONObject();
//        //여기서 for문 돌리면서 값 넣으면 될 듯
//        jsonObject.put("name", "이름");
//        jsonObject.put("country", "사는곳");
//        jsonObject.put("twitter", "트위터");

    }
}

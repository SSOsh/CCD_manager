package appController;//package appController;
//
//import db.MemberDBManager;
//import db.PostDBManager;
//import model.Post;
//import model.Member;
//import org.json.simple.JSONObject;
//
//import java.io.*;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.Vector;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.transform.Result;
//
//import db.DBConnector;
//
///**
// * Servlet implementation class SampleServlet
// */
//@WebServlet("/http.jsp")
//public class PostConnection extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /*
//     * @see HttpServlet#HttpServlet()
//     */
//    public PostConnection() {
//        super();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("들어옴");
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("signup 들어옴");
//        request.setCharacterEncoding("euc-kr");
//        //앱에서 받은 값 처리
//        Enumeration<String> parameterNames = request.getParameterNames();
//        String str = "";
//        String[] arr;
//        int num = 0;
//        while (parameterNames.hasMoreElements()) {
//            str = (String) parameterNames.nextElement();
//        }
//        arr = str.split("/");
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("euc-kr");
//        PrintWriter out = response.getWriter();
//
//        PostDBManager PDManager = new PostDBManager();
//        Post post = new Post(arr[0], arr[1]);
//        boolean
//        System.out.println(check);
//        if(check) {
//            //성공
//            //앱한테 줄 값 넘겨주기
//            System.out.println("성공");
//            out.println("성공");
//        }else {
//            //실패
//            //앱한테 줄 값 넘겨주기
//            System.out.println("실패");
//            out.println("실패");
//        }
//
////        //앱으로 줄 값 처리
////        JSONObject jsonObject = new JSONObject();
////        //여기서 for문 돌리면서 값 넣으면 될 듯
////        jsonObject.put("name", "이름");
////        jsonObject.put("country", "사는곳");
////        jsonObject.put("twitter", "트위터");
//
//    }
//}

package appController;//package appController;
//
//import db.CommentDBManager;
//import db.MemberDBManager;
//import model.Book;
//import model.Comment;
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
//public class CommentConnection extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /*
//     * @see HttpServlet#HttpServlet()
//     */
//    public CommentConnection() {
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
//        System.out.println("comment입력 들어옴");
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
//        CommentDBManager dbManager = new CommentDBManager();
//        Comment comment = new Member(arr[0], arr[1], arr[2], arr[3], arr[4]);
//        boolean check = dbManager.CommentEnroll(comment);
//        System.out.println(check);
//        if(check) {
//            //성공
//            System.out.println("성공");
//        }else {
//
//            System.out.println("실패");
//        }
//
//    }
//}

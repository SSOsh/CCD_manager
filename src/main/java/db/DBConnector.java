package db;

import java.sql.*;

public class DBConnector {

    //url만 수정하면 될듯
    String url = "jdbc:mysql://Localhost/ccd?characterEncoding=utf8&amp;serverTimezone=UTC&amp;useSSL=false";
//    private static Connection con; //파싱할때 쓰이는거라서 추가
    Connection conn = null;
    ResultSet res = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    String user = "root";
    String password = "0000";

    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            con=DriverManager.getConnection(url,user,password); //파싱전용
            conn = DriverManager.getConnection(url,user ,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

//    public static Connection getConnection() {
//        return con;
//    } //파싱할때 쓰이는거라서 추가

    public Connection getConn() { return conn; }

    public ResultSet getRes() {
        return res;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }
}
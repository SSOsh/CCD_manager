package db;

import java.sql.*;

public class DBConnector {
    //url만 수정하면 될듯
    String url = "jdbc:mysql://Localhost/ccd?characterEncoding=utf8&amp;serverTimezone=UTC&amp;useSSL=false";
    Connection conn = null;
    ResultSet res = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    String user = "root";
    String password = "zx12qw34!";

    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user ,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

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
package db;

import model.Comment;

import java.sql.SQLException;
import java.util.ArrayList;


public class CommentDAO extends DBConnector {
    public CommentDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //전체 조회
    public ArrayList<Comment> lookupCommentList() {
        try {
            String query = "SELECT * FROM ccd.comment";
            res = stmt.executeQuery(query);

            ArrayList<Comment> list = new ArrayList<Comment>();   //실행한 객체를 담을 list

            while (res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Comment comment = new Comment();

                comment.setCommentID(res.getInt("commentID"));
                comment.setPostID(res.getInt("postID"));
                comment.setMemdberID(res.getString("memberID"));
                comment.setTEXT(res.getString("contents")); //모델이랑 이름이 좀 다름 주의..
                comment.setDate(res.getString("date"));

                list.add(comment);
            }
            return list;
        } catch (SQLException e) {
            e.getStackTrace();
            return null;
        }
    }

    //검색 - 키워드 : 댓글ID / 게시물ID / 사용자ID
    public ArrayList<Comment> searchCommentList(String c, String p, String m) {
        try {
            if (c == null && p == null && m == null) {
                lookupCommentList();
            }
            String query = "SELECT * FROM ccd.comment where commentID like \"%" + c + "%\"and postID like \"%" + p + "%\" and memberID like \"%" + m + "%\"";

            res = stmt.executeQuery(query);
            ArrayList<Comment> list = new ArrayList<Comment>();     //실행한 객체를 담을 list

            while (res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Comment comment = new Comment();

                comment.setCommentID(res.getInt("commentID"));
                comment.setPostID(res.getInt("postID"));
                comment.setMemdberID(res.getString("memberID"));
                comment.setTEXT(res.getString("contents")); //모델이랑 이름이 좀 다름 주의..
                comment.setDate(res.getString("date"));

                list.add(comment);
            }
            return list;
        } catch (SQLException e) {
            e.getStackTrace();
            return null;
        }
    }

    public void deleteComment(String id) {
        System.out.println(id);


        try {
            int ID = Integer.parseInt(id);
            System.out.println(ID); //형변환 끝낸 댓글ID
            String query = "delete from ccd.comment where comment.commentID =" + ID;
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Delete Success");
    }

    //삭제
    public boolean deleteComment(String userID, String text) {
        try {
            String query = "delete from ccd.comment where comment.memberID =" + userID + "and contents=" + text;
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            System.out.println("Delete Success");
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            System.out.println("SQL error");
        }
        return false;
    }

    //등록
    public boolean enrollComment(String userID, String comment) {
        try {
            String query = "INSERT INTO ccd.comment(memdberID,TEXT) VALUES (?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userID);
            pstmt.setString(2, comment);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    //등록
    public boolean enrollComment(String comment, String title, String content, String id) {
        try {
            String query1 = "SELECT postID FROM ccd.post WHERE title=\"" + title + "\"AND contents=\"" + content + "\"";
            res = stmt.executeQuery(query1);
            int postid = 0;
            if (res.next()) {
                postid = res.getInt("postID");
            }
            System.out.println(postid);
            System.out.println(comment);
            System.out.println(id);
            String query = "INSERT INTO ccd.comment(contents, postID, memberID) VALUES (?,?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, comment);
            pstmt.setInt(2, postid);
            pstmt.setString(3, id);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }


    //수정
    public int modifyComment(String userID, String newText, String oldText) {
        try {
            pstmt = conn.prepareStatement("UPDATE ccd.comment SET TEXT=? WHERE memberID=? AND TEXT=?");

            pstmt.setString(1, newText);
            pstmt.setString(2, userID);
            pstmt.setString(3, oldText);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return -1;
    }

    public ArrayList<Comment> commentLookup(String id, String title, String content) {
        ArrayList<Comment> list = new ArrayList<Comment>();   //실행한 객체를 담을 list
        try {
            String query = "SELECT * FROM ccd.post WHERE title =\"" + title + "\" AND contents= \"" + content + "\"";

            res = stmt.executeQuery(query);
            res.next();
            System.out.println("select 결과");
            String postID = res.getString("postID");
            System.out.println(postID);
            query = "SELECT * FROM ccd.comment WHERE postID = \"" + postID + "\"";
            res = stmt.executeQuery(query);


            System.out.println("결과");
            while (res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Comment comment = new Comment();

                comment.setMemdberID(res.getString("memberID"));
                comment.setTEXT(res.getString("contents")); //모델이랑 이름이 좀 다름 주의..
                System.out.println(comment.getMemdberID() + "  " + comment.getTEXT());
                list.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

package db;

import model.Comment;

import java.sql.SQLException;
import java.util.ArrayList;


public class CommentDAO extends DBConnector
{
    public CommentDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //전체 조회
    public ArrayList<Comment> lookupCommentList()
    {
        try
        {
            String query="SELECT * FROM ccd.comment";
            res=stmt.executeQuery(query);

            ArrayList<Comment> list=new ArrayList<Comment>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Comment comment=new Comment();

                comment.setCommentID(res.getInt("commentID"));
                comment.setPostID(res.getInt("postID"));
                comment.setMemdberID(res.getString("memberID"));
                comment.setTEXT(res.getString("contents")); //모델이랑 이름이 좀 다름 주의..
                comment.setDate(res.getString("date"));

                list.add(comment);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //검색 - 키워드 : 댓글ID / 게시물ID / 사용자ID
    public ArrayList<Comment> searchCommentList(String c, String p, String m)
    {
        try
        {
            if(c==null && p==null && m==null)
            {
                lookupCommentList();
            }
            String query="SELECT * FROM ccd.comment where commentID like \"%"+c+"%\"and postID like \"%"+p+"%\" and memberID like \"%"+m+"%\"";

            res=stmt.executeQuery(query);
            ArrayList<Comment> list=new ArrayList<Comment>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Comment comment=new Comment();

                comment.setCommentID(res.getInt("commentID"));
                comment.setPostID(res.getInt("postID"));
                comment.setMemdberID(res.getString("memberID"));
                comment.setTEXT(res.getString("contents")); //모델이랑 이름이 좀 다름 주의..
                comment.setDate(res.getString("date"));

                list.add(comment);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //삭제
    public void deleteComment(String id)
    {
        System.out.println(id);

        int ID = Integer.parseInt(id);
        System.out.println(ID); //형변환 끝낸 댓글ID

        try
        {
            String query = "delete from ccd.comment where comment.commentID ="+ID;
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            System.out.println("Delete Success");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }
    //등록
    public boolean enrollComment(Comment comment) {
        try {
            String query = "INSERT INTO ccd.comment(TEXT) VALUES (?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,comment.getTEXT());

            pstmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    //수정
    public Comment modifyComment(Comment newC, Comment oldC) {
        try {
            pstmt = conn.prepareStatement("UPDATE ccd.comment SET TEXT=? and TEXT=?");

            pstmt.setString(1,newC.getTEXT());
            pstmt.setString(1,oldC.getTEXT());

            pstmt.executeUpdate();
            return newC;
        }catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

}

package db;

import model.Post;

import java.sql.SQLException;
import java.util.ArrayList;


public class PostDAO extends DBConnector
{
    public PostDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //게시물 정보 관리 클릭하자 마자 전체 회원 리스트 조회
    public ArrayList<Post> lookupPostList()
    {
        try
        {
            String query="SELECT * FROM ccd.post";
            res=stmt.executeQuery(query);

            ArrayList<Post> list=new ArrayList<Post>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Post post=new Post();

                post.setPostID(res.getInt("postID"));
                post.setForumID(res.getInt("forumID"));
                post.setMemberID(res.getString("memberID"));
                post.setTitle(res.getString("title"));
                post.setContents(res.getString("contents"));
                post.setNickname(res.getString("nickname"));
                post.setDate(res.getString("date"));

                list.add(post);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //게시판명, 게시물제목, 닉네임으로 검색
    public ArrayList<Post> searchPostList(String f, String p, String n)
    {
        try
        {
            if(f==null && p==null && n==null)
            {
                lookupPostList();
            }
            String query= "select postID, post.forumID, memberID, title, contents, nickname, date " +
                    "from post left join forum on forum.forumID = post.forumID " +
                    "where forumName like \"%"+f+"%\" and title like \"%"+p+"%\" and nickname like \"%"+n+"%\"";

            res=stmt.executeQuery(query);
            ArrayList<Post> list=new ArrayList<Post>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Post post=new Post();

                post.setPostID(res.getInt("postID"));
                post.setForumID(res.getInt("forumID"));
                post.setMemberID(res.getString("memberID"));
                post.setTitle(res.getString("title"));
                post.setContents(res.getString("contents"));
                post.setNickname(res.getString("nickname"));
                post.setDate(res.getString("date"));

                list.add(post);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //게시물 삭제
    public void deletePost(String id)
    {
        System.out.println(id);

        int ID = Integer.parseInt(id);
        System.out.println(ID);

        try
        {
            String query = "delete from ccd.post where post.postID ="+ID; //String일때는 / /로감싸줌
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

    //게시물 상세조회
    public ArrayList<Post> searchPostByTitle(String t)
    {
        try
        {
            String query= "SELECT * FROM ccd.post where title =\""+t+"\"";

            res=stmt.executeQuery(query);
            ArrayList<Post> list=new ArrayList<Post>();     //실행한 객체를 담을 list

            if (res.next())       //예외처리할려고 if로 변경함
            {
                Post post=new Post();

                post.setPostID(res.getInt("postID"));
                post.setForumID(res.getInt("forumID"));
                post.setMemberID(res.getString("memberID"));
                post.setTitle(res.getString("title"));
                post.setContents(res.getString("contents"));
                post.setNickname(res.getString("nickname"));
                post.setDate(res.getString("date"));

                list.add(post);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }
    //게시물 등록
    public boolean enrollPost(Post post) {
        try {
            String query = "INSERT INTO ccd.post(title, contents) VALUES (?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,post.getTitle());
            pstmt.setString(2,post.getContents());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    //게시물 수정
    public Post modifyPost(Post newP, Post oldP) {
        try {
            pstmt = conn.prepareStatement("UPDATE ccd.post SET title=?, contents=? and title=? and contents=?");

            pstmt.setString(1,newP.getTitle());
            pstmt.setString(2,newP.getContents());

            pstmt.setString(1,oldP.getTitle());
            pstmt.setString(2,oldP.getContents());

            pstmt.executeUpdate();
            return newP;
        }catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

}

package db;

import model.Forum;
import java.sql.SQLException;
import java.util.ArrayList;

public class ForumDAO extends DBConnector{
    public ForumDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //등록
    public void enrollForum(String t){
        System.out.println("등록할 게시판 이름 : "+t);
        try
        {
            String query = "INSERT INTO `ccd`.`forum` (`forumName`) VALUES ('"+t+"')";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            System.out.println("Enroll Success");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }

    public int getForumID(String name){
        try
        {
            String query="SELECT forumID FROM ccd.forum where forumName=\""+name+"\"";
            res=stmt.executeQuery(query);

            ArrayList<Forum> list=new ArrayList<Forum>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Forum forum = new Forum();

                forum.setForumID(res.getInt("forumID"));

                list.add(forum);
            }
            return list.get(0).getForumID(); //가장 첫번째의 ID 가져오기, 어차피 하나밖에 없음
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return -1;
        }
    }

    //수정
    public void modifyForum(int i, String a){
        try
        {
            String query="UPDATE `ccd`.`forum` SET `forumName` = '"+a+"' WHERE (`forumID` = '"+i+"')";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            System.out.println("Modify Success");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }


    //게시판 관리 클릭하자 마자 전체 리스트 조회
    public ArrayList<Forum> lookupForumList()
    {
        try
        {
            String query="SELECT * FROM ccd.forum";
            res=stmt.executeQuery(query);

            ArrayList<Forum> list=new ArrayList<Forum>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Forum forum = new Forum();

                forum.setForumID(res.getInt("forumID"));
                forum.setForumName(res.getString("forumName"));

                list.add(forum);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //게시판이름으로 검색
    public ArrayList<Forum> searchForumList(String t)
    {
        try
        {
            if(t==null)
            {
                lookupForumList();
            }
            String query= "SELECT * FROM ccd.forum WHERE forumName LIKE \"%"+ t +"%\"";
            res=stmt.executeQuery(query);
            ArrayList<Forum> list=new ArrayList<Forum>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Forum forum = new Forum();

                forum.setForumID(res.getInt("forumID"));
                forum.setForumName(res.getString("forumName"));

                list.add(forum);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //게시판 정보 삭제, forumName받아옴
    public void deleteForum(String name)
    {
        System.out.println(name);
        try
        {
            String query = "delete from ccd.forum where forum.forumName =\""+name+"\""; //String일때는 / /로감싸줌
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
}

package db;

import model.Member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class MemberDAO extends DBConnector
{
    public MemberDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //회원 정보 관리 클릭하자 마자 전체 회원 리스트 조회
    public ArrayList<Member> lookupMemberList()
    {
        try
        {
            String query="SELECT name, memberID, nickname, address FROM ccd.member";
            res=stmt.executeQuery(query);

            ArrayList<Member> list=new ArrayList<Member>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Member member=new Member();

                member.setName(res.getString("name"));
                member.setMemberID(res.getString("memberID"));
                member.setNickname(res.getString("nickname"));
                member.setAddress(res.getString("address"));

                list.add(member);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //회원이름, 닉네임으로 검색
    public ArrayList<Member> searchMemberList(String t, String a)
    {
        try
        {
            if(t==null && a==null)
            {
                lookupMemberList();
            }
            String query= "SELECT * FROM ccd.member WHERE name LIKE \"%"+ t +"%\" and nickname LIKE \"%"+ a +"%\"";
            res=stmt.executeQuery(query);
            ArrayList<Member> list=new ArrayList<Member>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Member member=new Member();

                member.setName(res.getString("name"));
                member.setMemberID(res.getString("memberID"));
                member.setNickname(res.getString("nickname"));
                member.setAddress(res.getString("address"));

                list.add(member);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //회원 정보 삭제
    public void deleteMemberInfo(String id)
    {
        System.out.println(id);
        try
        {
            String query = "delete from ccd.member where member.memberID =\""+id+"\""; //String일때는 / /로감싸줌
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

    //여기서부터 앱

    public Member login(String id, String pw) throws NamingException, SQLException {
        Context context = new InitialContext();
        String sql = "select * from ccd.member where memberID = \""+ id +"\" and memberPW = \"" + pw + "\"";

        res = stmt.executeQuery(sql);
        if(res.next()){
            String memberID = res.getString("memberID");
            String memberPW= res.getString("memberPW");
            String name= res.getString("name");
            String nickname= res.getString("nickname");
            String address= res.getString("address");
            return new Member(memberID,memberPW,name,nickname,address);
        }
        return null;
    }

    public boolean MemberEnroll(Member member)
    {
        try {
            String query = "INSERT INTO ccd.member(memberID, memberPW, name, nickname, address) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,member.getMemberID());
            pstmt.setString(2,member.getMemberPW());
            pstmt.setString(3,member.getName());
            pstmt.setString(4,member.getNickname());
            pstmt.setString(5,member.getAddress());

            System.out.println("query실행");
            pstmt.executeUpdate();
            System.out.println("query결과");
            return true;

        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        return false;
    }

    //회원 정보 수정
    public boolean MemberModify(Member newmember, Member oldmember)
    {
        try
        {
            pstmt = conn.prepareStatement("UPDATE ccd.member SET memberID=?, memberPW=?, name=?, nickname=?, address=? WHERE memberID=? and memberPW=? and name=? and nickname=? and address=?");

            pstmt.setString(1,newmember.getMemberID());
            pstmt.setString(2,newmember.getMemberPW());
            pstmt.setString(3,newmember.getName());
            pstmt.setString(4,newmember.getNickname());
            pstmt.setString(5,newmember.getAddress());

            pstmt.setString(6,oldmember.getMemberID());
            pstmt.setString(7,oldmember.getMemberPW());
            pstmt.setString(8,oldmember.getName());
            pstmt.setString(9,oldmember.getNickname());
            pstmt.setString(10,oldmember.getAddress());

            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }

        return false;
    }

    //회원 정보 삭제
    public boolean MemberDelete(String memberID)
    {
        try
        {
            String query = "DELETE FROM ccd.member WHERE memberID=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, memberID);
            pstmt.executeUpdate();

            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("error");
            return false;
        }
    }

//    public Member Memberlookup(HashMap<String,Object> condition)
//    {
//        try
//        {
//            String query="SELECT*FROM ccd.member"; //쿼리 수정해야되누
//            res=stmt.executeQuery(query);
//
//            if(res.next())       //얻어온 테이블의 행이 끝날때 까지
//            {
//                String memberID = res.getString(1);
//                String memberPW = res.getString(2);
//                String name = res.getString(3);
//                String nickname = res.getString(4);
//                String address = res.getString(5);
//
//                Member member = new Member(memberID, memberPW, name, nickname,address);
//                return member;
//            }
//            else
//                return null;
//
//        }
//        catch(SQLException e)
//        {
//            e.getStackTrace();
//            return null;
//        }
//    }
}

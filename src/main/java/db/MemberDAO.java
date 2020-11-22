package db;

import model.Member;
import java.sql.SQLException;
import java.util.ArrayList;


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

}

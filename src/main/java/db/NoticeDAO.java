package db;

import model.Forum;
import model.Notice;
import model.Post;

import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDAO extends DBConnector
{
    public NoticeDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //등록 - 키워드 : title, division, contents
    public void enrollNotice(String t, String d, String c){
        System.out.println("제목 : "+t);
        System.out.println("구분 : "+d);
        System.out.println("내용 : "+c);
        try
        {
            String query = "INSERT INTO `ccd`.`notice` (`title`, `division`, `contents`) VALUES (\""+t+"\", \""+d+"\",\""+c+"\")";
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

    //수정
    public void modifyNotice(String i, String nt, String nd, String nc){
        try
        {
            if(nt==null && nd==null && nc==null){
                return; //경고메시지를 출력하게 할 예정
            }

            String query="UPDATE `ccd`.`notice` SET `title` = \""+nt+"\", `division` = \""+nd+"\", `contents` = \""+nc+"\" WHERE (`noticeID` = \""+i+"\")";
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

    //id로 삭제
    public void deleteNotice(String id)
    {
        System.out.println(id);

        try
        {
            String query = "delete from ccd.notice where notice.noticeID =\""+id+"\"";
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

    //전체 리스트 조회
    public ArrayList<Notice> lookupNoticeList()
    {
        try
        {
            String query="SELECT * FROM ccd.notice";
            res=stmt.executeQuery(query);

            ArrayList<Notice> list=new ArrayList<Notice>();   //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Notice notice = new Notice();

                notice.setNoticeID(res.getInt("noticeID"));
                notice.setTitle(res.getString("title"));
                notice.setDivision(res.getString("division"));
                notice.setContents(res.getString("contents"));
                notice.setDate(res.getString("date"));

                list.add(notice);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //공지사항 상세조회
    public ArrayList<Notice> searchNoticeByTitle(String t)
    {
        try
        {
            String query= "SELECT * FROM ccd.notice where title =\""+t+"\"";

            res=stmt.executeQuery(query);
            ArrayList<Notice> list=new ArrayList<Notice>();     //실행한 객체를 담을 list

            if (res.next())     //예외처리할려고 if로 변경함
            {
                Notice notice=new Notice();

                notice.setNoticeID(res.getInt("noticeID"));
                notice.setTitle(res.getString("title"));
                notice.setDivision(res.getString("division"));
                notice.setContents(res.getString("contents"));
                notice.setDate(res.getString("date"));

                list.add(notice);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //조회
    public Notice lookupNotice(String t)
    {
        try
        {
            String query="SELECT * FROM ccd.notice where title =\""+t+"\"";
            res=stmt.executeQuery(query);

            Notice notice = new Notice();

            notice.setNoticeID(res.getInt("noticeID"));
            notice.setTitle(res.getString("title"));
            notice.setDivision(res.getString("division"));
            notice.setContents(res.getString("contents"));
            notice.setDate(res.getString("date"));

            return notice;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }
}

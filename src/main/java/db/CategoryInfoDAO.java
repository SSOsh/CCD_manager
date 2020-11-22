package db;

import model.CategoryInfo;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryInfoDAO extends DBConnector
{
    public CategoryInfoDAO() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //등록 : 키워드 - 카테고리 ID, name, depth1 2 3
    public void enrollCategoryInfo(String cid, String cn, String cd1, String cd2, String cd3)
    {
        try
        {
            if(cid!=null && cid!="") {
                String query = "INSERT INTO `ccd`.`categoryinfo` (`categoryID`, `categoryName`, `categoryDepth1`, `categoryDepth2`, `categoryDepth3`)" +
                        " VALUES (\"" + cid + "\", \"" + cn + "\",\"" + cd1 + "\",\"" + cd2 + "\",\"" + cd3 + "\")";
                pstmt = conn.prepareStatement(query);
                pstmt.executeUpdate();

                System.out.println("Enroll Success");
            }

            else System.out.println("You Need enter Primary Key");
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("SQL error");
        }
    }

    //수정 : 키워드 - 카테고리 ID
    public void modifyCategoryInfo(String cid, String cn, String cd1, String cd2, String cd3)
    {
        try
        {
            if(cn==null && cd1==null && cd2==null && cd3==null){
                return; //경고메시지를 출력하게 할 예정
            }

            String query="UPDATE `ccd`.`categoryinfo` SET `categoryName` = \""+cn+
                    "\", `categoryDepth1` = \""+cd1+
                    "\", `categoryDepth2` = \""+cd2+
                    "\", `categoryDepth3` = \""+cd3+
                    "\" WHERE (`categoryID` = \""+cid+"\")";
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

    //전체 조회
    public ArrayList<CategoryInfo> lookupCategoryInfoList()
    {
        try
        {
            String query="SELECT * FROM ccd.categoryinfo";
            res=stmt.executeQuery(query);

            ArrayList<CategoryInfo> list=new ArrayList<CategoryInfo>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                CategoryInfo ci = new CategoryInfo();

                ci.setCategoryID(res.getString("categoryID"));
                ci.setCategoryName(res.getString("categoryName"));
                ci.setCategoryDepth1(res.getString("categoryDepth1"));
                ci.setCategoryDepth2(res.getString("categoryDepth2"));
                ci.setCategoryDepth3(res.getString("categoryDepth3"));

                list.add(ci);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //검색 : 키워드 - 카테고리명, depth1 2 3
    public ArrayList<CategoryInfo> searchCategoryInfoList(String cn, String cd1, String cd2, String cd3)
    {
        try
        {
            if(cn==null && cd1==null && cd2==null && cd3==null)
            {
                lookupCategoryInfoList();
            }
            String query= "SELECT * FROM ccd.categoryinfo WHERE categoryName LIKE \"%"+ cn +
                    "%\" and categoryDepth1 LIKE \"%"+ cd1 +
                    "%\" and categoryDepth2 LIKE \"%"+cd2+
                    "%\" and categoryDepth3 LIKE \"%"+cd3+"%\"";

            res=stmt.executeQuery(query);
            ArrayList<CategoryInfo> list=new ArrayList<CategoryInfo>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                CategoryInfo ci = new CategoryInfo();

                ci.setCategoryID(res.getString("categoryID"));
                ci.setCategoryName(res.getString("categoryName"));
                ci.setCategoryDepth1(res.getString("categoryDepth1"));
                ci.setCategoryDepth2(res.getString("categoryDepth2"));
                ci.setCategoryDepth3(res.getString("categoryDepth3"));

                list.add(ci);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    //삭제 : 키워드 - 카테고리 ID
    public void deleteCategoryInfo(String cid)
    {
        try
        {
            String query = "delete from ccd.categoryinfo where categoryinfo.categoryID =\""+cid+"\"";
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

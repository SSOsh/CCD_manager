package controller.CategoryManagement;

import db.CategoryInfoDAO;
import model.CategoryInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ModifyCategory") //연동할 jsp 혹은 컨트롤러 명을 명시해주면 된다.
public class ModifyCategory extends HttpServlet
{
    CategoryInfoDAO dao= new CategoryInfoDAO();

    //doPost방식으로 하면 된다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setCharacterEncoding("utf-8");
        ArrayList<CategoryInfo> categoryInfoList;

        String modiID =(String) req.getSession().getAttribute("selected"); //세션에서 깨진 값 받아온다.

        System.out.println("입력받은 ID(깨질까유?) : "+modiID); //깨짐

        String cn = req.getParameter("mcn"); //카테고리명
        String cd1 = req.getParameter("mcd1"); //Depth1
        String cd2 =  req.getParameter("mcd2"); //Depth2
        String cd3 =  req.getParameter("mcd3"); //Depth3

        String encID=makeKOR(modiID); //밑에 정의된 인코딩함수 돌려준다.

        System.out.println("입력받은 ID(디코딩) : "+encID);

        //수정 실행
        dao.modifyCategoryInfo(encID,cn,cd1,cd2,cd3);

        //전체 조회로 리스트 받아옴
        categoryInfoList = dao.lookupCategoryInfoList();

        req.setAttribute("categoryInfoList",categoryInfoList);
        req.getRequestDispatcher("/CategoryView/categoryMain.jsp").forward(req,resp); //목적지 jsp로 받아온 값을 넘겨주는 것
    }

    String makeKOR(String str) throws java.io.UnsupportedEncodingException
    {
        String kor="";
        if(str==null)
            kor=null;
        else
            kor=new String(str.getBytes("ISO-8859-1"),"utf-8"); //바뀌면 에러나유
        return kor;
    }
}

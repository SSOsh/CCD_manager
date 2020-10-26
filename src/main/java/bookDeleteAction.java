import java.io.PrintWriter;

public class bookDeleteAction implements  Action{

    @Override
    public void excute(HttpservletRequest request, HttpSerbletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            request.setContentType("text/html; charset=utf-8");
            ServletContext context = request.getServletContext();
            String url = request.getRequestURI();
            String servletPath = request.getServletPath();
            String memberID = url.substring(servletPath.length()).split("/")[2];
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=utf-8");
            RequestDispatcher dispatcher = context.getRequestDispatcher("/bookManage"); //넘길 페이지 주소
            dispatcher.include(request, response);
            PrintWriter printWriter = response.getWriter();

            if(BookDAO.getInstance().delete(memberID) == true)
                printWriter.print("<script>alert('삭제되었습니다.')<script>");
            else
                printWriter.print("<script>alert('삭제에 실패했습니다.')<script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

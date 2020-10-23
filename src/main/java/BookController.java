import java.util.HashMap;

@WebSerblet()
public class BookController extends HttpServlet {

    HashMap<String, Action> list = null;
    @Override
    protected  void service(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        String servletPath = request.getServletPath();
        String path = url.substring(servletPath.length()).split("/")[1];

        HashMap<String, String> bookList = new HashMap<>();
        bookList.put("delete.do", "도서_삭제");
        bookList.put("lookup.do", "도서_조회");
    }

    public void init(ServletConfig sc) throws ServletException {
        list = new HashMap<>();
        list.put("delete.do", new BookDeleteAction());
        list.put("lookup.do", new BookLookupAction());
    }
}

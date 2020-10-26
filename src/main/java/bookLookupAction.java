//import java.util.HashMap;
//import javax.servlet.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class bookLookupAction implements Action {
//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.setCharacterEncoding("utf-8");
//            String[] condtionNames = {""};
//            HashMap<String, Object> condtions = new HashMap<>();
//            for(String condition : condtionNames) {
//                String value = request.getParameter(condition);
//                if(value != "") condtions.put(condition, value);
//            }
//            Book[] lookupResult = BookDAO.getInstance().lookup(condtions);
//            request.setAttribute("lookupResult", lookupResult);
//            ServletContext context = request.getServletContext();
//            RequestDispatcher dispatcher = context.getRequestDispatcher("/bookManage"); //넘길 페이지
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

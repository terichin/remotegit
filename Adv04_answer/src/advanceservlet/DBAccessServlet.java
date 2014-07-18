package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBAccessServlet
 */
@WebServlet("/dbaccess")
public class DBAccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // 決まった名前が付けられた入力パラメータを取得します
        String action = req.getParameter("action");
        // 入力パラメータの値によって、次に遷移するページを選びます
        String nextPage = null;
        if (action.equals("contactidinput")) {
            // contactidinputであれば、ContactFind.jspに遷移します
            nextPage = "/page/ContactFind.jsp";
        } else if (action.equals("contactmenu")) {
            // contactmenuであれば、AllContactFind.jspに遷移します
            nextPage = "/page/AllContactFind.jsp";
        }
        // 遷移先へのリクエストディスパッチャーを取得し、遷移します
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
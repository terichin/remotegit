package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EasyLogin2
 */
@WebServlet("/easylogin2")
public class EasyLogin2 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String user = req.getParameter("USERID");
        String password = req.getParameter("PASSWORD");
        String nextPage = "/html/LoginFail.html";
        if (user.equals("univ") && password.equals("hanako")) {
            // ÉçÉOÉCÉìê¨å˜
            nextPage = "/html/LoginSuccess.html";
        }
        // éüâÊñ Ç…ëJà⁄
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
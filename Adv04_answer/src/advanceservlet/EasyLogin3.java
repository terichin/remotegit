package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EasyLogin3
 */
@WebServlet("/easylogin3")
public class EasyLogin3 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // デフォルトの遷移先はログイン画面
        String nextPage = "/html/EasyLogin3.html";
        // セッションをチェックし、ログイン状態ならば成功画面へ
        if (checkSession(req)) {
            nextPage = "/html/LoginSuccess.html";
        }
        // 次画面に遷移
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String user = req.getParameter("USERID");
        String password = req.getParameter("PASSWORD");
        String nextPage = "/html/LoginFail.html";
        if (checkSession(req)) {
            // 過去にログインしているので成功画面へ
            nextPage = "/html/LoginSuccess.html";
        } else if (user.equals("univ") && password.equals("hanako")) {
            // ログイン成功: セッション作成＆成功画面
            HttpSession session = req.getSession(true);
            session.setAttribute("login_success", "welcome");
            nextPage = "/html/LoginSuccess.html";
        }
        // 次画面に遷移
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }

    private boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        // UserDTOが取得できない(null)時にはログインしているとは見なさない。
        String success = (String) session.getAttribute("login_success");
        if (success == null || !"welcome".equals(success)) {
            return false;
        } else {
            return true;
        }
    }
}
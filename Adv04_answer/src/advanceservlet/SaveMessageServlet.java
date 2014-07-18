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
 * Servlet implementation class SaveMessageServlet
 */
@WebServlet("/savemessage")
public class SaveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // 入力パラメータを取得する
        req.setCharacterEncoding("Windows-31J");
        String msg = req.getParameter("MESSAGE");
        // セッションを取得する
        HttpSession session = req.getSession(true);
        // セッションに入力パラメータを保存する
        session.setAttribute("message", msg);
        // 次の画面に遷移する
        RequestDispatcher rd = req.getRequestDispatcher("/page/PrintMessage.jsp");
        rd.forward(req, res);
    }
}
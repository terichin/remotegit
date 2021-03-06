package advanceservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import dao.NewContactDAO;
import dto.ContactDTO;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/dbservlet")
public class DBServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // 画面IDを取得する
        String action = req.getParameter("action");
        String nextPage = null;
        // 画面IDに応じて処理を分岐する
        if (action.equals("contactidinput3")) {
            String strId = req.getParameter("CONTACTID");
            try {
                int id = Integer.parseInt(strId);
                NewContactDAO dao = new NewContactDAO();
                ContactDTO dto = null;
                try {
                    dto = dao.getContact(id);
                    // セッションにDBから取得したDTOを格納する
                    HttpSession session = req.getSession(true);
                    session.setAttribute("contact_dto", dto);
                    // 次画面へ遷移
                    nextPage = "/page/PrintContact.jsp";
                } catch (DAOException e) {
                    e.printStackTrace();

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();

            }
        } else if (action.equals("contactmenu3")) {
            try {
                NewContactDAO dao = new NewContactDAO();
                ArrayList<ContactDTO> list = dao.getAllContact();
                // セッションに取得したリストを格納する
                HttpSession session = req.getSession(true);
                session.setAttribute("contact_list", list);
                // 次画面へ遷移
                nextPage = "/page/PrintAllContact.jsp";
            } catch (DAOException e) {
                e.printStackTrace();

            }
        }
        // 次画面へ遷移
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
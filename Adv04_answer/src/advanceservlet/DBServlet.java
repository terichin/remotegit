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
        // ‰æ–ÊID‚ğæ“¾‚·‚é
        String action = req.getParameter("action");
        String nextPage = null;
        // ‰æ–ÊID‚É‰‚¶‚Äˆ—‚ğ•ªŠò‚·‚é
        if (action.equals("contactidinput3")) {
            String strId = req.getParameter("CONTACTID");
            try {
                int id = Integer.parseInt(strId);
                NewContactDAO dao = new NewContactDAO();
                ContactDTO dto = null;
                try {
                    dto = dao.getContact(id);
                    // ƒZƒbƒVƒ‡ƒ“‚ÉDB‚©‚çæ“¾‚µ‚½DTO‚ğŠi”[‚·‚é
                    HttpSession session = req.getSession(true);
                    session.setAttribute("contact_dto", dto);
                    // Ÿ‰æ–Ê‚Ö‘JˆÚ
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
                // ƒZƒbƒVƒ‡ƒ“‚Éæ“¾‚µ‚½ƒŠƒXƒg‚ğŠi”[‚·‚é
                HttpSession session = req.getSession(true);
                session.setAttribute("contact_list", list);
                // Ÿ‰æ–Ê‚Ö‘JˆÚ
                nextPage = "/page/PrintAllContact.jsp";
            } catch (DAOException e) {
                e.printStackTrace();

            }
        }
        // Ÿ‰æ–Ê‚Ö‘JˆÚ
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
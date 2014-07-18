package advanceservlet;

import java.io.IOException;

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
 * Servlet implementation class DBContactServlet
 */
@WebServlet("/dbcontact")
public class DBContactServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        String strId = req.getParameter("CONTACTID");
        try {
            int id = Integer.parseInt(strId);
            NewContactDAO dao = new NewContactDAO();
            ContactDTO dto = null;
            try {
                dto = dao.getContact(id);
                // ƒZƒbƒVƒ‡ƒ“‚ÉDB‚©‚çŽæ“¾‚µ‚½DTO‚ðŠi”[‚·‚é
                HttpSession session = req.getSession(true);
                session.setAttribute("contact_dto", dto);
                // ŽŸ‰æ–Ê‚Ö‘JˆÚ
                RequestDispatcher rd = req.getRequestDispatcher("/page/PrintContact.jsp");
                rd.forward(req, res);
            } catch (DAOException e) {
                e.printStackTrace();
                
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            
        }
    }
}
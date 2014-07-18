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
 * Servlet implementation class DBAllContactServlet
 */
@WebServlet("/dballcontact")
public class DBAllContactServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            NewContactDAO dao = new NewContactDAO();
            ArrayList<ContactDTO> list = dao.getAllContact();
            // ƒZƒbƒVƒ‡ƒ“‚ÉŽæ“¾‚µ‚½ƒŠƒXƒg‚ðŠi”[‚·‚é
            HttpSession session = req.getSession(true);
            session.setAttribute("contact_list", list);
            // ŽŸ‰æ–Ê‚Ö‘JˆÚ
            RequestDispatcher rd = req.getRequestDispatcher("/page/PrintAllContact.jsp");
            rd.forward(req, res);
        } catch (DAOException e) {
            e.printStackTrace();
            
        }
    }
}
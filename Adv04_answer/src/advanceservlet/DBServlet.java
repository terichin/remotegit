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
        // ���ID���擾����
        String action = req.getParameter("action");
        String nextPage = null;
        // ���ID�ɉ����ď����𕪊򂷂�
        if (action.equals("contactidinput3")) {
            String strId = req.getParameter("CONTACTID");
            try {
                int id = Integer.parseInt(strId);
                NewContactDAO dao = new NewContactDAO();
                ContactDTO dto = null;
                try {
                    dto = dao.getContact(id);
                    // �Z�b�V������DB����擾����DTO���i�[����
                    HttpSession session = req.getSession(true);
                    session.setAttribute("contact_dto", dto);
                    // ����ʂ֑J��
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
                // �Z�b�V�����Ɏ擾�������X�g���i�[����
                HttpSession session = req.getSession(true);
                session.setAttribute("contact_list", list);
                // ����ʂ֑J��
                nextPage = "/page/PrintAllContact.jsp";
            } catch (DAOException e) {
                e.printStackTrace();

            }
        }
        // ����ʂ֑J��
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
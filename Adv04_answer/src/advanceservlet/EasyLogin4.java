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
import dao.NewEmployeeDAO;
import dto.EmployeeDTO;

/**
 * Servlet implementation class EasyLogin4
 */
@WebServlet("/easylogin4")
public class EasyLogin4 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // �f�t�H���g�̑J�ڐ�̓��O�C�����
        String nextPage = "/html/EasyLogin4.html";
        // �Z�b�V�������`�F�b�N���A���O�C����ԂȂ�ΐ�����ʂ�
        if (checkSession(req)) {
            nextPage = "/html/LoginSuccess.html";
        }
        // ����ʂɑJ��
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String nextPage = "/html/LoginFail.html";
        String user = req.getParameter("USERID");
        int id = Integer.parseInt(user);
        String password = req.getParameter("PASSWORD");
        try {
            // employee�e�[�u����������擾
            NewEmployeeDAO dao = new NewEmployeeDAO();
            EmployeeDTO dto = dao.getEmployee(id);
            String dbPassword = null;
            if (dto != null) {
                dbPassword = dto.getPassword();
            }
            if (checkSession(req)) {
                // �ߋ��Ƀ��O�C�����Ă���̂Ő�����ʂ�
                nextPage = "/html/LoginSuccess.html";
            } else if ((dbPassword != null) && (dbPassword.equals(password))) {
                // ���O�C������: �Z�b�V�����쐬���������
                HttpSession session = req.getSession(true);
                session.setAttribute("login_success", "welcome");
                nextPage = "/html/LoginSuccess.html";
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        // ����ʂɑJ��
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }

    private boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        // UserDTO���擾�ł��Ȃ�(null)���ɂ̓��O�C�����Ă���Ƃ͌��Ȃ��Ȃ��B
        String success = (String) session.getAttribute("login_success");
        if (success == null || !"welcome".equals(success)) {
            return false;
        } else {
            return true;
        }
    }
}
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
import dao.EmployeeInfoDAO;
import dao.NewContactDAO;
import dao.NewEmployeeDAO;
import dto.ContactDTO;
import dto.EmployeeDTO;
import dto.EmployeeInfoDTO;

/**
 * Servlet implementation class DBServlet2
 */
@WebServlet("/dbservlet2")
public class DBServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // �f�t�H���g�̑J�ڐ�̓��O�C�����
        String nextPage = "/html/DBServletLogin.html";

        // ����ʂɑJ��
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
        
        /*
         * �I�v�V�������H���4-3-3�p
         * // ���j���[��ʂ�\������
         * RequestDispatcher rd = req.getRequestDispatcher("/html/DBServletMenu.html");
         * rd.forward(req, res);
         */
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // ���ID���擾����
        String action = req.getParameter("action");
        // �Z�b�V�������`�F�b�N���A���O�C����ԂłȂ���΃��O�C����ʂ�
        if ((action.equals("dbservletlogin") != true) && (checkSession(req) != true)) {
            RequestDispatcher rd = req.getRequestDispatcher("/html/DBServletLogin.html");
            rd.forward(req, res);
            return;
        }
        String nextPage = null;
        // ���ID�ɉ����ď����𕪊򂷂�
        if (action.equals("dbservletlogin")) {
            nextPage = "/html/DBServletLogin.html";
            String strId = req.getParameter("USERID");
            String password = req.getParameter("PASSWORD");
            int id = Integer.parseInt(strId);
            NewEmployeeDAO dao = new NewEmployeeDAO();
            EmployeeDTO dto = null;
            try {
                dto = dao.getEmployee(id);
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
            String dbPassword = null;
            if (dto != null) {
                dbPassword = dto.getPassword();
            }
            if ((dbPassword != null) && (dbPassword.equals(password))) {
                // ���O�C������: �Z�b�V�����쐬���������
                HttpSession session = req.getSession(true);
                session.setAttribute("login_success", "welcome");
                nextPage = "/html/DBServletMenu.html";
            }
        } else if (action.equals("contact")) {
            nextPage = "/html/ContactIDInput4.html";
        } else if (action.equals("allcontact")) {
            nextPage = "/html/ContactMenu4.html";
        } else if (action.equals("employeeinfo")) {
            nextPage = "/html/EmployeeIDInput2.html";
        } else if (action.equals("allemployeeinfo")) {
            nextPage = "/html/EmployeeMenu2.html";
        } else if (action.equals("contactidinput3")) {
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
                    nextPage = "/html/DBServletError.html";
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
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
                nextPage = "/html/DBServletError.html";
            }
        } else if (action.equals("employeeidinput")) {
            String strId = req.getParameter("ID");
            try {
                // ���͂��ꂽID�Ɋ֘A����]�ƈ������Z�b�V�����Ɋi�[����
                getEmployeeInfo(req, strId);
                // ����ʂ֑J��
                nextPage = "/page/PrintEmployeeInfo.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        } else if (action.equals("employeemenu")) {
            try {
                // �S�]�ƈ������Z�b�V�����Ɋi�[����
                getAllEmployeeInfo(req);
                // ����ʂ֑J��
                nextPage = "/page/PrintAllEmployeeInfo.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        }
        // ����ʂ֑J��
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

    private void getEmployeeInfo(HttpServletRequest req, String strId)
            throws DAOException {
        int id = Integer.parseInt(strId);
        // DAO���g�p����DB����l��DTO�Ŏ擾����
        EmployeeInfoDAO dao = new EmployeeInfoDAO();
        EmployeeInfoDTO dto = null;
        dto = dao.getEmployeeInfo(id);
        // �Z�b�V�����Ɏ擾�������X�g���i�[����
        HttpSession session = req.getSession(true);
        session.setAttribute("employeeinfo_dto", dto);
    }

    private void getAllEmployeeInfo(HttpServletRequest req)
            throws DAOException {
        EmployeeInfoDAO dao = new EmployeeInfoDAO();
        // DAO���畡����DTO�I�u�W�F�N�g���擾���܂�
        ArrayList<EmployeeInfoDTO> list = dao.getAllEmployeeInfo();
        // �Z�b�V�����Ɏ擾�������X�g���i�[����
        HttpSession session = req.getSession(true);
        session.setAttribute("employeeinfo_list", list);
    }
}
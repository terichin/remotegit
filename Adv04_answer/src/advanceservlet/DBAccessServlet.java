package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBAccessServlet
 */
@WebServlet("/dbaccess")
public class DBAccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // ���܂������O���t����ꂽ���̓p�����[�^���擾���܂�
        String action = req.getParameter("action");
        // ���̓p�����[�^�̒l�ɂ���āA���ɑJ�ڂ���y�[�W��I�т܂�
        String nextPage = null;
        if (action.equals("contactidinput")) {
            // contactidinput�ł���΁AContactFind.jsp�ɑJ�ڂ��܂�
            nextPage = "/page/ContactFind.jsp";
        } else if (action.equals("contactmenu")) {
            // contactmenu�ł���΁AAllContactFind.jsp�ɑJ�ڂ��܂�
            nextPage = "/page/AllContactFind.jsp";
        }
        // �J�ڐ�ւ̃��N�G�X�g�f�B�X�p�b�`���[���擾���A�J�ڂ��܂�
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
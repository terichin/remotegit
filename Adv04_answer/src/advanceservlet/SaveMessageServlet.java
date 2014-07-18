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
        // ���̓p�����[�^���擾����
        req.setCharacterEncoding("Windows-31J");
        String msg = req.getParameter("MESSAGE");
        // �Z�b�V�������擾����
        HttpSession session = req.getSession(true);
        // �Z�b�V�����ɓ��̓p�����[�^��ۑ�����
        session.setAttribute("message", msg);
        // ���̉�ʂɑJ�ڂ���
        RequestDispatcher rd = req.getRequestDispatcher("/page/PrintMessage.jsp");
        rd.forward(req, res);
    }
}
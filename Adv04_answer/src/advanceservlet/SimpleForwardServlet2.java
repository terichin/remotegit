package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleForwardServlet2
 */
@WebServlet("/simpleforward2")
public class SimpleForwardServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// �J�ڐ�ւ̃��N�G�X�g�f�B�X�p�b�`���[���擾���܂�
		RequestDispatcher rd = req.getRequestDispatcher("/page/MessagePrint2.jsp");
		// �J�ڂ��鎞��HttpServletRequest�AHttpServletResponse��n���܂�
		rd.forward(req, res);
	}
}
package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			// �J�ڐ�ւ̃��N�G�X�g�f�B�X�p�b�`���[���擾���܂�
			RequestDispatcher rd = req.getRequestDispatcher("/page/Hello.jsp");
			// ���N�G�X�g�f�B�X�p�b�`���[���g�p���đJ�ڂ��܂�
			rd.forward(req, res);
		}
	}
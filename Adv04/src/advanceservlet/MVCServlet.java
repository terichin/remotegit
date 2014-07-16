package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcservlet")
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.setCharacterEncoding("Windows-31J");
			// ���܂������O���t����ꂽ���̓p�����[�^���擾���܂�
			String action = req.getParameter("action");
			// ���̓p�����[�^�̒l�ɂ���āA���ɑJ�ڂ���y�[�W��I�т܂�
			String nextPage = null;
			if (action.equals("page1")) {
				// page1�ł���΁AHello.jsp�ɑJ�ڂ��܂�
				nextPage = "/page/Hello.jsp";
			} else if (action.equals("page2")) {
				// page2�ł���΁AMessagePrint.jsp�ɑJ�ڂ��܂�
				nextPage = "/page/MessagePrint.jsp";
			}
			// �J�ڐ�ւ̃��N�G�X�g�f�B�X�p�b�`���[���擾���A�J�ڂ��܂�
			RequestDispatcher rd = req.getRequestDispatcher(nextPage);
			rd.forward(req, res);
		}
	}
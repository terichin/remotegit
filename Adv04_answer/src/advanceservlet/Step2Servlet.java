package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step2")
public class Step2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			// ���͕�������擾����
			req.setCharacterEncoding("Windows-31J");
			String msg = req.getParameter("MESSAGE");
			// �Z�b�V�����I�u�W�F�N�g���擾����
			HttpSession session = req.getSession(true);
	                // �Z�b�V�����I�u�W�F�N�g�ɓ��͕������ۑ�����
			session.setAttribute("KeyMessage", msg);

			// JSP�ɑJ�ڂ���
			RequestDispatcher rd = req.getRequestDispatcher("/page/Step3.jsp");
			rd.forward(req, res);
		}
	}
package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessagePrintServlet2
 */
@WebServlet("/messageprint2")
//�u���E�U���玁�����󂯎���ĕ\������v���O����
public class MessagePrintServlet2 extends HttpServlet {
	// form����f�[�^���󂯎��ꍇ��doPost���I�[�o�[���C�h���܂�
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		// ���̓p�����[�^�̓��{��R�[�h��Windows-31J�ɐݒ肵�܂�
		req.setCharacterEncoding("Windows-31J");
		// ���̓p�����[�^���擾���A�ϐ��ɕۑ����܂�
		String firstName = req.getParameter("FIRSTNAME");
		String lastName = req.getParameter("LASTNAME");
		res.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>MessagePrintServlet2</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// �ۑ������ϐ��̒l��\�����܂�
		out.println("����ɂ��́A" + lastName + " " + firstName + "����B");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}

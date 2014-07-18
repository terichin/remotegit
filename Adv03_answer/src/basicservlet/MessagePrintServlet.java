package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�u���E�U����̓��͂��󂯎���ĕ\������v���O����
@WebServlet("/messageprint")
public class MessagePrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		// ���̓p�����[�^�̓��{��R�[�h��Windows-31J�ɐݒ肵�܂�
		req.setCharacterEncoding("Windows-31J");
		// ���̓p�����[�^���擾���A�ϐ��ɕۑ����܂�
		String msg = req.getParameter("MESSAGE");
		res.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>MessagePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// �ۑ������ϐ��̒l��\�����܂�
		out.println("���͂������b�Z�[�W�́u" + msg + "�v�ł��ˁB");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}
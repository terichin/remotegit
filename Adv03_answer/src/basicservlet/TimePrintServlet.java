package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Web�u���E�U�Ɍ�������\������v���O����
//�T�[�u���b�g�Ȃ̂ŁAHttpServlet���p�����č��܂�
@WebServlet("/timeprint")
public class TimePrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// �T�[�u���b�g�Ŏ��s���邱�Ƃ�doGet���I�[�o�[���C�h���ċL�q���܂�
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �������̏����擾���܂�
		Date date = new Date();
		// �o�͂�����{��R�[�h��Windows-31J�ɐݒ肵�܂�
		res.setContentType("text/html; charset=Windows-31J");
		// �u���E�U�ւ̏o�̓X�g���[�����m�ۂ��܂�
		PrintWriter out = res.getWriter();
		// �u���E�U��HTML�𑗂�܂�
		out.println("<html>");
		out.println("<head><title>TimePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// ������񕔕��ɂ͕ϐ�(date)���g�p���܂�
		out.println("���݂̎�����" + date + "�ł��B");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		// �o�̓X�g���[����ؒf���܂�
		out.close();
	}

}

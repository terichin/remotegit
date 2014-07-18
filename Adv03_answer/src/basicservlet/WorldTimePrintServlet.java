package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorldTimePrintServlet
 */
@WebServlet("/worldtimeprint")
//Web�u���E�U�ɓ��{�W�����Ɛ��E�W�����̌�������\������v���O����
//�T�[�u���b�g�Ȃ̂ŁAHttpServlet���p�����č��܂�
public class WorldTimePrintServlet extends HttpServlet {
	// �T�[�u���b�g�Ŏ��s���邱�Ƃ�doGet���I�[�o�[���C�h���ċL�q���܂�
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// �������̏����擾���܂�
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int h = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int m = cal.get(java.util.Calendar.MINUTE);
		int s = cal.get(java.util.Calendar.SECOND);
		// ���{�W�����̕�������쐬���܂�
		String time_local = h + ":" + m + ":" + s;
		// ���E�W���������߂܂�
		int wh = h - 9;
		// �������}�C�i�X�̎��͕␳����
		if (wh < 0) {
			wh +=24;
		}
		// ���E�W�����̕�������쐬���܂�
		String time_world = wh + ":" + m + ":" + s;
		// �o�͂�����{��R�[�h��Windows-31J�ɐݒ肵�܂�
		res.setContentType("text/html; charset=Windows-31J");
		// �u���E�U�ւ̏o�͘H���m�ۂ��܂�
		PrintWriter out = res.getWriter();
		// �u���E�U��HTML�𑗂�܂�
		out.println("<html>");
		out.println("<head><title>WorldTimePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// ������񕔕��ɂ͕ϐ�(time_local��time_world)���g�p���܂�
		out.println("���{�W�����̌��ݎ�����" + time_local + "�ł��B");
		out.println("<br>");
		out.println("���E�W�����̌��ݎ�����" + time_world + "�ł��B");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		// �o�̓X�g���[����ؒf���܂�
		out.close();
	}
}

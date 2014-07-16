package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//2�̐��l���󂯎��A�����Z�̌��ʂ�\������v���O����
@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		// 2�̓��͒l���擾���܂�
		String strNum1 = req.getParameter("NUM1");
		String strNum2 = req.getParameter("NUM2");
		try {
			// �擾�������͒l��int�^�ɕϊ����܂�
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			// �擾����2��int�^�̒l�����Z���܂�
			int total = num1 + num2;
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			// �v�Z�������v�l��\�����܂�
			out.println("���v�l��" + total + "�ł��B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		// ���͒l�𐔒l�ɕϊ��ł��Ȃ������ꍇ�̏���
		} catch (NumberFormatException e) {
			// �X�^�b�N�g���[�X���o�͂��܂�
			e.printStackTrace();
			// �G���[��ʂ�\�����܂�
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("���͍��ڂɂ͐��������Ă��������B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}
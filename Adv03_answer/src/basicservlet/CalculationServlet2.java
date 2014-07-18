package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculationServlet2
 */
@WebServlet("/calculation2")
//���z���󂯎��A����ł̋��z�v�Z���s���v���O����
public class CalculationServlet2 extends HttpServlet {
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		// ���z���擾���܂�
		String strPrice = req.getParameter("PRICE");
		try {
			// �擾�������͒l��int�^�ɕϊ����܂�
			int price = Integer.parseInt(strPrice);
			// ���͋��z�̐Ŋz���v�Z���܂�
			int tax = (int) (price * 0.05);
			// �擾����2��int�^�̒l�����Z���܂�
			int total = price + tax;
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet2</title></head>");
			out.println("<body>");
			out.println("<h2>");
			// �v�Z�������v�l��\�����܂�
			out.println("���i�́@" + price + "�~<br>");
			out.println("�Ŋz�́@" + tax + "�~<br>");
			out.println("���v�l��" + total + "�~<br>");
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
			out.println("<head><title>CalculationServlet2</title></head>");
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
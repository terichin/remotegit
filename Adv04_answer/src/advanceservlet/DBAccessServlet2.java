package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBAccessServlet2
 */
@WebServlet("/dbaccess2")
public class DBAccessServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// メニュー画面を表示する
		RequestDispatcher rd = req.getRequestDispatcher("/html/DBAccessMenu.html");
		rd.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		// 決まった名前が付けられた入力パラメータを取得します
		String action = req.getParameter("action");
		// 入力パラメータの値によって、次に遷移するページを選びます
		String nextPage = null;
		if (action.equals("contact")) {
			nextPage = "/html/ContactIDInput.html";
		} else if (action.equals("allcontact")) {
			nextPage = "/html/ContactMenu.html";
		} else if (action.equals("employeeinfo")) {
			nextPage = "/html/EmployeeIDInput.html";
		} else if (action.equals("allemployeeinfo")) {
			nextPage = "/html/EmployeeMenu.html";
		} else if (action.equals("contactidinput")) {
			// contactidinputであれば、ContactFind.jspに遷移します
			nextPage = "/page/ContactFind.jsp";
		} else if (action.equals("contactmenu")) {
			// contactmenuであれば、AllContactFind.jspに遷移します
			nextPage = "/page/AllContactFind.jsp";
		} else if (action.equals("employeeidinput")) {
			// employeeidinputであれば、EmployeeInfo.jspに遷移します
			nextPage = "/page/EmployeeInfo.jsp";
		} else if (action.equals("employeemenu")) {
			// employeemenuであれば、AllEmployeeInfo.jspに遷移します
			nextPage = "/page/AllEmployeeInfo.jsp";
		}
		// 遷移先へのリクエストディスパッチャーを取得し、遷移します
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
	}
}
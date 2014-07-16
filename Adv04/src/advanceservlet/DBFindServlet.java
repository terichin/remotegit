package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import dao.NewEmployeeDAO;
import dto.EmployeeDTO;

@WebServlet("/dbfind")
public class DBFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // ボタン名を取得する
        String action = req.getParameter("action");
        String nextPage = null;
        // ボタン名で処理を分離する
        if (action.equals("namefind")) {
            int id = -1;
            id = Integer.parseInt(req.getParameter("USERID"));
            NewEmployeeDAO dao = new NewEmployeeDAO();
            String dbname = null;
            try {
                dbname = dao.getName(id);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("name", dbname);
            nextPage = "/page/NameFind.jsp";
        } else if (action.equals("employeefind")) {
            int id = -1;
            id = Integer.parseInt(req.getParameter("USERID"));
            NewEmployeeDAO dao = new NewEmployeeDAO();
            EmployeeDTO dto = null;
            try {
                dto = dao.getEmployee(id);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("employee", dto);
            nextPage = "/page/EmployeeFind.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
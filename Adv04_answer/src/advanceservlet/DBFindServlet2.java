package advanceservlet;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/dbfind2")
public class DBFindServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        String action = req.getParameter("action");
        String nextPage = null;
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
        } else if (action.equals("allemployeefind")) {
            NewEmployeeDAO dao = new NewEmployeeDAO();
            try {
                ArrayList<EmployeeDTO> list = dao.getAllEmployee();
                HttpSession session = req.getSession(true);
                session.setAttribute("employee_list", list);
                nextPage = "/page/AllEmployeeFind.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }
}
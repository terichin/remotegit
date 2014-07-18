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
import dao.EmployeeInfoDAO;
import dao.NewContactDAO;
import dao.NewEmployeeDAO;
import dto.ContactDTO;
import dto.EmployeeDTO;
import dto.EmployeeInfoDTO;

/**
 * Servlet implementation class DBServlet2
 */
@WebServlet("/dbservlet2")
public class DBServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // デフォルトの遷移先はログイン画面
        String nextPage = "/html/DBServletLogin.html";

        // 次画面に遷移
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
        
        /*
         * オプション実践問題4-3-3用
         * // メニュー画面を表示する
         * RequestDispatcher rd = req.getRequestDispatcher("/html/DBServletMenu.html");
         * rd.forward(req, res);
         */
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        // 画面IDを取得する
        String action = req.getParameter("action");
        // セッションをチェックし、ログイン状態でなければログイン画面へ
        if ((action.equals("dbservletlogin") != true) && (checkSession(req) != true)) {
            RequestDispatcher rd = req.getRequestDispatcher("/html/DBServletLogin.html");
            rd.forward(req, res);
            return;
        }
        String nextPage = null;
        // 画面IDに応じて処理を分岐する
        if (action.equals("dbservletlogin")) {
            nextPage = "/html/DBServletLogin.html";
            String strId = req.getParameter("USERID");
            String password = req.getParameter("PASSWORD");
            int id = Integer.parseInt(strId);
            NewEmployeeDAO dao = new NewEmployeeDAO();
            EmployeeDTO dto = null;
            try {
                dto = dao.getEmployee(id);
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
            String dbPassword = null;
            if (dto != null) {
                dbPassword = dto.getPassword();
            }
            if ((dbPassword != null) && (dbPassword.equals(password))) {
                // ログイン成功: セッション作成＆成功画面
                HttpSession session = req.getSession(true);
                session.setAttribute("login_success", "welcome");
                nextPage = "/html/DBServletMenu.html";
            }
        } else if (action.equals("contact")) {
            nextPage = "/html/ContactIDInput4.html";
        } else if (action.equals("allcontact")) {
            nextPage = "/html/ContactMenu4.html";
        } else if (action.equals("employeeinfo")) {
            nextPage = "/html/EmployeeIDInput2.html";
        } else if (action.equals("allemployeeinfo")) {
            nextPage = "/html/EmployeeMenu2.html";
        } else if (action.equals("contactidinput3")) {
            String strId = req.getParameter("CONTACTID");
            try {
                int id = Integer.parseInt(strId);
                NewContactDAO dao = new NewContactDAO();
                ContactDTO dto = null;
                try {
                    dto = dao.getContact(id);
                    // セッションにDBから取得したDTOを格納する
                    HttpSession session = req.getSession(true);
                    session.setAttribute("contact_dto", dto);
                    // 次画面へ遷移
                    nextPage = "/page/PrintContact.jsp";
                } catch (DAOException e) {
                    e.printStackTrace();
                    nextPage = "/html/DBServletError.html";
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        } else if (action.equals("contactmenu3")) {
            try {
                NewContactDAO dao = new NewContactDAO();
                ArrayList<ContactDTO> list = dao.getAllContact();
                // セッションに取得したリストを格納する
                HttpSession session = req.getSession(true);
                session.setAttribute("contact_list", list);
                // 次画面へ遷移
                nextPage = "/page/PrintAllContact.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        } else if (action.equals("employeeidinput")) {
            String strId = req.getParameter("ID");
            try {
                // 入力されたIDに関連する従業員情報をセッションに格納する
                getEmployeeInfo(req, strId);
                // 次画面へ遷移
                nextPage = "/page/PrintEmployeeInfo.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        } else if (action.equals("employeemenu")) {
            try {
                // 全従業員情報をセッションに格納する
                getAllEmployeeInfo(req);
                // 次画面へ遷移
                nextPage = "/page/PrintAllEmployeeInfo.jsp";
            } catch (DAOException e) {
                e.printStackTrace();
                nextPage = "/html/DBServletError.html";
            }
        }
        // 次画面へ遷移
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, res);
    }

    private boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        // UserDTOが取得できない(null)時にはログインしているとは見なさない。
        String success = (String) session.getAttribute("login_success");
        if (success == null || !"welcome".equals(success)) {
            return false;
        } else {
            return true;
        }
    }

    private void getEmployeeInfo(HttpServletRequest req, String strId)
            throws DAOException {
        int id = Integer.parseInt(strId);
        // DAOを使用してDBから値をDTOで取得する
        EmployeeInfoDAO dao = new EmployeeInfoDAO();
        EmployeeInfoDTO dto = null;
        dto = dao.getEmployeeInfo(id);
        // セッションに取得したリストを格納する
        HttpSession session = req.getSession(true);
        session.setAttribute("employeeinfo_dto", dto);
    }

    private void getAllEmployeeInfo(HttpServletRequest req)
            throws DAOException {
        EmployeeInfoDAO dao = new EmployeeInfoDAO();
        // DAOから複数のDTOオブジェクトを取得します
        ArrayList<EmployeeInfoDTO> list = dao.getAllEmployeeInfo();
        // セッションに取得したリストを格納する
        HttpSession session = req.getSession(true);
        session.setAttribute("employeeinfo_list", list);
    }
}
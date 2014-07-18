package control.action;
import javax.servlet.http.*;
import control.dao.*;

public interface Action {
    boolean check(HttpServletRequest req);
    String execute(HttpServletRequest req) throws DAOException;
}

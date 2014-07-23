import java.sql.*;
import univelec.dao.*;
import univelec.dto.*;

public class OrderDAOAdd {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			OrderDTO dto = new OrderDTO(1, "SHARP Mebius", 1, 1, now);
			int result = dao.add(dto);
			System.out.println("íçï∂î‘çÜÇÕ" + result + "Ç≈Ç∑ÅB");
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

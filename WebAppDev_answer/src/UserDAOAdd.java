import univelec.dao.*;
import univelec.dto.*;

public class UserDAOAdd {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO("NTTå‹òY", "NTTÇ≤ÇÎÇ§", "03-9999-8765", "goro@example.com", "test", 0);
			int result = dao.add(dto);
			if (result == 1) { 
				System.out.println("í«â¡Ç…ê¨å˜ÇµÇ‹ÇµÇΩÅB");
			} else {
				System.out.println("í«â¡Ç…é∏îsÇµÇ‹ÇµÇΩÅB");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

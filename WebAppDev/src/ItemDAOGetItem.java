import univelec.dao.*;
import univelec.dto.*;

public class ItemDAOGetItem {
	public static void main(String[] args) {
		try {
			ItemDAO dao = new ItemDAO();
			ItemDTO dto = dao.getItem(2);
			if (dto != null) {
				System.out.println("”Ô†\t¤•i–¼\t\t‰¿Ši");
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.println(dto.getPrice());
			} else {
				System.out.println("¤•iî•ñ‚Ìæ“¾‚É¸”s‚µ‚Ü‚µ‚½B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

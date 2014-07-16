import java.util.*;
import univelec.dao.*;
import univelec.dto.*;

public class ItemDAOGetItemList {
	public static void main(String[] args) {
		try {
			ItemDAO dao = new ItemDAO();
			ArrayList<ItemDTO> list = dao.getItemList(1);
			System.out.println("î‘çÜ\tè§ïiñº\t\tâøäi");
			for (int i = 0; i < list.size(); i++) {
				ItemDTO dto = list.get(i);
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.println(dto.getPrice());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

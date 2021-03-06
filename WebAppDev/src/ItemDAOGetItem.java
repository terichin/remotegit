import univelec.dao.*;
import univelec.dto.*;

public class ItemDAOGetItem {
	public static void main(String[] args) {
		try {
			ItemDAO dao = new ItemDAO();
			ItemDTO dto = dao.getItem(2);
			if (dto != null) {
				System.out.println("番号\t商品名\t\t価格");
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.println(dto.getPrice());
			} else {
				System.out.println("商品情報の取得に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

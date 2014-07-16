import univelec.dao.*;
import univelec.dto.*;

public class OrderDAOGetOrder {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			OrderDTO dto = dao.getOrder(10);
			if (dto != null) {
				System.out.println("番号\t品番号\t商品名\t\t注文数\tユーザ\t注文日時");
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getItemNo() + "\t");
				System.out.print(dto.getItemName() + "\t");
				System.out.print(dto.getQuantity() + "\t");
				System.out.print(dto.getUserId() + "\t");
				System.out.println(dto.getOrderDate() + "\t");
			} else {
				System.out.println("注文情報の取得に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

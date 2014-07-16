import java.util.*;
import univelec.dao.*;
import univelec.dto.*;

public class OrderDAOGetOrderList {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			ArrayList<OrderDTO> list = dao.getOrderList(1);
			System.out.println("番号\t品番号\t商品名\t\t注文数\tユーザ\t注文日時");
			for (int i = 0; i < list.size(); i++) {
				OrderDTO dto = list.get(i);
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getItemNo() + "\t");
				System.out.print(dto.getItemName() + "\t");
				System.out.print(dto.getQuantity() + "\t");
				System.out.print(dto.getUserId() + "\t");
				System.out.println(dto.getOrderDate() + "\t");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

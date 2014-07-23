import univelec.dao.*;
import univelec.dto.*;

public class OrderDAOGetOrder {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			OrderDTO dto = dao.getOrder(10);
			if (dto != null) {
				System.out.println("�ԍ�\t�i�ԍ�\t���i��\t\t������\t���[�U\t��������");
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getItemNo() + "\t");
				System.out.print(dto.getItemName() + "\t");
				System.out.print(dto.getQuantity() + "\t");
				System.out.print(dto.getUserId() + "\t");
				System.out.println(dto.getOrderDate() + "\t");
			} else {
				System.out.println("�������̎擾�Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

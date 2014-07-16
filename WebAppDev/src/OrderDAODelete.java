import univelec.dao.*;

public class OrderDAODelete {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			int result = dao.delete(10);
			if (result == 1) {
				System.out.println("注文情報を削除に成功しました。");
			} else {
				System.out.println("注文情報を削除に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

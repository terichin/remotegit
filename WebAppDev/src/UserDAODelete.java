import univelec.dao.*;

public class UserDAODelete {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			// 適当なユーザを登録してから削除を実行してください
			int result = dao.delete(5);
			if (result == 1) { 
				System.out.println("削除に成功しました。");
			} else {
				System.out.println("削除に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

import univelec.dao.*;

public class OrderDAODelete {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			int result = dao.delete(10);
			if (result == 1) {
				System.out.println("’•¶î•ñ‚ğíœ‚É¬Œ÷‚µ‚Ü‚µ‚½B");
			} else {
				System.out.println("’•¶î•ñ‚ğíœ‚É¸”s‚µ‚Ü‚µ‚½B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

import dao.ContactDAO;

// ContactDAOクラスを利用し、contactテーブルにアクセスするプログラム
public class ContactDAOGetExtension {
	public static void main(String[] args) {
		ContactDAO dao = new ContactDAO();
		int extension = dao.getExtension(100);
		if (extension == -1) {
        	System.out.println("指定されたIDが見つかりません。");
		} else {
			System.out.println("ID100の内線番号は" + extension + "です。");
		}
	}
}
import dao.DAOException;
import dao.NewContactDAO;

// ContactDAOクラスを使用し、CONTACTテーブルのデータの
// 追加・参照を実行するプログラム
public class NewContactDAOGetExtension {	
	public static void main(String[] args) {
		try {
			NewContactDAO dao = new NewContactDAO();
			int extension = dao.getExtension(100);
			if (extension == -1) {
            	System.out.println("指定されたIDが見つかりません。");
			} else {
				System.out.println("ID100の内線番号は" + extension + "です。");
			}
		} catch (DAOException e) {
        	System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}
import dao.*;

// PostDAOクラスを使用し、postテーブルのデータの
// 追加を実行するプログラム
public class PostDAOAdd {
	// PostDAOクラスのadd()メソッドを呼び出して実行するmain()メソッド
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			String postname = args[1];
			int bossid = Integer.parseInt(args[2]);
			PostDAO dao = new PostDAO();
			int result = dao.add(id, postname, bossid);
			
			if (result == 1) {
	        	System.out.println("追加に成功しました");
			} else {
				System.out.println("追加に失敗しました");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("追加するデータを引数で渡す必要があります。");
		} catch (NumberFormatException e) {
			System.out.println("IDと上長IDは整数で渡す必要があります。");
		}
	}
}
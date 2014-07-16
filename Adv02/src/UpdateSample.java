import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// employeeテーブルの１件のデータのパスワードを変更するプログラム
public class UpdateSample {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    // ResultSetは必要ありません
	    
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// レコード修正を行うための準備をする
			pstmt = conn.prepareStatement("UPDATE EMPLOYEE SET PASSWORD=? WHERE ID=?");
			// 修正条件をSQL文に追加する
			pstmt.setString(1, args[1]);				// 最初の項目は新しいパスワード
			pstmt.setInt(2, Integer.parseInt(args[0]));	// 次の項目がID
			// UPDATE実行
			// 修正するレコードが見つからない時も例外は発生しません
			int count = pstmt.executeUpdate();
			// 戻り値の値が 1 なら1件修正されたことになります
			if (count == 1) {
				System.out.println("1件のデータを更新しました。");
			} else {
				System.out.println("指定されたIDのレコードが存在しません。");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("更新するIDとパスワードを引数で与える必要があります。");
		} catch (NumberFormatException e) {
			System.out.println("更新するIDは数値でなければなりません。");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
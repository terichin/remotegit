import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// employeeテーブルへ１件のデータ挿入を行うプログラム
public class InsertSample {
	private static final String DB_PASSWORD = "postgres";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
//	private static final String DB_USER = "postgres";
	private static final String DB_USER = "Univ2014";
	private static final String DRIVER_NAME = "org.postgresql.Driver";

	public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    // ResultSetは必要ありません
	    
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// データ挿入を行うための準備をする
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
			// 挿入条件をSQL文に追加する
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			// INSERT実行
			// 失敗時は SQLException が発生します
			int count = pstmt.executeUpdate();

			System.out.println("1件のデータを追加しました。");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("データの挿入に失敗しました。");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("与えられたデータ項目の数が足りません。");
		} catch (NumberFormatException e) {
			System.out.println("IDは数値でなければなりません。");
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
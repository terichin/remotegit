import java.sql.*;

// employeeテーブルの内容を全て表示するプログラム
public class BasicSample {
	// JDBCドライバ名
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	// データベース接続URL
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	// データベース接続ユーザ
	private static final String DB_USER = "postgres";
	// データベース接続パスワード
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	// mainメソッド・プログラムはここから開始します
	public static void main(String[] args) {
		// DB接続のためのオブジェクト変数の宣言
		Connection conn = null;
		// ステートメントオブジェクト変数の宣言
	    PreparedStatement pstmt = null;
	    // 検索結果が格納されるオブジェクト変数の宣言
	    ResultSet rs = null;
		try {
			// JDBCドライバの初期化を行う命令
			Class.forName(DRIVER_NAME);
			// DBへの接続を行う命令
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// クエリを行うための準備をする
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			// クエリの実行
			rs = pstmt.executeQuery();
			// タイトルの表示
			System.out.println("ID\tPASS\tNAME");
			// 検索結果の取り出し（検索された件数分繰り返す）
			while (rs.next()) {
				// リザルトセットから１行分のデータを取り出す
                int id = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                // 取り出したデータを表示する
                System.out.println(id + "\t" + password + "\t" + username);
            }
		// JDBCドライバの読み込みに失敗した場合の例外
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		// DBアクセスに伴う例外
		} catch (SQLException e) {
			e.printStackTrace();
		// 正常時・例外時を問わず行われる処理
		} finally {
			// DBの切断を行う
			try {
				// コネクションオブジェクトが存在する場合のみクローズを行う
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
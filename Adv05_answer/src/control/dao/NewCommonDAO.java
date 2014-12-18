package control.dao;
import java.sql.*;

public class NewCommonDAO {
	// JDBCドライバ名
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	// データベース接続URL
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	// データベース接続ユーザ
	private static final String DB_USER = "postgres";
	// データベース接続パスワード
	private static final String DB_PASSWORD = "postgres";
//	private static final String DB_PASSWORD = "Univ2014";

	// データベースコネクション
	protected Connection conn;

	/*
	 * 機　能：　データベースコネクションを開くメソッド
	 *
	 * 引　数：　なし
	 * 戻り値：　なし
	 * 解　説：　データベースとのコネクションを作成し、接続を行う
	 */
	protected void init() throws DAOException {
		try {
			// データベースドライバの読込
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	/*
	 * 機　能：　データベースコネクションを閉じるメソッド
	 *
	 * 引　数：　なし
	 * 戻り値：　なし
	 * 解　説：　データベースコネクションオブジェクトがnullでなければ閉じる。
	 */
	protected void destroy() throws DAOException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}
	
}
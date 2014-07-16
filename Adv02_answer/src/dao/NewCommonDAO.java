package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DAOで共通に使用する接続・切断のための処理プログラム
//エラーが発生した場合はユーザ定義例外を使ってそれを通知する
public class NewCommonDAO {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	protected Connection conn;

	// データベースとの接続を行うためのメソッド
	protected void init() throws DAOException {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		}
	}

	// データベースとのコネクションを切断するメソッド
	protected void destroy() throws DAOException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		}
	}
	
}
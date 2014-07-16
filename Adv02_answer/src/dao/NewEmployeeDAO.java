package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//employeeテーブルにアクセスする機能を受け持つプログラム
//接続・切断機能はNewCommonDAOにあるため、必ず継承します
public class NewEmployeeDAO extends NewCommonDAO {

	// employeeテーブルからIDで指定した氏名を検索するメソッド
	public String getName(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
		try {
		    String username = null;
		    init();
			pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
             username = rs.getString(1);
 			return username;
         }
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} finally {
			destroy();
		}
		
		return null;
	}
	
	// employeeテーブルに1件データを挿入するメソッド
	public int add(int id, String name, String password) throws DAOException {
	    PreparedStatement pstmt = null;
		try {
			init();
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);

			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} finally {
			destroy();
		}
	}
}
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//contactテーブルにアクセスするプログラム
public class NewContactDAO extends NewCommonDAO {
	// contactテーブルからIDで指定した内線番号を検索するメソッド
	public int getExtension(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int extension = -1;
		try {
		    init();
			pstmt = conn.prepareStatement("SELECT EXTENSION FROM CONTACT WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
              extension = rs.getInt(1);
  			return extension;
          }
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} finally {
			destroy();
		}
		return extension;
	}
}

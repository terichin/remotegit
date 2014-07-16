package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//contactテーブルにアクセスするプログラム
//接続・切断機能はCommonDAOにあるため、必ず継承します
public class ContactDAO extends CommonDAO {
	// contactテーブルからIDで指定した内線番号を検索するメソッド
	public int getExtension(int id) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    int extension = -1;
		try {
         boolean connected = init();
         if (connected == false) {
         	return extension;
         }
			pstmt = conn.prepareStatement("SELECT EXTENSION FROM CONTACT WHERE ID=?");
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
             extension = rs.getInt(1);
             return extension;
         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return extension;
	}
}
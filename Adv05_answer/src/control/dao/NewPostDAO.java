package control.dao;
import java.sql.*;
import control.dto.*;

public class NewPostDAO extends NewCommonDAO {
	/*
	 * 機　能：　指定したユーザコードに該当する部署情報を取得するメソッド。
	 *
	 * 引　数：　ユーザコード。
	 * 戻り値：　部署情報を収めたDTOオブジェクト。
	 * 解　説：　引数で受け取ったユーザコードを条件として検索を実行し、
	 *           取得した部署情報はDTOオブジェクトに収めて返却する。
	 */
	public PostDTO getPost(int empId) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =	conn.prepareStatement(
					"SELECT ID, POSTNAME, BOSSID FROM POST WHERE ID = ?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String postName = rs.getString(2);
				int bossId = rs.getInt(3);
				PostDTO dto = new PostDTO(id, postName, bossId);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return null;
	}
}
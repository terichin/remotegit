package control.dao;
import java.util.*;
import java.sql.*;
import control.dto.*;

public class NewContactDAO extends NewCommonDAO {
	/*
	 * 機　能：　現在登録されている電話番号の情報一覧を取得する。
	 *
	 * 引　数：　なし。
	 * 戻り値：　電話番号情報一覧を収めたArrayList。
	 * 解　説：　ArrayListを生成する。電話番号情報テーブルに登録されている全電話
	 *           番号情報の全情報を取得して、各電話番号情報をDTOに格納して
	 *           先に生成したArrayListに格納て返却する。
	 */
	public ArrayList<ContactDTO> getContactList() throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactDTO> list = new ArrayList<ContactDTO>();
		try {
			pstmt =	conn.prepareStatement(
					"SELECT ID, EXTENSION, MOBILE FROM CONTACT");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int extension = rs.getInt(2);
				String mobile = rs.getString(3);
				ContactDTO dto = new ContactDTO(id, extension, mobile);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return list;
	}

	// 電話番号1件を検索するメソッド
	public ContactDTO getContact(int empId) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =	conn.prepareStatement(
					"SELECT ID, EXTENSION, MOBILE FROM CONTACT WHERE ID = ?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				int extension = rs.getInt(2);
				String mobile = rs.getString(3);
				// DBから取得した1件のデータでDTOを作ります
				ContactDTO dto = new ContactDTO(id, extension, mobile);
				// 作成したDTOを返します
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

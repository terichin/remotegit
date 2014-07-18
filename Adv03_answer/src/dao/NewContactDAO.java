package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.*;

//contactテーブルにアクセスするプログラム
public class NewContactDAO extends NewCommonDAO {
	// contactテーブルからIDで指定したレコードの情報を検索するメソッド
	public ContactDTO getContact(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		try {
		    ContactDTO dto = null;
		    init();
			pstmt = conn.prepareStatement(
						"SELECT * FROM CONTACT WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int contactId = rs.getInt(1);
				int extension = rs.getInt(2);
				String mobile = rs.getString(3);
				dto = new ContactDTO(contactId, extension, mobile);
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
	
	// contactテーブルから全レコードの情報を取得するメソッド
	public ArrayList<ContactDTO> getAllContact() throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
		// 検索結果を複数格納するリスト
		ArrayList<ContactDTO> list = new ArrayList<ContactDTO>();
		try {
			pstmt = conn.prepareStatement(
				"SELECT ID, EXTENSION, MOBILE FROM CONTACT");
			rs = pstmt.executeQuery();
			// 検索結果レコード数回繰り返します
			while (rs.next()) {
				int contactId = rs.getInt(1);
				int extension = rs.getInt(2);
				String mobile = rs.getString(3);
				// DTOクラスのオブジェクトを生成します
				ContactDTO contact = new ContactDTO(contactId, extension, mobile);
				// 作成したDTOをリストに追加します
				list.add(contact);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return list;
	}
}
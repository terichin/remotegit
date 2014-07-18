package control.dao;
import java.sql.*;
import control.dto.*;

public class NewPostDAO extends NewCommonDAO {
	/*
	 * �@�@�\�F�@�w�肵�����[�U�R�[�h�ɊY�����镔�������擾���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�R�[�h�B
	 * �߂�l�F�@�����������߂�DTO�I�u�W�F�N�g�B
	 * ���@���F�@�����Ŏ󂯎�������[�U�R�[�h�������Ƃ��Č��������s���A
	 *           �擾������������DTO�I�u�W�F�N�g�Ɏ��߂ĕԋp����B
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
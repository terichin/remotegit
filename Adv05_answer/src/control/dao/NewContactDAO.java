package control.dao;
import java.util.*;
import java.sql.*;
import control.dto.*;

public class NewContactDAO extends NewCommonDAO {
	/*
	 * �@�@�\�F�@���ݓo�^����Ă���d�b�ԍ��̏��ꗗ���擾����B
	 *
	 * ���@���F�@�Ȃ��B
	 * �߂�l�F�@�d�b�ԍ����ꗗ�����߂�ArrayList�B
	 * ���@���F�@ArrayList�𐶐�����B�d�b�ԍ����e�[�u���ɓo�^����Ă���S�d�b
	 *           �ԍ����̑S�����擾���āA�e�d�b�ԍ�����DTO�Ɋi�[����
	 *           ��ɐ�������ArrayList�Ɋi�[�ĕԋp����B
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

	// �d�b�ԍ�1�����������郁�\�b�h
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
				// DB����擾����1���̃f�[�^��DTO�����܂�
				ContactDTO dto = new ContactDTO(id, extension, mobile);
				// �쐬����DTO��Ԃ��܂�
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

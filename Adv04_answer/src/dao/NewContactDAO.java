package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.*;

//contact�e�[�u���ɃA�N�Z�X����v���O����
public class NewContactDAO extends NewCommonDAO {
	// contact�e�[�u������ID�Ŏw�肵�����R�[�h�̏����������郁�\�b�h
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
	
	// contact�e�[�u������S���R�[�h�̏����擾���郁�\�b�h
	public ArrayList<ContactDTO> getAllContact() throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
		// �������ʂ𕡐��i�[���郊�X�g
		ArrayList<ContactDTO> list = new ArrayList<ContactDTO>();
		try {
			pstmt = conn.prepareStatement(
				"SELECT ID, EXTENSION, MOBILE FROM CONTACT");
			rs = pstmt.executeQuery();
			// �������ʃ��R�[�h����J��Ԃ��܂�
			while (rs.next()) {
				int contactId = rs.getInt(1);
				int extension = rs.getInt(2);
				String mobile = rs.getString(3);
				// DTO�N���X�̃I�u�W�F�N�g�𐶐����܂�
				ContactDTO contact = new ContactDTO(contactId, extension, mobile);
				// �쐬����DTO�����X�g�ɒǉ����܂�
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
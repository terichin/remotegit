package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * ���[�U�e�[�u���Ƃ̂������s���N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDAO extends CommonDAO {

	/*
	 * �@�@�\�F�@���[�U����ǉ����郁�\�b�h�B
	 *
	 * ���@���F�@�ǉ����郆�[�U�������߂�DTO�I�u�W�F�N�g�B
	 * �߂�l�F�@�ǉ��ɐ��������1��Ԃ��B���s�����ꍇ��1�ȊO�̒l��Ԃ��B
	 * ���@���F�@�����Ɏw�肳�ꂽ���[�U�������[�U�e�[�u���ɓo�^����B
	 */
	public int add(UserDTO user) throws DAOException {
		init();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

		try {
            // ���[�U�R�[�h���̔Ԃ���B
            pstmt = conn.prepareStatement("SELECT NEXTVAL('USERNO')");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int no = rs.getInt(1);

                user.setId(no);
            } else {
                // �̔Ԃł��Ȃ��������߁A�ǉ��s�B
                return -1;
            }

			pstmt =	conn.prepareStatement("INSERT INTO USERTBL"
							+ " (CODE, NAME, KANA, PHONE, MAIL, PASSWORD, PRIVILEGE)"
							+ " VALUES (?,?,?,?,?,?,?)");
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getKana());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getMail());
			pstmt.setString(6, user.getPassword());
			pstmt.setInt(7, user.getPrivilege());
			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}

	/*
	 * �@�@�\�F�@���O�C���\���`�F�b�N���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�������߂�DTO�I�u�W�F�N�g�B
	 * �߂�l�F�@���O�C���\�Ȃ��true��Ԃ��B����ȊO��false��Ԃ��B
	 * ���@���F�@�����Ŏ󂯎����DTO���烆�[�U�R�[�h�ƃp�X���[�h���擾���A
	 *           ���̏��ɊY�����郆�[�U��񂪃��[�U�e�[�u���ɑ��݂��邩�m�F���A
	 *           ���݂����true��Ԃ��A���݂��Ȃ����false��Ԃ��B
	 */
	public boolean checkLogin(UserDTO user) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT * FROM USERTBL"
							+ " WHERE CODE = ? AND PASSWORD = ?");
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();

			boolean isExists = rs.next();

			return isExists;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}

	/*
	 * �@�@�\�F�@���[�U�����폜���郁�\�b�h�B
	 *
	 * ���@���F�@�폜���郆�[�U���̃��[�U�R�[�h�B
	 * �߂�l�F�@��������1��Ԃ��B���s����1�ȊO��Ԃ��B
	 * ���@���F�@�����Ŏw�肳�ꂽ���[�U�R�[�h�ɕR�t�����[�U�����폜����B
	 */
	public int delete(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM USERTBL WHERE CODE = ?");
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}

	/*
	 * �@�@�\�F�@���[�U�����X�V���郁�\�b�h�B
	 *
	 * ���@���F�@�X�V���郆�[�U�������߂�DTO�I�u�W�F�N�g�B
	 * �߂�l�F�@��������1��Ԃ��B���s����1�ȊO��Ԃ��B
	 * ���@���F�@������DTO�œn���ꂽ���[�U�����g�p���āA���[�U���e�[�u����
	 *           ���Y���[�U�����X�V����B
	 */
	public int edit(UserDTO user) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt =	conn.prepareStatement("UPDATE USERTBL SET"
							+ " NAME = ?, KANA = ?, PHONE = ?,"
							+ " MAIL = ?, PASSWORD = ?, PRIVILEGE = ? WHERE CODE = ?");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getKana());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getMail());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getPrivilege());
			pstmt.setInt(7, user.getId());
			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}

	/*
	 * �@�@�\�F�@�w�肵�����[�U�R�[�h�ɊY�����郆�[�U�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�R�[�h�B
	 * �߂�l�F�@���[�U�������߂�DTO�I�u�W�F�N�g�B
	 * ���@���F�@�����Ŏ󂯎�������[�U�R�[�h�������Ƃ��Č��������s���A
	 *           �擾�������[�U����DTO�I�u�W�F�N�g�Ɏ��߂ĕԋp����B
	 */
	public UserDTO getUser(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT"
							+ " CODE, NAME, KANA, PHONE, MAIL, PASSWORD, PRIVILEGE"
							+ " FROM USERTBL WHERE CODE = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String kana = rs.getString(3);
				String phone = rs.getString(4);
				String mail = rs.getString(5);
				String password = rs.getString(6);
				int privilege = rs.getInt(7);

				UserDTO dto =
						new UserDTO(no, name, kana, phone, mail, password, privilege);

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

	/*
	 * �@�@�\�F�@���ݓo�^����Ă��郆�[�U�̏��ꗗ���擾����B
	 *
	 * ���@���F�@�Ȃ��B
	 * �߂�l�F�@���[�U���ꗗ�����߂�ArrayList�B
	 * ���@���F�@ArrayList�𐶐�����B���[�U���e�[�u���ɓo�^����Ă���S���[�U����
	 *           �S�����擾���āA�e���[�U����DTO�Ɋi�[���Đ�ɐ�������ArrayList��
	 *           �i�[���A�Ō�ɍ쐬����ArrayList��ԋp����B
	 */
	public ArrayList<UserDTO> getUserList() throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();

		try {
			pstmt =	conn.prepareStatement("SELECT CODE, NAME, PHONE, MAIL"
							+ " FROM USERTBL");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String mail = rs.getString(4);

				UserDTO dto = new UserDTO(id, name, phone, mail);

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

}

package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * ���i�e�[�u���Ƃ̂������s���N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemDAO extends CommonDAO {

	/*
	 * �@�@�\�F�@���i�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@�擾���鏤�i���̏��i�ԍ��B
	 * �߂�l�F�@���i����ۑ�����DTO�I�u�W�F�N�g�B
	 * ���@���F�@���i�ԍ��ɕR�t�����i�����擾���A�ԋp����B
	 */
	public ItemDTO getItem(int no) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT NO, NAME, PRICE"
							+ " FROM ITEMTBL WHERE NO = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				ItemDTO item = new ItemDTO(code, name, price);
				return item;
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
	 * �@�@�\�F�@�w�肵���J�e�S�����̏��i���ꗗ���擾���郁�\�b�h�B
	 *
	 * ���@���F�@�J�e�S���R�[�h�B
	 * �߂�l�F�@���i���ꗗ��ۑ�����ArrayList�B
	 *           1�����i�������ꍇ�͋��ArrayList��Ԃ��B
	 * ���@���F�@�ꗗ��ۑ�����ArrayList�𐶐�������ŁA�w�肳�ꂽ�J�e�S���R�[�h��
	 *           ��v���鏤�i������������B�Y�����鏤�i��񂪂���ꍇ�́A���ꂼ��
	 *           DTO�Ɋi�[���Đ�ɐ�������ArrayList�ɒǉ�����B
	 *           �Ō�Ɉꗗ��ۑ�����ArrayList��Ԃ��B
	 */
	public ArrayList<ItemDTO> getItemList(int category) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		try {
			pstmt =	conn.prepareStatement("SELECT NO, NAME, PRICE"
							+ " FROM ITEMTBL WHERE CATEGORY = ?");
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				ItemDTO item = new ItemDTO(no, name, price);
				list.add(item);
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

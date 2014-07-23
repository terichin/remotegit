package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * �����e�[�u���Ƃ̂������s��DAO�N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderDAO extends CommonDAO {

	/*
	 * �@�@�\�F�@�w�肳�ꂽ�ԍ��������������폜���郁�\�b�h�B
	 *
	 * ���@���F�@�L�����Z�����钍���̒����ԍ��B
	 * �߂�l�F�@��������1��Ԃ��B���s����1�ȊO�̒l��Ԃ��B
	 * ���@���F�@�ΏۂƂȂ钍�����ɑ΂���DELETE���𔭍s���A���̍X�V�s����
	 *           �ԋp����B
	 */
	public int delete(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM ORDERTBL WHERE NO = ?");
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
	 * �@�@�\�F�@��������ǉ����郁�\�b�h�B
	 *
	 * ���@���F�@����DTO�B
	 * �߂�l�F�@�������͒����ԍ���Ԃ��B�����Ɏ��s�����ꍇ��-1�B
	 * ���@���F�@�݌Ƀe�[�u����DTO�Ŏw�肳�ꂽ���i�ԍ��̏��i�݌ɂ��m�F����B
	 *           ���̌㒍���ԍ���DBMS�̃V�[�P���X����擾���A�擾���������ԍ���
	 *           ����DTO�ɐݒ肵�Ē��������m�肵�A����DTO���g�p����
	 *           �����e�[�u���֏���o�^����B
	 */
	public int add(OrderDTO dto) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT STOCK FROM ITEMTBL"
							+ " WHERE NO = ?");
			pstmt.setInt(1, dto.getItemNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int stock = rs.getInt(1);

				if (dto.getQuantity() > stock) {
					return -1;
				}
			} else {
				return -1;
			}

			// �����ԍ����̔Ԃ���B
			pstmt = conn.prepareStatement("SELECT NEXTVAL('ORDERNO')");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt(1);

				dto.setNo(no);
			} else {
				// �̔Ԃł��Ȃ��������߁A�����s�B
				return -1;
			}
			// �̔Ԃ��������ԍ����g���Ē�������o�^����B
			pstmt =	conn.prepareStatement("INSERT INTO ORDERTBL"
							+ " (NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE)"
							+ " VALUES (?,?,?,?,?,?)");
			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getItemNo());
			pstmt.setString(3,dto.getItemName());
			pstmt.setInt(4, dto.getQuantity());
			pstmt.setInt(5, dto.getUserId());
			pstmt.setTimestamp(6, dto.getOrderDate());

			int result = pstmt.executeUpdate();
			if (result != 1) {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}

		return dto.getNo();
	}

	/*
	 * �@�@�\�F�@�����ԍ��ɕR�t�����������擾���郁�\�b�h�B
	 *
	 * ���@���F�@�����ԍ��B
	 * �߂�l�F�@�������DTO��Ԃ��B������Ȃ��ꍇ��null��Ԃ��B
	 * ���@���F�@�����e�[�u����蒍���������������Ƃ��ď����擾���A
	 *           �擾��������DTO�I�u�W�F�N�g�Ɋi�[���ĕԋp����B
	 */
	public OrderDTO getOrder(int orderId) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT"
						+ " NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE"
						+ " FROM ORDERTBL WHERE NO = ?");
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt(1);
				int itemNo = rs.getInt(2);
				String itemName = rs.getString(3);
				int count = rs.getInt(4);
				int usercode = rs.getInt(5);
				Timestamp orderdate = rs.getTimestamp(6);

				OrderDTO dto = new OrderDTO(
						no, itemNo, itemName, count, usercode, orderdate);

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
	 * �@�@�\�F�@���[�U�̒����������擾���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�R�[�h�B
	 * �߂�l�F�@���Y���[�U�̒���������ۑ�����ArrayList��Ԃ��B
	 *           ����������1���������ꍇ�͋��ArrayList��Ԃ��B
	 * ���@���F�@ArrayList�𐶐����A�����e�[�u�����烆�[�U�R�[�h�����������Ƃ���
	 *           �����̗������擾����B�擾�����������͂��ꂼ��DTO�I�u�W�F�N�g��
	 *           �ۑ����ADTO�I�u�W�F�N�g���ɍ쐬����ArrayList�ɒǉ����Ē���������
	 *           �ۑ�����ArrayList���Ō�ɕԋp����B
	 */
	public ArrayList<OrderDTO> getOrderList(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();

		try {
			pstmt =	conn.prepareStatement("SELECT"
						+ " NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE"
						+ " FROM ORDERTBL WHERE USERCODE = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				int itemNo = rs.getInt(2);
				String itemName = rs.getString(3);
				int count = rs.getInt(4);
				int usercode = rs.getInt(5);
				Timestamp orderdate = rs.getTimestamp(6);

				OrderDTO dto = new OrderDTO(
						no, itemNo, itemName, count, usercode, orderdate);

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

package control.dao;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import control.dto.*;

public class NewExpenseDAO extends NewCommonDAO {
	/*
	 * �@�@�\�F�@�o�����ǉ����郁�\�b�h�B
	 *
	 * ���@���F�@ExpenseDTO�B
	 * �߂�l�F�@�������͒����ԍ���Ԃ��B�����Ɏ��s�����ꍇ��-1�B
	 * ���@���F�@�o��ԍ���DBMS�̃V�[�P���X����擾���A�擾�����o��ԍ���
	 *           ExpenseDTO�ɐݒ肵�Čo������m�肵�A����DTO���g�p����
	 *           �o��e�[�u���֏���o�^����B
	 */
	public int addExpense(ExpenseDTO exp) throws DAOException {
		init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		try {
            // �o��R�[�h���̔Ԃ��܂�
            pstmt = conn.prepareStatement("SELECT NEXTVAL('EXPENSEID')");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt(1);

                exp.setExpenseId(no);
            } else {
                // �̔Ԃł��Ȃ��������߁A�ǉ����邱�Ƃ��ł��܂���
                return -1;
            }
            // �̔Ԃ����o��R�[�h���g�p���Čo������e�[�u���ɒǉ�����
			pstmt =	conn.prepareStatement("INSERT INTO EXPENSE"
							+ " (EXPENSEID, ID, USEDATE, USE, COST) VALUES (?,?,?,?,?)");
			pstmt.setInt(1, exp.getExpenseId());
			pstmt.setInt(2, exp.getId());
			pstmt.setDate(3, exp.getUseDate());
			pstmt.setString(4, exp.getUse());
			pstmt.setInt(5, exp.getCost());
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
	 * �@�@�\�F�@���[�U�̌o������擾���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�R�[�h�B
	 * �߂�l�F�@���Y���[�U�̌o�����ۑ�����ArrayList��Ԃ��B
	 *           �o����1���������ꍇ�͋��ArrayList��Ԃ��B
	 * ���@���F�@ArrayList�𐶐����A�o��e�[�u�����烆�[�U�R�[�h�����������Ƃ���
	 *           �o������擾����B�擾�����o����͂��ꂼ��DTO�I�u�W�F�N�g��
	 *           �ۑ����ADTO�I�u�W�F�N�g���ɍ쐬����ArrayList�ɒǉ����Čo�����
	 *           �ۑ�����ArrayList���Ō�ɕԋp����B
	 */
	public ArrayList<ExpenseDTO> getExpenseList(int id) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExpenseDTO> list = new ArrayList<ExpenseDTO>();
		try {
			pstmt =	conn.prepareStatement(
					"SELECT USEDATE, USE, COST FROM EXPENSE WHERE ID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				java.sql.Date useDate = rs.getDate(1);
				String use = rs.getString(2);
				int cost = rs.getInt(3);
				ExpenseDTO dto = new ExpenseDTO(-1, id, useDate, use, cost);
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

	/*
	 * �@�@�\�F�@���[�U�ƔN�����w�肵�Čo������擾���郁�\�b�h�B
	 *
	 * ���@���F�@���������Ɏg�p���郆�[�U�R�[�h�E�N�E��
	 * �߂�l�F�@���Y�����̌o�����ۑ�����ArrayList��Ԃ��B
	 *           �o����1���������ꍇ�͋��ArrayList��Ԃ��B
	 * ���@���F�@ArrayList�𐶐����A�o��e�[�u�����烆�[�U�R�[�h�E�N�E������������
	 *           �Ƃ��Čo������擾����B�擾�����o����͂��ꂼ��DTO�I�u�W�F
	 *           �N�g�ɕۑ����ADTO�I�u�W�F�N�g���ɍ쐬����ArrayList�ɒǉ�����
	 *           �o�����ۑ�����ArrayList���Ō�ɕԋp����B
	 */
	public ArrayList<ExpenseDTO> getExpenseList(int id, int year, int month)
		throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExpenseDTO> list = new ArrayList<ExpenseDTO>();
		try {
			String start = year + "/" + month + "/"  + 01;
			String end = year + "/" + month + "/"  + 31;
			java.util.Date date1 = DateFormat.getDateInstance().parse(start);
			java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
			java.util.Date date2 = DateFormat.getDateInstance().parse(end);
			java.sql.Date sqldate2 = new java.sql.Date(date2.getTime());
			pstmt =	conn.prepareStatement(
					"SELECT USEDATE, USE, COST FROM EXPENSE " + 
					"WHERE ID = ? AND USEDATE >= ? AND USEDATE <= ?");
			pstmt.setInt(1, id);
			pstmt.setDate(2, sqldate1);
			pstmt.setDate(3, sqldate2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				java.sql.Date useDate = rs.getDate(1);
				String use = rs.getString(2);
				int cost = rs.getInt(3);
				ExpenseDTO dto = new ExpenseDTO(-1, id, useDate, use, cost);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return list;
	}
}
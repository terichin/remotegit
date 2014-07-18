package control.dao;
import java.sql.*;
import java.util.*;
import control.dto.*;

public class NewEmployeeDAO extends NewCommonDAO {
    /*
     * �@�@�\�F�@���O�C���\���`�F�b�N���郁�\�b�h�B
     *
     * ���@���F�@���[�U�������߂�DTO�I�u�W�F�N�g�B
     * �߂�l�F�@���O�C���\�Ȃ��true��Ԃ��B����ȊO��false��Ԃ��B
     * ���@���F�@�����Ŏ󂯎����DTO���烆�[�U�R�[�h�ƃp�X���[�h���擾���A
     *           ���̏��ɊY�����郆�[�U��񂪃��[�U�e�[�u���ɑ��݂��邩�m�F���A
     *           ���݂����true��Ԃ��A���݂��Ȃ����false��Ԃ��B
     */
    public boolean checkLogin(EmployeeDTO emp) throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt =    conn.prepareStatement("SELECT * FROM EMPLOYEE"
                            + " WHERE ID = ? AND PASSWORD = ?");
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getPassword());
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
     * �@�@�\�F�@���[�U����ǉ����郁�\�b�h�B
     *
     * ���@���F�@�ǉ����郆�[�U�������߂�DTO�I�u�W�F�N�g�B
     * �߂�l�F�@�ǉ��ɐ��������1��Ԃ��B���s�����ꍇ��1�ȊO�̒l��Ԃ��B
     * ���@���F�@�����Ɏw�肳�ꂽ���[�U�������[�U�e�[�u���ɓo�^����B
     */
    public int addUser(EmployeeDTO emp) throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // ���[�U�R�[�h���̔Ԃ��܂�
            pstmt = conn.prepareStatement("SELECT NEXTVAL('EMPNO')");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt(1);

                emp.setId(no);
            } else {
                // �̔Ԃł��Ȃ��������߁A�ǉ����邱�Ƃ��ł��܂���
                return -1;
            }
            // �V�[�P���X����擾����ID���g���ēo�^���܂�
            pstmt =    conn.prepareStatement("INSERT INTO EMPLOYEE"
                            + " (ID, PASSWORD, USERNAME) VALUES (?,?,?)");
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getPassword());
            pstmt.setString(3, emp.getName());
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
     * �@�@�\�F�@���ݓo�^����Ă��郆�[�U�̏��ꗗ���擾����B
     *
     * ���@���F�@�Ȃ��B
     * �߂�l�F�@���[�U���ꗗ�����߂�ArrayList�B
     * ���@���F�@ArrayList�𐶐�����B���[�U���e�[�u���ɓo�^����Ă���S���[�U����
     *           �S�����擾���āA�e���[�U����DTO�Ɋi�[���Đ�ɐ�������ArrayList��
     *           �i�[���A�Ō�ɍ쐬����ArrayList��ԋp����B
     */
    public ArrayList<EmployeeDTO> searchAllUser() throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
        try {
            pstmt =    conn.prepareStatement(
                    "SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                EmployeeDTO dto = new EmployeeDTO(id, name, password);
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
	 * �@�@�\�F�@�w�肵�����[�U�R�[�h�ɊY�����郆�[�U�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@���[�U�R�[�h�B
	 * �߂�l�F�@���[�U�������߂�DTO�I�u�W�F�N�g�B
	 * ���@���F�@�����Ŏ󂯎�������[�U�R�[�h�������Ƃ��Č��������s���A
	 *           �擾�������[�U����DTO�I�u�W�F�N�g�Ɏ��߂ĕԋp����B
	 */
	public EmployeeDTO getUser(int empId) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =	conn.prepareStatement(
					"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE WHERE ID = ?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				EmployeeDTO dto = new EmployeeDTO(id, name, password);
				
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
	 * �@�@�\�F�@���[�U�����X�V���郁�\�b�h�B
	 *
	 * ���@���F�@�X�V���郆�[�U�������߂�DTO�I�u�W�F�N�g�B
	 * �߂�l�F�@��������1��Ԃ��B���s����1�ȊO��Ԃ��B
	 * ���@���F�@������DTO�œn���ꂽ���[�U�����g�p���āA���[�U���e�[�u����
	 *           ���Y���[�U�����X�V����B
	 */
	public int updateUser(EmployeeDTO emp) throws DAOException {
		init();
        PreparedStatement pstmt = null;
		try {
			pstmt =	conn.prepareStatement(
				"UPDATE EMPLOYEE SET PASSWORD = ?, USERNAME = ? WHERE ID = ?");
			pstmt.setString(1, emp.getPassword());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}	
}
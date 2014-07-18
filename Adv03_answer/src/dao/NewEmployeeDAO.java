package dao;
import java.sql.*;
import java.util.*;
import dto.*;

// employee�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��CommonDAO�ɂ��邽�߁A�K���p�����܂�
public class NewEmployeeDAO extends NewCommonDAO {
	// employee�e�[�u������ID�Ŏw�肵���������������郁�\�b�h
	public String getName(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
		try {
		    String username = null;
		    init();
			pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
                username = rs.getString(1);
    			return username;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		} finally {
			destroy();
		}
		
		return null;
	}
	
	// employee�e�[�u����1���f�[�^��}�����郁�\�b�h
	public int add(int id, String name, String password) throws DAOException {
	    PreparedStatement pstmt = null;
		try {
			init();
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);

			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		} finally {
			destroy();
		}
	}
	
	// employee�e�[�u������ID�Ŏw�肵���]�ƈ������������郁�\�b�h
	public EmployeeDTO getEmployee(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
	    try {
			pstmt = conn.prepareStatement(
				"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// �S�J�����̏����擾���܂�
				int userId = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				// DTO�N���X�̃I�u�W�F�N�g�𐶐����܂�
				// �����ɂ͎擾�����e�J�����̕ϐ����w�肵�܂�
				EmployeeDTO dto = new EmployeeDTO(userId, name, password);
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

	// employee�e�[�u������S�]�ƈ������������郁�\�b�h
	public ArrayList<EmployeeDTO> getAllEmployee() throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
		// �������ʂ𕡐��i�[���郊�X�g
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			pstmt = conn.prepareStatement(
				"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE");
			rs = pstmt.executeQuery();
			// �������ʃ��R�[�h����J��Ԃ��܂�
			while (rs.next()) {
				int userId = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				// DTO�N���X�̃I�u�W�F�N�g�𐶐����܂�
				EmployeeDTO employee = new EmployeeDTO(userId, name, password);
				// �쐬����DTO�����X�g�ɒǉ����܂�
				list.add(employee);
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
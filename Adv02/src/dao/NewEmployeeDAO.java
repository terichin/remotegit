package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//employee�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
//�ڑ��E�ؒf�@�\��NewCommonDAO�ɂ��邽�߁A�K���p�����܂�
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
}
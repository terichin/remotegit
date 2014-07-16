package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//contact�e�[�u���ɃA�N�Z�X����v���O����
public class NewContactDAO extends NewCommonDAO {
	// contact�e�[�u������ID�Ŏw�肵�������ԍ����������郁�\�b�h
	public int getExtension(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int extension = -1;
		try {
		    init();
			pstmt = conn.prepareStatement("SELECT EXTENSION FROM CONTACT WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
              extension = rs.getInt(1);
  			return extension;
          }
		} catch (SQLException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		} finally {
			destroy();
		}
		return extension;
	}
}

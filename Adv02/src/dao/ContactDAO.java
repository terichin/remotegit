package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//contact�e�[�u���ɃA�N�Z�X����v���O����
//�ڑ��E�ؒf�@�\��CommonDAO�ɂ��邽�߁A�K���p�����܂�
public class ContactDAO extends CommonDAO {
	// contact�e�[�u������ID�Ŏw�肵�������ԍ����������郁�\�b�h
	public int getExtension(int id) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    int extension = -1;
		try {
         boolean connected = init();
         if (connected == false) {
         	return extension;
         }
			pstmt = conn.prepareStatement("SELECT EXTENSION FROM CONTACT WHERE ID=?");
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
             extension = rs.getInt(1);
             return extension;
         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return extension;
	}
}
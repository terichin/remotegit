package dao;
import java.sql.*;

// POST�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��NewCommonDAO�ɂ��邽�߁A�K���p������
public class NewPostDAO extends NewCommonDAO {
    // POST�e�[�u������ID�Ŏw�肵���������������郁�\�b�h
    public String getName(int id) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String username = null;
            init();
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE id=?");
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
    
    // POST�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int id, String postname, int bossid) throws DAOException {
        PreparedStatement pstmt = null;
        try {
            init();
            pstmt = conn.prepareStatement("INSERT INTO POST VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, postname);
            pstmt.setInt(3, bossid);
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

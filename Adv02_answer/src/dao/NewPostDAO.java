package dao;
import java.sql.*;

// post�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��NewCommonDAO�ɂ��邽�߁A�K���p������
public class NewPostDAO extends NewCommonDAO {

    // post�e�[�u������ID�Ŏw�肵�����������������郁�\�b�h
    public String getName(int id) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String postname = null;
            init();
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                postname = rs.getString(1);
                return postname;
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
    
}
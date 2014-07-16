package dao;
import java.sql.*;

// post�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��CommonDAO�ɂ��邽�߁A�K���p�����܂�
public class PostDAO extends CommonDAO {
    // post�e�[�u������ID�Ŏw�肵�����������������郁�\�b�h
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String postname = null;
            boolean connected = init();
            if (connected == false) {
                return null;
            }
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                postname = rs.getString(1);
                return postname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return null;
    }

    // post�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int id, String postname, int bossid) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
                return -1;
            }
            pstmt = conn.prepareStatement("INSERT INTO POST VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, postname);
            pstmt.setInt(3, bossid);
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return -1;
    }
}
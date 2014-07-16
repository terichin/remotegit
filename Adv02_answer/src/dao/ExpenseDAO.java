package dao;
import java.sql.*;

// expense�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��CommonDAO�ɂ��邽�߁A�K���p�����܂�
public class ExpenseDAO extends CommonDAO {
    // expense�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int exid, int id, Date date, String use, int cost) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            pstmt = conn.prepareStatement(
            	"INSERT INTO EXPENSE VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, exid);
            pstmt.setInt(2, id);
            pstmt.setDate(3, date);
            pstmt.setString(4, use);
            pstmt.setInt(5, cost);
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return -1;
    }
    
    // expense�e�[�u������w���ID�E���t�������R�[�h��COST���v��Ԃ����\�b�h
    public int getCost(int id, Date date) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cost = 0;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            pstmt = conn.prepareStatement(
            			"SELECT SUM(COST) FROM EXPENSE WHERE ID = ? AND USEDATE = ?");
            pstmt.setInt(1, id);
            pstmt.setDate(2, date);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	cost = rs.getInt(1);
            }
            return cost;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return -1;
    }
}
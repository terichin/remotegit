package dao;
import java.sql.*;
import java.util.ArrayList;

// expense�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
// �ڑ��E�ؒf�@�\��NewCommonDAO�ɂ��邽�߁A�K���p�����܂�
public class NewExpenseDAO extends NewCommonDAO {

    // expense�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int exid, int id, Date date, String use, int cost) throws DAOException {
        PreparedStatement pstmt = null;
        try {
            init();
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
			// ���[�U��`��O���g�p���ăG���[��ʒm����
            throw new DAOException();
        } finally {
            destroy();
        }
    }
    
    // expense�e�[�u������w���ID�E���t�������R�[�h��COST���v��Ԃ����\�b�h
    public int getCost(int id, Date date) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cost = 0;
        try {
            init();
            pstmt = 
            	conn.prepareStatement("SELECT SUM(COST) FROM EXPENSE WHERE ID = ? AND USEDATE = ?");
            pstmt.setInt(1, id);
            pstmt.setDate(2, date);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	cost = rs.getInt(1);
            }
            return cost;
        } catch (SQLException e) {
            e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
            throw new DAOException();
        } finally {
            destroy();
        }
    }
    
    // expense�e�[�u���̎w��ID�̑S�R�X�g��ArrayList�ŕԂ����\�b�h
    public ArrayList getAllCost(int id) throws DAOException {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ArrayList list = null;
    	try {
    		init();
    		pstmt = conn.prepareStatement("SELECT COST FROM EXPENSE WHERE ID = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
            	list.add(rs.getInt(1));
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

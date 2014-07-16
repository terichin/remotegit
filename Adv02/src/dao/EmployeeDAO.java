package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//employee�e�[�u���ɃA�N�Z�X����@�\���󂯎��v���O����
//�ڑ��E�ؒf�@�\��CommonDAO�ɂ��邽�߁A�K���p�����܂�
public class EmployeeDAO extends CommonDAO{
    // employee�e�[�u������ID�Ŏw�肵���������������郁�\�b�h
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String username = null;
            boolean connected = init();
            if (connected == false) {
            	return null;
            }
            pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
                return username;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return null;
    }
    
    // employee�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int id, String name, String password) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
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
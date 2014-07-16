package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO�p�^�[����employee�e�[�u���ւ̃A�N�Z�X���s����v���O����
public class DAOSample {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "postgres";
  private static final String DB_PASSWORD = "Univ2014";

    private Connection conn;

    // �f�[�^�x�[�X�Ƃ̐ڑ����s�����߂̃��\�b�h
    // �R�l�N�V�����I�u�W�F�N�g���擾����܂ł̏������s���܂�
    // �f�[�^�x�[�X�ւ̐ڑ��Ɏ��s�����Ƃ���false�A�������ɂ�true��Ԃ��܂�
    private boolean init() {
        // �f�[�^�x�[�X�h���C�o�̓Ǎ��Ɛڑ����s��
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // �f�[�^�x�[�X�Ƃ̃R�l�N�V������ؒf���郁�\�b�h
    // �擾�����R�l�N�V�����I�u�W�F�N�g���N���[�Y���܂�
    private void destroy() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // employee�e�[�u������ID�Ŏw�肵���������������郁�\�b�h
    // ���������s��������null��Ԃ��܂�
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DB����擾����������ۑ�����ϐ�
            String username = null;
            // init���\�b�h���Ăяo���ADB�ڑ����������s���܂�
            boolean connected = init();
            if (connected == false) {
            	return null;
            }
            // ������ID�������L�[�ɂ��Ď������������܂�
            pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // SELECT�̎��s���ʂ��玁�����擾���܂�
                username = rs.getString(1);
                // �擾����������Ԃ��܂�
                return username;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // destroy���\�b�h���Ăяo���A�ؒf���������s���܂�
            destroy();
        }
        // �擾�Ɏ��s�����̂�null��Ԃ��܂�
        return null;
    }
    
    // employee�e�[�u����1���̃f�[�^��}�����郁�\�b�h
    public int add(int id, String name, String password) {
        PreparedStatement pstmt = null;

        try {
            // init���\�b�h���Ăяo���A�ڑ����������s���܂�
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            // �����̒l��}�����܂�
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            // INSERT�����s���A�߂�l����X�V�s�����擾����
            int count = pstmt.executeUpdate();
            // �X�V������Ԃ�
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // destroy���\�b�h���Ăяo���A�ؒf���������s����
            destroy();
        }
        // �X�V�Ɏ��s�����̂�-1��Ԃ�
        return -1;
    }
}
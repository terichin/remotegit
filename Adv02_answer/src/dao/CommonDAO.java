package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DAO�ŋ��ʂɎg�p����ڑ��E�ؒf�̂��߂̏����v���O����
//���̃N���X�͕K������DAO�N���X�Ɍp������Ďg�p����邱�ƂɂȂ�܂�
public class CommonDAO {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "postgres";
  private static final String DB_PASSWORD = "Univ2014";

    protected Connection conn;

    // �f�[�^�x�[�X�Ƃ̐ڑ����s�����߂̃��\�b�h
    protected boolean init() {
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
    protected void destroy() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
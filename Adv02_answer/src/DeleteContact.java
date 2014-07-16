import java.sql.*;
// contact�e�[�u������1���̃f�[�^�폜���s���v���O����
public class DeleteContact {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // ResultSet�͕K�v����܂���

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // ���R�[�h�폜���s�����߂̏���������
            pstmt = conn.prepareStatement("DELETE FROM CONTACT WHERE ID=?");
            // �폜������SQL���ɒǉ�����
            pstmt.setInt(1, Integer.parseInt(args[0]));
            // DELETE���s
            // ���s���ɗ�O�͔������܂���
            int count = pstmt.executeUpdate();
            // �߂�l�̒l�� 1 �Ȃ�1���폜���ꂽ���ƂɂȂ�܂�
            if (count == 1) {
                System.out.println("1���̃f�[�^���폜���܂����B");
            } else {
                System.out.println("�w�肳�ꂽID�̃��R�[�h�����݂��܂���B");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�폜����ID�������ŗ^����K�v������܂��B");
        } catch (NumberFormatException e) {
            System.out.println("�폜����ID�͐��l�łȂ���΂Ȃ�܂���B");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
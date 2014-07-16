import java.sql.*;
// contact�e�[�u����1���̃f�[�^�X�V���s���v���O����
public class UpdateContact {
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
            // ���R�[�h�X�V���s�����߂̏���������
            pstmt = conn.prepareStatement(
                    "UPDATE CONTACT SET EXTENSION = ?, MOBILE = ? WHERE ID = ?");
            // �X�V������SQL���ɒǉ�����
            pstmt.setInt(1, Integer.parseInt(args[1]));
            pstmt.setString(2, args[2]);
            pstmt.setInt(3, Integer.parseInt(args[0]));
            // UPDATE���s
            // ���s���� SQLException ���������܂�
            int count = pstmt.executeUpdate();
            System.out.println(count + "���̃f�[�^���X�V���܂����B");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("�f�[�^�̍X�V�Ɏ��s���܂����B");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
        } catch (NumberFormatException e) {
            System.out.println("ID�A�����ԍ��͐��l�łȂ���΂Ȃ�܂���B");
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
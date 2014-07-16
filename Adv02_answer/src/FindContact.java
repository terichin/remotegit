import java.sql.*;
// contact�e�[�u������1���̌������s���v���O����
public class FindContact {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // �N�G�����s�����߂̏���������
            pstmt = conn.prepareStatement("SELECT * FROM CONTACT WHERE ID=?");
            // ����������SQL���ɒǉ�����
            // args[0]���^�����Ȃ��������ɂ� ArrayIndexOutOfBoundsException ����������
            // int�^�ɕϊ��o���Ȃ��������ɂ� NumberFormatException ����������
            pstmt.setInt(1, Integer.parseInt(args[0]));
            rs = pstmt.executeQuery();
            // �������ʂ͕K��1���ȉ��ł��邽�߁Aif���ŗǂ�
            if (rs.next()) {
                System.out.println("ID\tEXTENSION\tMOBILE");
                int id = rs.getInt(1);
                int extension = rs.getInt(2);
                String mobile = rs.getString(3);
                // �������ʂ�\������
                System.out.println(id + "\t" + extension + "\t\t" + mobile);
            } else {
                System.out.println("�w�肳�ꂽID��������܂���B");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            // args��������l�����o���Ȃ����ɔ��������O
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("��������ID�������ŗ^����K�v������܂��B");
            // String��ID��int�֕ϊ��o���Ȃ��������ɔ��������O
        } catch (NumberFormatException e) {
            System.out.println("��������ID�͐��l�łȂ���΂Ȃ�܂���B");
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
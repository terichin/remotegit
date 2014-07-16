import java.sql.*;

// employee�e�[�u������P���̌������s���v���O����
public class FindSample {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	   
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// �N�G�����s�����߂̏���������
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
			// ����������SQL���ɒǉ�����
			// args[0](��������)���^�����Ȃ��������ɂ� ArrayIndexOutOfBoundsException ����������
			// int�ɕϊ��o���Ȃ��������ɂ� FormatException ����������
			pstmt.setInt(1, Integer.parseInt(args[0]));

			rs = pstmt.executeQuery();
			// �������ʂ͕K���P���ȉ��ł��邽�߁Aif���ŗǂ�
			if (rs.next()) {
				System.out.println("ID\tPASS\tNAME");
                int id = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                // �������ʂ�\������
                System.out.println(id + "\t" + password + "\t" + username);
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// employee�e�[�u���ւP���̃f�[�^�}�����s���v���O����
public class InsertSample {
	private static final String DB_PASSWORD = "postgres";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
//	private static final String DB_USER = "postgres";
	private static final String DB_USER = "Univ2014";
	private static final String DRIVER_NAME = "org.postgresql.Driver";

	public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    // ResultSet�͕K�v����܂���
	    
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// �f�[�^�}�����s�����߂̏���������
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
			// �}��������SQL���ɒǉ�����
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			// INSERT���s
			// ���s���� SQLException ���������܂�
			int count = pstmt.executeUpdate();

			System.out.println("1���̃f�[�^��ǉ����܂����B");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�f�[�^�̑}���Ɏ��s���܂����B");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
		} catch (NumberFormatException e) {
			System.out.println("ID�͐��l�łȂ���΂Ȃ�܂���B");
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
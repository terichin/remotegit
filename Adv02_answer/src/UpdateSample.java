import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// employee�e�[�u���̂P���̃f�[�^�̃p�X���[�h��ύX����v���O����
public class UpdateSample {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	public static void main(String[] args) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    // ResultSet�͕K�v����܂���
	    
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// ���R�[�h�C�����s�����߂̏���������
			pstmt = conn.prepareStatement("UPDATE EMPLOYEE SET PASSWORD=? WHERE ID=?");
			// �C��������SQL���ɒǉ�����
			pstmt.setString(1, args[1]);				// �ŏ��̍��ڂ͐V�����p�X���[�h
			pstmt.setInt(2, Integer.parseInt(args[0]));	// ���̍��ڂ�ID
			// UPDATE���s
			// �C�����郌�R�[�h��������Ȃ�������O�͔������܂���
			int count = pstmt.executeUpdate();
			// �߂�l�̒l�� 1 �Ȃ�1���C�����ꂽ���ƂɂȂ�܂�
			if (count == 1) {
				System.out.println("1���̃f�[�^���X�V���܂����B");
			} else {
				System.out.println("�w�肳�ꂽID�̃��R�[�h�����݂��܂���B");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�X�V����ID�ƃp�X���[�h�������ŗ^����K�v������܂��B");
		} catch (NumberFormatException e) {
			System.out.println("�X�V����ID�͐��l�łȂ���΂Ȃ�܂���B");
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
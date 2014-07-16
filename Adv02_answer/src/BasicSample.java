import java.sql.*;

// employee�e�[�u���̓��e��S�ĕ\������v���O����
public class BasicSample {
	// JDBC�h���C�o��
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	// �f�[�^�x�[�X�ڑ�URL
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	// �f�[�^�x�[�X�ڑ����[�U
	private static final String DB_USER = "postgres";
	// �f�[�^�x�[�X�ڑ��p�X���[�h
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	// main���\�b�h�E�v���O�����͂�������J�n���܂�
	public static void main(String[] args) {
		// DB�ڑ��̂��߂̃I�u�W�F�N�g�ϐ��̐錾
		Connection conn = null;
		// �X�e�[�g�����g�I�u�W�F�N�g�ϐ��̐錾
	    PreparedStatement pstmt = null;
	    // �������ʂ��i�[�����I�u�W�F�N�g�ϐ��̐錾
	    ResultSet rs = null;
		try {
			// JDBC�h���C�o�̏��������s������
			Class.forName(DRIVER_NAME);
			// DB�ւ̐ڑ����s������
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// �N�G�����s�����߂̏���������
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			// �N�G���̎��s
			rs = pstmt.executeQuery();
			// �^�C�g���̕\��
			System.out.println("ID\tPASS\tNAME");
			// �������ʂ̎��o���i�������ꂽ�������J��Ԃ��j
			while (rs.next()) {
				// ���U���g�Z�b�g����P�s���̃f�[�^�����o��
                int id = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                // ���o�����f�[�^��\������
                System.out.println(id + "\t" + password + "\t" + username);
            }
		// JDBC�h���C�o�̓ǂݍ��݂Ɏ��s�����ꍇ�̗�O
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		// DB�A�N�Z�X�ɔ�����O
		} catch (SQLException e) {
			e.printStackTrace();
		// ���펞�E��O�����킸�s���鏈��
		} finally {
			// DB�̐ؒf���s��
			try {
				// �R�l�N�V�����I�u�W�F�N�g�����݂���ꍇ�̂݃N���[�Y���s��
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
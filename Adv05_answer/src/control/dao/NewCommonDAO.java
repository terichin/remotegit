package control.dao;
import java.sql.*;

public class NewCommonDAO {
	// JDBC�h���C�o��
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	// �f�[�^�x�[�X�ڑ�URL
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	// �f�[�^�x�[�X�ڑ����[�U
	private static final String DB_USER = "postgres";
	// �f�[�^�x�[�X�ڑ��p�X���[�h
	private static final String DB_PASSWORD = "postgres";
//	private static final String DB_PASSWORD = "Univ2014";

	// �f�[�^�x�[�X�R�l�N�V����
	protected Connection conn;

	/*
	 * �@�@�\�F�@�f�[�^�x�[�X�R�l�N�V�������J�����\�b�h
	 *
	 * ���@���F�@�Ȃ�
	 * �߂�l�F�@�Ȃ�
	 * ���@���F�@�f�[�^�x�[�X�Ƃ̃R�l�N�V�������쐬���A�ڑ����s��
	 */
	protected void init() throws DAOException {
		try {
			// �f�[�^�x�[�X�h���C�o�̓Ǎ�
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

	/*
	 * �@�@�\�F�@�f�[�^�x�[�X�R�l�N�V��������郁�\�b�h
	 *
	 * ���@���F�@�Ȃ�
	 * �߂�l�F�@�Ȃ�
	 * ���@���F�@�f�[�^�x�[�X�R�l�N�V�����I�u�W�F�N�g��null�łȂ���Ε���B
	 */
	protected void destroy() throws DAOException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}
	
}
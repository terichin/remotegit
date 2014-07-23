package univelec.dao;
import java.sql.*;

/*
 * ���ʂ�DAO�N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class CommonDAO {

	// �f�[�^�x�[�X�ڑ��p�X���[�h
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	// �f�[�^�x�[�X�ڑ�URL
	private static final String DB_URL =
			"jdbc:postgresql://localhost:5432/univ";

	// �f�[�^�x�[�X�ڑ����[�U
	private static final String DB_USER = "postgres";

	// JDBC�h���C�o��
	private static final String DRIVER_NAME = "org.postgresql.Driver";

	// �f�[�^�x�[�X�R�l�N�V����
	protected Connection conn;

	/*
	 * �@�@�\�F�@�f�[�^�x�[�X�R�l�N�V��������郁�\�b�h�B
	 *
	 * ���@���F�@�Ȃ��B
	 * �߂�l�F�@�Ȃ��B
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

	/*
	 * �@�@�\�F�@�f�[�^�x�[�X�R�l�N�V�������J�����\�b�h�B
	 *
	 * ���@���F�@�Ȃ��B
	 * �߂�l�F�@�Ȃ��B
	 * ���@���F�@�f�[�^�x�[�X�Ƃ̃R�l�N�V�������쐬���A�ڑ����s���B
	 */
	protected void init() throws DAOException {
		// �f�[�^�x�[�X�h���C�o�̓Ǎ�
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException();
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		}
	}

}

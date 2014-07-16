package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DAO�ŋ��ʂɎg�p����ڑ��E�ؒf�̂��߂̏����v���O����
//�G���[�����������ꍇ�̓��[�U��`��O���g���Ă����ʒm����
public class NewCommonDAO {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
	private static final String DB_USER = "postgres";
//	private static final String DB_PASSWORD = "postgres";
	private static final String DB_PASSWORD = "Univ2014";

	protected Connection conn;

	// �f�[�^�x�[�X�Ƃ̐ڑ����s�����߂̃��\�b�h
	protected void init() throws DAOException {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		} catch (SQLException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		}
	}

	// �f�[�^�x�[�X�Ƃ̃R�l�N�V������ؒf���郁�\�b�h
	protected void destroy() throws DAOException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// ���[�U��`��O���g�p���ăG���[��ʒm����
			throw new DAOException();
		}
	}
	
}
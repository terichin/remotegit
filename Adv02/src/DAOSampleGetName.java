import dao.DAOSample;


// DAO�𗘗p��employee�e�[�u������f�[�^���擾����v���O����
public class DAOSampleGetName {
	public static void main(String[] args) {
		// DAO�N���X�𗘗p����ꍇ�̓I�u�W�F�N�g�𐶐�����
		DAOSample dao = new DAOSample();

		// DAO�N���X�̃I�u�W�F�N�g���g�p����DB�ɃA�N�Z�X����
		String result = dao.getName(100);
		if (result == null) {
			// �擾���s���̓G���[���b�Z�[�W��\������
        	System.out.println("�w�肳�ꂽID��������܂���B");
		} else {
			// �擾�������͎擾�����f�[�^��\������
			System.out.println("ID100�̎�����" + result + "�ł��B");
		}
	}
}
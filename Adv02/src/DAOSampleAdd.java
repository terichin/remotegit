import dao.DAOSample;


// DAO�𗘗p��employee�e�[�u������f�[�^���擾����v���O����
public class DAOSampleAdd {
	public static void main(String[] args) {
		DAOSample dao = new DAOSample();
		
		int id = 200;
		String name = "���j�o�Ԏq";
		String password = "univ875";
		
		// �f�[�^��EMPLOYEE�e�[�u���ɒǉ�����
		int count = dao.add(id, name, password);
		if (count != 1) {
			System.out.println("�f�[�^�̑}���Ɏ��s���܂����B");
		} else {
			System.out.println(count + "�s�ǉ����܂����B");
		}
	}
}
class AccessorUser1 {
	public static void main(String[] args) {
		// Accessor1�N���X�̃C���X�^���X�𐶐�
		Accessor1 obj = new Accessor1();
		// ���������I�u�W�F�N�g�̃����o�ϐ��ɒl��ݒ肷��
		obj.setValue(9900);
		// �I�u�W�F�N�g�̃����o�ϐ��̒l���擾����
		int num = obj.getValue();
		// �擾�����l��\������
		System.out.println(num);
	}
}
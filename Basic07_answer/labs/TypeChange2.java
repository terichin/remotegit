class TypeChange2 {
	public static void main(String[] args) {
		// �C���X�^���X�̐���
		InheritParent1 pobj = new InheritChild1();
		InheritChild1 cobj = new InheritChild1(); // �����𒼂��܂�
		// ���L�̋L�q�ŁA�R���p�C���G���[�ƂȂ�s���w�E���܂�
		pobj.num1 = 1000;
		// pobj.num2 = 2000; InheritParent1�^�ɂ͊܂܂�Ă��܂���
		pobj.printParent();
		// pobj.printChild(); InheritParent1�^�ɂ͊܂܂�Ă��܂���
		// ���L�̋L�q����Ȃ����삳���邽�߂ɂ̓v���O������
		// �ǂ̂悤�ɏC�����Ȃ���΂����܂��񂩁H
		cobj.num1 = 3000;
		cobj.num2 = 4000;
		cobj.printParent();
		cobj.printChild();
	}
}
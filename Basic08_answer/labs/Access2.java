class Access2 {
	// ����J�̃����o�ϐ�num1
	private int num1 = 222;
	// ���J����郁���o�ϐ�num2
	public int num2 = 500;

	// ����J�̃����o���\�b�hprivatePrint
	private void privatePrint() {
		// �����o�ϐ�num1�̒l��\��
		System.out.println(num1);
		// �����o�ϐ�num2�̒l��\��
		System.out.println(num2);
	}

	// ���J����郁���o���\�b�hprint
	public void print() {
		// �����o���\�b�hprivatePrint�̌Ăяo��
		privatePrint();
	}
}
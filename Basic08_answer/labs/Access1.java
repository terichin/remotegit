class Access1 {
	// ����J�̃����o�ϐ�number1
	private double number1 = 123.45;
	// ���J����郁���o�ϐ�number2
	public double number2 = 567.89;

	// ����J�̃����o���\�b�hmyMethod
	private void myMethod() {
		// �����o�ϐ�number1�̒l��\��
		System.out.println(number1);
		// �����o�ϐ�number2�̒l��\��
		System.out.println(number2);
	}

	// ���J����郁���o���\�b�hprint
	public void print() {
		System.out.println("�I�u�W�F�N�g�͈ȉ��̒l�������Ă��܂��B");
		// myMethod���\�b�h�̌Ăяo��
		myMethod();
	}
}
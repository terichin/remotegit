class Sequence2 {
	// �ϐ��̐錾
	int number1 = 0;
	int number2 = 0;
	// �l��ݒ肷�郁�\�b�h
	void setNumber1(int number) {
		number1 = number;
	}
	void setNumber2(int number) {
		number2 = number;
	}
	// �l�����Z���s�����\�b�h
	void calc() {
		System.out.println("�a��" + (number1 + number2));
		System.out.println("�ς�" + (number1 * number2));
		System.out.println("����" + (number1 - number2));
		System.out.println("����" + (number1 / number2));
	}
}
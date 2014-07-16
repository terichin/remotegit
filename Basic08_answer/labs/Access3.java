// ���p��� 8-1�FImplementObject3�̏�������
class Access3 {
	// ���l����i�[���邽�߂̕ϐ�
	private int[] numbers = null;
	// �R�}���h���C�������̔z����쐬���郁�\�b�h
	private boolean changeArgsToNumbers(String[] args) {
		// �����z�񂪋�ł����false��Ԃ�
		if (args.length == 0) {
			return false;
		}
		// �z��̗̈���쐬
		numbers = new int[args.length];
		// �����ւ̕ϊ�
		for (int i = 0; i < args.length; i++) {
			numbers[i] = Integer.parseInt(args[i]);
		}
		return true;
	}
	// �o�u���\�[�g���\�b�h
	private void sortNumbers() {
		boolean loop = true; // ���[�v����p�ϐ�
		while (loop) {
			loop = false; // ���񃋁[�v�����Ȃ��悤�Z�b�g
			// �ȉ��͈��̏�����s�����߂̃��[�v
			// �v�f���̈��O�܂Ń��[�v����
			for (int i = 0; i < numbers.length - 1; i++) {
				// �召�֌W���t�Ȃ����ւ�
				if (numbers[i] > numbers[i + 1]) {
					int number = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = number;
					loop = true; // ����ւ����������̂Ŏ���̓��[�v����
				}
			}
		}
	}
	// �l��\�����郁�\�b�h
	public void printNumbers(String[] args) {
		if (changeArgsToNumbers(args) == false) {
			System.out.println("�����̒l������������ĉ������B");
			return;
		}
		sortNumbers();
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}
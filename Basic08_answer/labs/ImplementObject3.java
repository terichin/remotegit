public class ImplementObject3 implements InterfaceObject3 {
	// int�^�̒l���i�[���邽�߂̔z��
	int[] numbers = null;

	// �R�}���h���C�������̔z����쐬���郁�\�b�h
	public boolean changeArgsToNumbers(String[] args) {
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
	public void sortNumbers() {
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
	public void printNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// ���N���X�̃C���X�^���X�𐶐����Ď��s
		InterfaceObject3 obj = new ImplementObject3();
		if (obj.changeArgsToNumbers(args) == false) {
			System.out.println("�����̒l������������ĉ������B");
		} else {
			obj.sortNumbers();
			obj.printNumbers();
		}
	}
}
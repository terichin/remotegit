class InterfaceUtility1 {
	// printCalc���\�b�h�́A
	// �n���ꂽ�I�u�W�F�N�g��calculate()���\�b�h�̌��ʂ�\������
	static void printCalc(ImplementObject1 obj, int value) {
		// obj��calculate()���\�b�h�̌��ʂ�\������
		System.out.println(obj.calculate(value));
	}
	// printRate()���\�b�h�́A�n���ꂽ�I�u�W�F�N�g��getRate()���\�b�h�̌��ʂ�\������
	static void printRate(ImplementObject2 obj) {
		// obj�̃����o�ϐ�rate�̒l���擾�A�\������
		System.out.println(obj.getRate());
	}
}
class ImplementObject2 implements InterfaceObject1 {
	// rate1�ϐ��� double �^��0.20�ŏ���������悤��`����B
	double rate1 = 0.20;

	// rate2�ϐ��� double �^��0.60�ŏ���������悤��`����B
	double rate2 = 0.60;

	// getRate()���\�b�h�� double�ƒ�`����B
	public double getRate() {
		// multiplyRate() �� plusRate() �̎��s���ʂ𑫂����l��Ԃ��B
		return multiplyRate() + plusRate();
	}
	// multiplyRate()���\�b�h�� double�ƒ�`����B
	double multiplyRate() {
		// rate1 �� rate2 �|�����l��Ԃ��B
		return rate1 * rate2;
	}
	// plusRate()���\�b�h�� double �ƒ�`����B
	double plusRate() {
		// rate1 �� rate2 �������l��Ԃ��B
		return rate1 + rate2;
	}
	// calculate()���\�b�h�́Adouble �Ɛ錾���A
	// int�^����value���󂯎��悤��`����
	public double calculate(int value) {
		// value �� getRate() �̏�Z���ʂ�Ԃ��B
		return value * getRate();
	}
	public static void main(String[] args) {
		// ImplementObject2 �N���X�̃C���X�^���X�𐶐�����
		// ImplementObject2�^�̕ϐ� obj �ɑ������B
		ImplementObject2 obj = new ImplementObject2();
		// obj �� calculate()���\�b�h�����s����B
		// ������100�Ƃ���B���s���ʂ�\������B
		System.out.println(obj.calculate(100));
		// obj �� plusRate()���\�b�h�̎��s���ʂ�\������B
		System.out.println(obj.plusRate());
		// obj �� multiplyRate()���\�b�h�̎��s���ʂ�\������B
		System.out.println(obj.multiplyRate());
	}
}
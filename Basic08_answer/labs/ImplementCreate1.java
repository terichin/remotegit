class ImplementCreate1 {
	public static void main(String[] args) {
		// ImplementObject1 �N���X�̃C���X�^���X�𐶐�����
		// ImplementObject1�^�̕ϐ� obj1 �ɑ������B
		ImplementObject1 obj = new ImplementObject1();
		// obj �� calculate()���\�b�h�����s����B
		// ������100�Ƃ���B���s���ʂ�\������B
		System.out.println(obj.calculate(100));
		// obj �� printRate()���\�b�h�����s����B
		obj.printRate();
	}
}
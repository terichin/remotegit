class ImplementCreate3 {
	public static void main(String[] args) {
		// ImplementObject1 �N���X�̃C���X�^���X�𐶐�����
		// ImplementObject1�^�̕ϐ� obj1 �ɑ������B
		ImplementObject1 obj1 = new ImplementObject1();
		// ImplementObject2 �N���X�̃C���X�^���X�𐶐�����
		// ImplementObject2�^�̕ϐ� obj2 �ɑ������B
		ImplementObject2 obj2 = new ImplementObject2();
		// InterfaceUtility1��printCalc()���\�b�h�����s�B
		// ������ obj1 ,100�Ƃ���B���s���ʂ�\������B
		InterfaceUtility1.printCalc(obj1, 100);
		// InterfaceUtility1��printRate()���\�b�h�����s�B
		// ������ obj2 �Ƃ���B���s���ʂ�\������B
		InterfaceUtility1.printRate(obj2);
	}
}
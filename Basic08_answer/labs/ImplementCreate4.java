class ImplementCreate4 {
	public static void main(String[] args) {
		// ImplementObject1 �N���X�̃C���X�^���X�𐶐�����
		// InterfaceObject1�^�̕ϐ� obj1 �ɑ������B
		InterfaceObject1 obj1 = new ImplementObject1();
		// ImplementObject2 �N���X�̃C���X�^���X�𐶐�����
		// InterfaceObject1�^�̕ϐ� obj2 �ɑ������B
		InterfaceObject1 obj2 = new ImplementObject2();
		// InterfaceUtility2��calculate()���\�b�h�����s�B
		// ������ obj1 �� 100 �Ƃ���B���s���ʂ�\������B
		System.out.println(InterfaceUtility2.calculate(obj1, 100));
		// InterfaceUtility2��calculate()���\�b�h�����s�B
		// ������ obj2 �� 100 �Ƃ���B���s���ʂ�\������B
		System.out.println(InterfaceUtility2.calculate(obj2, 100));
	}
}
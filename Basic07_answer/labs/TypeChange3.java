class TypeChange3 {
	public static void main(String[] args) {
		InheritChild1 obj = new InheritChild1();
		obj.printParent();
		obj.printChild();
		// ���������I�u�W�F�N�g�������n��
		// �^���قȂ邪�󂯓n�������\
		useParent1(obj);
	}
	// InheritParent1�^�̃C���X�^���X���g�p���郁�\�b�h
	static void useParent1(InheritParent1 obj) {
		obj.printParent();
	}
}
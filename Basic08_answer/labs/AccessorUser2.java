class AccessorUser2 {
	public static void main(String[] args) {
		// Accessor2�N���X�̃I�u�W�F�N�g�𐶐����܂�
		Accessor2 obj = new Accessor2();
		// ���������I�u�W�F�N�g�̂ɒl��ݒ肵�܂�
		obj.setName(args[0]);
		// ���������I�u�W�F�N�g����ݒ肵���l���擾���A�\�����܂�
		String name = obj.getName();
		System.out.println(name);
	}
}
class ReferenceType3 {
	public static void main(String[] args) {
		ReferenceObject1 obj = createObject();
		obj.printNumber();
	}
	// �I�u�W�F�N�g�𐶐����A�Ԃ����\�b�h
	static ReferenceObject1 createObject() {
		ReferenceObject1 obj = new ReferenceObject1();
		obj.number1 = 200;
		obj.printNumber();
		return obj;
	}
}
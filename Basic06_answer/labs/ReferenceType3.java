class ReferenceType3 {
	public static void main(String[] args) {
		ReferenceObject1 obj = createObject();
		obj.printNumber();
	}
	// オブジェクトを生成し、返すメソッド
	static ReferenceObject1 createObject() {
		ReferenceObject1 obj = new ReferenceObject1();
		obj.number1 = 200;
		obj.printNumber();
		return obj;
	}
}
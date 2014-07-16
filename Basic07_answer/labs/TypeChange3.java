class TypeChange3 {
	public static void main(String[] args) {
		InheritChild1 obj = new InheritChild1();
		obj.printParent();
		obj.printChild();
		// 生成したオブジェクトを引き渡す
		// 型が異なるが受け渡す事が可能
		useParent1(obj);
	}
	// InheritParent1型のインスタンスを使用するメソッド
	static void useParent1(InheritParent1 obj) {
		obj.printParent();
	}
}
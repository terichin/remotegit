class TypeChange2 {
	public static void main(String[] args) {
		// インスタンスの生成
		InheritParent1 pobj = new InheritChild1();
		InheritChild1 cobj = new InheritChild1(); // ここを直します
		// 下記の記述で、コンパイルエラーとなる行を指摘します
		pobj.num1 = 1000;
		// pobj.num2 = 2000; InheritParent1型には含まれていません
		pobj.printParent();
		// pobj.printChild(); InheritParent1型には含まれていません
		// 下記の記述を問題なく動作させるためにはプログラムを
		// どのように修正しなければいけませんか？
		cobj.num1 = 3000;
		cobj.num2 = 4000;
		cobj.printParent();
		cobj.printChild();
	}
}
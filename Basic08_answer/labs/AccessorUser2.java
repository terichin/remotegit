class AccessorUser2 {
	public static void main(String[] args) {
		// Accessor2クラスのオブジェクトを生成します
		Accessor2 obj = new Accessor2();
		// 生成したオブジェクトのに値を設定します
		obj.setName(args[0]);
		// 生成したオブジェクトから設定した値を取得し、表示します
		String name = obj.getName();
		System.out.println(name);
	}
}
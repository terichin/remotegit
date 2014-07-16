class ValueObject {
	int extension = 0; // 内線番号
	String name = null; // 氏名
	// コンストラクタ
	ValueObject(int extension, String name) {
		this.extension = extension;
		this.name = name;
	}
	// 値の表示メソッド
	void printInformation() {
		System.out.println("内線番号は" + extension + "です。");
		System.out.println("氏名は" + name + "です。");
	}
}
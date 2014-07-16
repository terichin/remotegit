class FindUtility {
	// 検索データの定義
	int[] extension = { 100, 200, 300 };
	String[] name = { "山田太郎", "鈴木一郎", "佐藤花子" };

	// 番号による検索メソッド
	ValueObject findByExtension(int extension) {
		for (int i = 0; i < this.extension.length; i++) {
			// 見つかったとき
			if (extension == this.extension[i]) {
				ValueObject obj = new ValueObject(this.extension[i], name[i]);
				return obj;
			}
		}
		return null; // 見つからない時はnullを返す
	}

	// 名前による検索メソッド
	ValueObject findByName(String name) {
		for (int i = 0; i < this.name.length; i++) {
			// 見つかったとき
			if (this.name[i].indexOf(name) != -1) {
				ValueObject obj = new ValueObject(extension[i], this.name[i]);
				return obj;
			}
		}
		return null; // 見つからない時はnullを返す
	}
}
class FindCall {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("検索モードと検索条件を入力して下さい。");
		} else {
			// 検索条件の確認
			int mode = Integer.parseInt(args[0]);
			FindUtility obj = new FindUtility();
			ValueObject vo = null;
			if (mode == 1) { // 番号検索
				vo = obj.findByExtension(Integer.parseInt(args[1]));
			} else if (mode == 2) { // 氏名検索
				vo = obj.findByName(args[1]);
			} else {
				System.out.println("モードの指定が間違っています。");
				return;
			}
			if (vo == null) {
				System.out.println("検索結果が見つかりません。");
			} else {
				vo.printInformation();
			}
		}
	}
}
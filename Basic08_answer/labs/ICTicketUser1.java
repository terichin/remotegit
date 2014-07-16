class ICTicketUser1 {
	public static void main(String[] args) {
		// Suicaオブジェクトを作成し、500円をチャージ
		ICTicket ic = new ICTicketSuica();
		ic.charge(500);

		// 新宿～秋葉原間を乗車
		ic.saveStart("新宿");
		pay(ic, "秋葉原", 160);

		// 秋葉原～新宿間を乗車
		ic.saveStart("秋葉原");
		pay(ic, "新宿", 160);

		// 新宿～池袋間を乗車
		ic.saveStart("新宿");
		pay(ic, "池袋", 150);

		// 池袋～上野間を乗車
		ic.saveStart("池袋");
		pay(ic, "上野", 160);

		// 履歴表示
		ic.printHistory();
	}

	static void pay(ICTicket ic, String endStation, int price) {
		// 残額不足を確認し、不足時はエラーメッセージを出力する
		if (ic.pay(endStation, price) == false) {
			System.out.println("残額不足です。チャージしてください。");
		}
	}
}
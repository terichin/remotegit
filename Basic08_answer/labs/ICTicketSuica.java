class ICTicketSuica implements ICTicket {
	// カード残額
	int money = 0;
	// 乗車駅
	String startStation;
	// 利用履歴
	ICTicketInfo[] history = new ICTicketInfo[100];

	public void charge(int price) {
		// 指定の金額をチャージする
		this.money += price;
	}

	public boolean pay(String endStation, int price) {
		if (price > money) {
			// チャージ額が不足する場合は減らさずにfalseを返す
			return false;
		} else {
			// 指定の金額をチャージ額から減らす
			this.money -= price;
			// 使用履歴更新
			for (int i = history.length - 1; i > 0; --i) {
				// 現在の履歴情報を1つずつ後ろにずらす
				history[i] = history[i - 1];
			}
			// 配列の先頭に最新の履歴情報を保存する
			history[0] = new ICTicketInfo(startStation, endStation, price);
			return true;
		}
	}

	public void printHistory() {
		// 残高を表示する
		System.out.println("残額は" + money + "円です");
		System.out.println("乗車駅\t降車駅\t運賃");
		for (int i = 0; i < history.length; ++i) {
			// 配列から履歴情報を1つ取り出し、表示する
			ICTicketInfo info = history[i];
			if (info == null) {
				break;
			}
			System.out.println(info.startStation + "\t" + info.endStation
					+ "\t" + info.price);
		}
	}

	public void saveStart(String startStation) {
		// 乗車駅をメンバ変数に保存する
		this.startStation = startStation;
	}
}
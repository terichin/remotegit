interface ICTicket {
	// カード残額を増やします
	void charge(int price);
	// 降車駅での処理を実施します
	boolean pay(String endStation, int price);
	// 利用履歴を表示します
	void printHistory();
	// 乗車駅を記録します
	void saveStart(String startStation);
}
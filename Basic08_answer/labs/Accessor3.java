class Accessor3 {
	// 時刻を保持するためのメンバ変数
	private int hour;
	private int minute;
	private int second;
	// コンストラクタ
	public Accessor3() {
		// カレンダーから時間を取得
		java.util.Calendar cal = java.util.Calendar.getInstance();
		hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		minute = cal.get(java.util.Calendar.MINUTE);
		second = cal.get(java.util.Calendar.SECOND);
	}
	// アクセッサメソッド
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}

	public static void main(String[] args) {
		Accessor3 obj = new Accessor3();
		System.out.println("現在の時刻は" + obj.getHour() 
                + "時" + obj.getMinute()
                + "分" + obj.getSecond() + "秒です。");
	}
}
class OverLoadObject3 {
    // 時刻を保存する為のメンバ変数
    int hour;
    int minute;
    int second;
    // コンストラクタ
    OverLoadObject3() {
    	// カレンダーから時間を取得
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
    	minute = cal.get(java.util.Calendar.MINUTE);
    	second = cal.get(java.util.Calendar.SECOND);
    }
    // 日本標準時を表示するメソッド
    void printTime() {
	System.out.println("時刻は" + hour + ":" + 
			   minute + ":" + second + "です。");
    }
    // 他国の時刻を表示するメソッド
    void printTime(int time) {
    	// 補正値のチェック
    	if ((time < -11) || (time > 11)) {
    		System.out.println("時刻が表示出来ません。");
    		return;
    	}
    	// 時刻の補正
    	int newhour = hour + time;
    	if (newhour < 0) {
    		newhour += 24;
    	} else if (newhour >= 24) {
    		newhour -= 24;
    	}
    	// 時刻の表示
    	System.out.println("時刻は" + newhour + ":" + 
    			minute + ":" + second + "です。");
    }
}
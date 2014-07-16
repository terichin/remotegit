class InheritParent3 {
    int hour;
    int minute;
    int second;
    // コンストラクタ
    InheritParent3() {
    	// カレンダーから時間を取得
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
    	minute = cal.get(java.util.Calendar.MINUTE);
    	second = cal.get(java.util.Calendar.SECOND);
    }
    // 日本標準時を取得する
    String getTime() {
    	return hour + ":" + minute + ":" + second;
    }
}
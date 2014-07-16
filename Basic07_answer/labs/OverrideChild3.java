class OverrideChild3 extends InheritChild3{
	// 世界標準時を取得するメソッド
    String getWorldTime() {
    	return "世界標準時は" + super.getWorldTime() + "です。";
    }
    // 日本標準時をオーバーライドしたメソッド
    String getTime() {
    	return "日本標準時は" + super.getTime() + "です。";
    }
}
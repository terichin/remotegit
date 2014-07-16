class ConstructorObject3 {
    // 機能を制御する為のメンバ変数
    int function = 0;
    // コンストラクタ
    ConstructorObject3(int function) {
    	this.function = function;
    }
    // 計算を行うためのメソッド
    int calc(int num1, int num2) {
    	if (function == 0) {
    		return num1 + num2;
    	}
    	// 以下はelse文に入れても良い。
    	return num1 * num2;
    }
}
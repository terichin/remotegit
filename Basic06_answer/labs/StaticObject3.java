class StaticObject3 {
    // 機能を制御する為のメンバ変数
    static int function = 0;
    // 計算を行うためのメソッド
    static int calc(int num1, int num2) {
        if (function == 0) {
            return num1 + num2;
        }
        // 以下はelse文に入れても良い。
        return num1 * num2;
    }
}
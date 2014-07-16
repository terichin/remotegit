// 基礎問題7-4 サブクラスを使用するプログラム
class InheritUser2 {
    public static void main(String[] args) {
        // サブクラスのインスタンスを生成しています
        InheritChild2 obj = new InheritChild2();
        // インスタンスのメンバ変数に計算したい値をセットします
        obj.number = 10000;
        // 税込みの値を計算し、表示します
        obj.printResult();
    }
}
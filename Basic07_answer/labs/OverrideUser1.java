// 基本問題7-6 オーバーライドされたメソッドを呼び出す
class OverrideUser1 {
    public static void main(String[] args) {
        // サブクラスのインスタンスを生成しています
        OverrideChild1 obj = new OverrideChild1();
        // 生成したインスタンスのメソッドを呼び出します
        // オーバーライドされているため、サブクラスの処理が実行されます
        obj.greet();
    }
}
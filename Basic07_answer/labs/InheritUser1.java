// 基本問題7-4 サブクラスを使用するプログラム
class InheritUser1 {
    public static void main(String[] args) {
        // サブクラスのインスタンスを生成しています
        InheritChild1 obj = new InheritChild1();
        // スーパークラスのメンバ変数の値を表示します
        System.out.println(obj.num1);
        // スーパークラスのメソッド呼び出しをします
        obj.printParent();
        // サブクラスのメンバ変数の値を表示します
        System.out.println(obj.num2);
        // サブクラスのメソッド呼び出しをします
        obj.printChild();
    }
}
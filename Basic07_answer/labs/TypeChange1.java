// 基本問題7-7 インスタンスの型変換をする
class TypeChange1 {
    public static void main(String[] args) {
        // Parent1型の変数を定義します
        InheritParent1 obj;
        // Child1クラスのインスタンスを生成し、Parent1型の変数に代入します
        obj = new InheritChild1();
        // 生成したインスタンスのメソッドを呼び出します
        obj.printParent();
    }
}
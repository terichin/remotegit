class ConstructorCall1 {
    // main()メソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // ConstructorObject1 クラスのインスタンスを生成して obj1 変数に代入する。
        // 引数は88とする。
        ConstructorObject1 obj1 = new ConstructorObject1(88);
        // obj1変数のprintValue()メソッドを実行する。
        obj1.printValue();
    }
}
class OverLoadCall1 {
    // mainメソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // OverLoadObject1 クラスのインスタンスを生成して obj1 変数に代入する。
        OverLoadObject1 obj1 = new OverLoadObject1();
        // obj1変数のprintValue()メソッドを実行する。
        obj1.printValue();
        // obj2変数のprintValue()メソッドを実行する。引数は"値は"とする。
        obj1.printValue("値は");
    }
}
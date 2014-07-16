class ConstructorCall2 {
    // main()メソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // ConstructorObject2_1 クラスのインスタンスを生成して obj1 変数に代入する。
        ConstructorObject2_1 obj1 = new ConstructorObject2_1();
        // obj1変数のsetValue()メソッドを実行する。引数は 88 とする。
        obj1.setValue(88);
        // obj1変数のprintValue()メソッドを実行する。
        obj1.printValue();

        // ConstructorObject2_2 クラスのインスタンスを生成して obj2 変数に代入する。
        ConstructorObject2_2 obj2 = new ConstructorObject2_2();
        // obj2変数のsetValue()メソッドを実行する。引数は 88 とする。
        obj2.setValue(88);
        // obj2変数のprintValue()メソッドを実行する。
        obj2.printValue();
    }  
}
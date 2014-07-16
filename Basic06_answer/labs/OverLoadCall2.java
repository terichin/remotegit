class OverLoadCall2 {
	// main()メソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // OverLoadObject2 クラスのインスタンスを生成して obj1 変数に代入する。
        OverLoadObject2 obj1 = new OverLoadObject2();
        // OverLoadObject2 クラスのインスタンスを生成して obj2 変数に代入する。
        // 引数は 15 とする。
        OverLoadObject2 obj2 = new OverLoadObject2(15);
        // OverLoadObject2 クラスのインスタンスを生成して obj3 変数に代入する。
        // 引数は 20,3 とする。
        OverLoadObject2 obj3 = new OverLoadObject2(20,3);
        
    	// obj1変数のprintValue()メソッドを実行する。
        obj1.printValue();
        // obj2変数のprintValue()メソッドを実行する。引数は"値は"とする。
        obj2.printValue("値は");
        // obj3変数のprintValue()メソッドを実行する。
        // 引数は"value は"と"です"とする。
        obj3.printValue("value は", "です");
    }
}
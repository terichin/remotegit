class ReferenceType2 {
    public static void main(String[] args) {
        // ReferenceObject1 クラスのインスタンスを生成して obj1 変数に代入する。
        ReferenceObject1 obj1 = new ReferenceObject1();
        // ReferenceObject1 クラスのインスタンスを生成して obj2 変数に代入する。
        ReferenceObject1 obj2 = new ReferenceObject1();
        // 変数 obj3 にobj1を代入する。
        ReferenceObject1 obj3 = obj1;
        
        // obj1変数のnumber1に333を代入する。
        obj1.number1 = 333;
        // obj2変数のnumber1に777を代入する。
        obj2.number1 = 777;
        // obj3変数のnumber1に555を代入する。
        obj3.number1 = 555;
        // obj1のprintNumber()メソッドを実行する。
        obj1.printNumber();
        // obj2のprintNumber()メソッドを実行する。
        obj2.printNumber();
        // obj3のprintNumber()メソッドを実行する。
        obj3.printNumber();
        
        // 変数 obj3 にobj2を代入する。
        obj3 = obj2;
        // obj3変数のnumber1に555を代入する。
        obj3.number1 = 555;
        // obj1のprintNumber()メソッドを実行する。
        obj1.printNumber();
        // obj2のprintNumber()メソッドを実行する。
        obj2.printNumber();
        // obj3のprintNumber()メソッドを実行する。
        obj3.printNumber();
    }
}
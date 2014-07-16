class ReferenceType1 {
    public static void main(String[] args) {
        // 変数number1をint型で50で初期化して宣言する。
        int number1 = 50;
        // 変数number2に変数number1を代入する。
        int number2 = number1;
        // number1に100を代入する。
        number1 = 100;
        // 変数number1を表示する。
        System.out.println(number1);
        // 変数number2を表示する。
        System.out.println(number2);
        // ReferenceObject1 クラスのインスタンスを生成して obj1 変数に代入する。
        ReferenceObject1 obj1 = new ReferenceObject1();
        // 変数 obj2 にobj1を代入する。
        ReferenceObject1 obj2 = obj1;
        // obj1変数のnumber1に500を代入する。
        obj1.number1 = 500;
        // obj1のprintNumber()メソッドを実行する。
        obj1.printNumber();
        // obj2のprintNumber()メソッドを実行する。
        obj2.printNumber();
    }
}
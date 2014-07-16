class MemberAccess2 {
    public static void main(String[] args) {
        // InstanceObject2 クラスのインスタンスを生成して obj1 変数に代入する。
        InstanceObject2 obj1 = new InstanceObject2();
        // InstanceObject2 クラスのインスタンスを生成して obj2 変数に代入する。
        InstanceObject2 obj2 = new InstanceObject2();
        // obj1変数のprint()メソッドを実行する。引数は「Thank you!」とする
        obj1.print("Thank you!");
        // obj1変数のnumber1に200を代入する。
        obj1.number1=200;
        // obj1変数のgetNumber()メソッドを実行して
        // 実行結果を変数returnNumber1に代入する。
        int returnNumber1 = obj1.getNumber();
        // returnNumber1を表示する。
        System.out.println(returnNumber1);
        // obj2変数のnumber1に300を代入する。
        obj2.number1=300;
        // obj2変数のgetNumber()メソッドを実行して
        // 実行結果を変数returnNumber2に代入する。
        int returnNumber2 = obj2.getNumber();
        // returnNumber2を表示する。
        System.out.println(returnNumber2);
    }
}
class MemberAccess1 {
    public static void main(String[] args) {
        // InstanceObject1 クラスのインスタンスを生成して obj1 変数に代入する。
        InstanceObject1 obj1 = new InstanceObject1();
        // obj1変数のprint()メソッドを実行する。引数は「Hello」とする
        obj1.print("Hello");
        // obj1変数のnumber1に150を代入する。
        obj1.number1=150;
        // obj1変数のnumber1を変数returnNumber1に代入する。
        int returnNumber1 = obj1.number1;
        // returnNumber1を表示する。
        System.out.println(returnNumber1);
    }
}
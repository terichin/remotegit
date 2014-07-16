class InstanceObject2 {
    // number1変数は、int型で100で初期化するよう定義する。
    int number1 = 100;
    
    // print()メソッドは、voidと宣言しString型引数msgを受け取るよう定義する。
    void print(String msg) {
        // 変数msgを表示する。
        System.out.println(msg);
    }

    // getNumber()メソッドは、int と宣言し定義する。
    int getNumber() {
        // 変数number1を返却する。
        return number1;
    }
}
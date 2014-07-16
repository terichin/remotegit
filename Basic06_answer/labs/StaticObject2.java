class StaticObject2 {
    // number1変数は static int型で値を100で初期化するよう定義する。
    static int number1 = 100;
    
    // plus()メソッドは、static voidと宣言しint型引数valueを受け取るよう定義する。
    static void plus(int value) {
        // number1 に value を足した値を表示する。
        System.out.println(number1 + value);
    }
    
    // number2変数は int型で値を2000で初期化するよう定義する。
    int number2 = 2000;
    
    // minus()メソッドは、voidと宣言しint型引数valueを受け取るよう定義する。
    void minus(int value) {
        // number2 から value を引いた値を表示する。
        System.out.println(number2 - value);
    }
    
    // main()メソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // static オブジェクト StaticObject2 の number1 変数に 150 を代入する。
        StaticObject2.number1 = 150;

        // StaticObject2 クラスのインスタンスを生成して obj1 変数に代入する
        StaticObject2 obj1 = new StaticObject2();
        // obj1変数のnumber2に500を代入する。
        obj1.number2 = 500;
        // obj1変数のplus()メソッドを実行する。引数は10とする。
        obj1.plus(10);
        // obj1変数のminus()メソッドを実行する。引数は10とする。
        obj1.minus(10);
        
        // StaticObject2 クラスのインスタンスを生成して obj2 変数に代入する
        StaticObject2 obj2 = new StaticObject2();
        // obj2変数のnumber2に400を代入する。
        obj2.number2 = 400;
        // obj2変数のplus()メソッドを実行する。引数は10とする。
        obj2.plus(10);
        // obj2変数のminus()メソッドを実行する。引数は10とする。
        obj2.minus(10);
    }
}
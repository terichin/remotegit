class StaticObject1 {
    //  number1変数は、int型で100で初期化するよう定義する。
    static int number1 = 100;
    
    //  printメソッドは、statc voidと宣言しString型引数msgを受け取るよう定義する。
    static void print(String msg) {
        // 文字リテラル"Hello " と変数msgを連結して表示する。
        System.out.println("Hello " + msg );
    }   
}
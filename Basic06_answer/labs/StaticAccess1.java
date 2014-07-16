class StaticAccess1 {
    // mainメソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // static オブジェクト StaticObject1 の number1 変数に 200 を代入する。
        StaticObject1.number1 =200;
        // static オブジェクト StaticObject1 の number1 を表示する。
        System.out.println(StaticObject1.number1);
        // static オブジェクト StaticObject1 の print()メソッドに
        // 引数 "John" を代入して実行する。
        StaticObject1.print("John");
    }
}
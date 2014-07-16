class OverLoadObject2 {
    // value変数は int型で定義する。
    int value;
    // コンストラクタを定義する。
    OverLoadObject2() {
        // value に10を代入する。
        value =10;
    }
    // コンストラクタは、int型引数value1を受け取るよう定義する。
    OverLoadObject2(int value1) {
        // value に value1を代入する。
        value = value1;
    }
    // コンストラクタは、int型引数value1とint型引数value2を受け取るよう定義する。
    OverLoadObject2(int value1, int value2) {
        // value に value1 と value2 の積を代入する。
        value = value1 * value2;
    }
    // printValue()メソッドは、voidと定義する。    
    void printValue(){
        // value を表示する。
        System.out.println(value);
    }
    // printValue()メソッドは、voidと宣言しString型引数msg1を受け取るよう定義する。
    void printValue(String msg1){
        // msg1 と value を連結して表示する。
        System.out.println(msg1 + value);
    }
    // printValue()メソッドは、voidと宣言し
    // String型引数msg1とString型引数msg2を受け取るよう定義する。
    void printValue(String msg1, String msg2){
        // msg1 と value と msg2 を連結して表示する。
        System.out.println(msg1 + value + msg2);
    }
}
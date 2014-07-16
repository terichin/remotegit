class OverLoadObject1 {
    // value変数は int型で定義する。
    int value;    
    // コンストラクタを定義する。
    OverLoadObject1() {
        // value に10を代入する。
        value =10;
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
}
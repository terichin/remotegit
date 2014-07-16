class ConstructorObject1 {
    // value変数は int型で定義する。
    int value;
    
    // コンストラクタは、int型引数value1を受け取るよう定義する。
    ConstructorObject1(int value1) {
        // value に value1を代入する。
        value = value1;
    }

    // printValue()メソッドは、voidと定義する。
    void printValue() {
        // value を表示する。
        System.out.println(value);
    }
}
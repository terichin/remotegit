class ImplementObject1 implements InterfaceObject1 {
    // rate変数は、double型で0.20で初期化するよう定義する。
    double rate = 0.20;

    // getRate()メソッドは doubleと定義する。
    public double getRate() {
        // rate を返す
        return rate;
    }

    // printRate()メソッドは void と定義する。
    void printRate() {
        // rate を表示する。
        System.out.println(rate);
    }

    // calculate()メソッドは、
    // double と宣言しint型引数valueを受け取るよう定義する
    public double calculate(int value) {
        // value と getRate() の乗算結果を返す。
        return value * getRate();
    }
}
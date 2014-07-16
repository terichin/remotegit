class OverLDSample {

    double tax = 0.0;
    OverLDSample() {
        tax = 0.05;
    }
    OverLDSample(double tax) {
        this.tax = tax;
    }
    // 以下は消費税の金額を計算するメソッド
    void printTax(double price) {
        System.out.println(price*tax);
    }
    void printTax(String message, double price) {
        System.out.println(message + price*tax);
    }
}

class OverLDSample {

    double tax = 0.0;
    OverLDSample() {
        tax = 0.05;
    }
    OverLDSample(double tax) {
        this.tax = tax;
    }
    // �ȉ��͏���ł̋��z���v�Z���郁�\�b�h
    void printTax(double price) {
        System.out.println(price*tax);
    }
    void printTax(String message, double price) {
        System.out.println(message + price*tax);
    }
}

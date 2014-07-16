class InitSample {

    double tax = 0.0;
    InitSample(double tax) {
        this.tax = tax;
    }
    void calcPrint(double price) {
        double answer = price + price * tax;
        System.out.println(answer);
    }
}

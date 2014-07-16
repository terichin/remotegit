class ThisSample {

    double tax = 0.0;
    String name ="";
    ThisSample() {
        tax = 0.05;
    }
    ThisSample(double tax) {
        this.tax = tax;
    }
    ThisSample(String name) {
        this();
        this.name = name;
    }
}

abstract class AbsSample{
    
    double tax = 0.05 ;
    
    void printTax(double price) {
        double tax = price * this.tax;
        printMessage(tax);
    }
    abstract void printMessage(double tax);
}

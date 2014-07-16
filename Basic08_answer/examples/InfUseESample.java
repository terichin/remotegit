class InfUseESample implements InfSample2 {
    public void printTax(double value)  {
        double answer = value * 0.05;
        System.out.println("The tax is $" + answer + ".");
    }
}
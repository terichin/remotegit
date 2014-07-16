class InheritSample2 extends InheritSample {
    InheritSample2(int num1, int num2) {
        super(num1, num2);
    }
    
    int multi() {
        return number1 * number2;
    }
    
    int div() {
        return number1 / number2;
    }
}
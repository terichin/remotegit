class InheritSample {
    int number1 = 0;
    int number2 = 0;
    
    InheritSample(int num1, int num2) {
        number1 = num1;
        number2 = num2;
    }
    
    int add() {
        return number1 + number2;
    }

    int sub() {
        return number1 - number2;
    }
}
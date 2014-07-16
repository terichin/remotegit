class AccsSample {
    private int number1 = 10;
    public int number2 = 20;
    
    private void myMethod() {
        System.out.println(number1);
        System.out.println(number2);
    }
    
    public void print() {
        System.out.println("オブジェクトは以下の値を持っています。");
        myMethod();
    }
}
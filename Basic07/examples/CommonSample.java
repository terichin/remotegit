class CommonSample {
    public static void main(String[] args) {
        AddSample add = new AddSample();
        add.num1 = 9;
        add.num2 = 3;
        add.calc();

        SubSample sub = new SubSample();
        sub.num1 = 9;
        sub.num2 = 3;
        sub.calc();
    }
}
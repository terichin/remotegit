class StatAccsSample {
    public static void main(String[] args) {
        StaticSample.print1();
        System.out.println(StaticSample.num1);

        StaticSample obj = new StaticSample();
        obj.print2();
        System.out.println(obj.num2);
        obj.print1();
        System.out.println(obj.num1);
    }
}

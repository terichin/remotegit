class PoCommonSample {
    public static void main(String[] args) {
        PoAddSample add = new PoAddSample();
        add.num1 = 9;
        add.num2 = 3;
        printResult(add);

        PoSubSample sub = new PoSubSample();
        sub.num1 = 9;
        sub.num2 = 3;
        printResult(sub);
    }
    
    static void printResult(PoCalcBaseSample calc) {
        calc.calc();
        System.out.println("ŒvŽZŒ‹‰Ê‚Í" + calc.answer + "‚Å‚·");
    }
}
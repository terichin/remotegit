class ExpSample5 {
    public static void main(String[] args) {
        try {
            print(args);
        } catch (NumberFormatException e) {
            System.out.println("入力する値は数値でなければいけません。");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1つの数値を入力して下さい。");
        }
    }
    
    static void print(String[] args) throws
        NumberFormatException, ArrayIndexOutOfBoundsException {
        int number = Integer.parseInt(args[0]);
        System.out.println(number * 2);
    }
}
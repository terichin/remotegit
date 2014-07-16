class ExpSample4 {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(number * 2);
        } catch (NumberFormatException e) {
            System.out.println("入力する値は数値でなければいけません。");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1つの数値を入力して下さい。");
        } finally {
            System.out.println("プログラムが終了しました。");
        }
    }
}
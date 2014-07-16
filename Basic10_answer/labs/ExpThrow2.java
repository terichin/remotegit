class ExpThrow2 {
    public static void main(String[] args) {
        try {
            // throws宣言されたprint()メソッドの呼び出し
            print(args);
        } catch (MyException e) {
            // 自作の例外をキャッチし、メソッドを呼び出す
            e.printMessage();
        }
    }
    
    static void print(String[] args) throws MyException {
        try {
            // コマンドライン引数をint型に変換する
            int number = Integer.parseInt(args[0]);
            // 100を入力された数値で割り、結果を表示
            System.out.println(100 / number);
        } catch (NumberFormatException e) {
            // int型への変換失敗時の処理
            throw new MyException();
        } catch (ArrayIndexOutOfBoundsException e) {
            // コマンドライン引数が入力されていなかった場合の処理
            throw new MyException();
        } catch (ArithmeticException e) {
            // コマンドライン引数で0が入力された場合の処理
            throw new MyException();
        }
    }
}
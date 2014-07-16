class ExpCatchFinal1 {
    public static void main(String[] args) {
        try {
            // コマンドライン引数をint型に変換する
            int number = Integer.parseInt(args[0]);
            // 100を入力された数値で割り、結果を表示
            System.out.println(100 / number);
        } catch (NumberFormatException e) {
            // int型への変換失敗時のメッセージ
            System.out.println("入力する値は数値でなければいけません。");
        } catch (ArrayIndexOutOfBoundsException e) {
            // コマンドライン引数が入力されていなかった場合のメッセージ
            System.out.println("1つの数値を入力して下さい。");
        } catch (ArithmeticException e) {
            // コマンドライン引数で0が入力された場合のメッセージ
            System.out.println("0以外の数値を入力して下さい。");
        } finally {
            // 例外が起きても起きなくても実施する処理
            System.out.println("処理終了");
        }
    }
}
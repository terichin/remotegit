class ExpMultiCatch1 {
    public static void main(String[] args) {
        try {
            // コマンドライン引数をint型に変換する
            int number = Integer.parseInt(args[0]);
            // 階乗を計算して表示する
            System.out.println(number * number);
        } catch (NumberFormatException e) {
            // int型への変換失敗時のメッセージ
            System.out.println("入力する値は数値でなければいけません。");
        } catch (ArrayIndexOutOfBoundsException e) {
            // コマンドライン引数が入力されていなかった場合のメッセージ
            System.out.println("1つの数値を入力して下さい。");
        }
    }
}
class ExpThrows2 {
    public static void main(String[] args) {
        try {
            // throws宣言されたaverage()メソッドの呼び出し
            average(args);
        } catch (NumberFormatException e) {
            // int型への変換失敗時のメッセージ
            System.out.println("入力する値は数値でなければいけません。");
        } catch (ArithmeticException e) {
            // コマンドライン引数が入力されていなかった場合のメッセージ
            System.out.println("入力がありません。");
        }
    }
    
    // 入力された数値の平均値を求めるメソッド
    static void average(String[] args) throws 
        NumberFormatException, ArithmeticException {
        // 合計値を保存する変数の宣言
        int sum = 0;
        // String型配列を数値に変換して合計値を計算
        for (int i = 0; i < args.length; ++i) {
            sum += Integer.parseInt(args[i]);
        }
        
        // 合計値を要素数で割って、平均値を計算して表示
        int avg = sum / args.length;
        System.out.println("平均は" + avg + "です。");
    }
}
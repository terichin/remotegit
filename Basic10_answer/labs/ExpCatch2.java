class ExpCatch2 {
    public static void main(String[] args) {
        // 引数が1つではない場合はエラーとし、メッセージを表示
        if (args.length == 1) {
            try {
                // コマンドライン引数をint型に変換する
                int number = Integer.parseInt(args[0]);
                // 階乗を計算して表示する
                System.out.println(number * number);
            } catch (NumberFormatException e) {
                // 捕捉した例外のprintStackTraceメソッドを呼び出す
                e.printStackTrace();
            }
        } else {
            // 引数が1つではなかった場合はメッセージを表示
            System.out.println("1つの数値を入力して下さい。");
        }
    }
}
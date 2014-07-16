class ExpCatch1 {
    public static void main(String[] args) {
        // 引数が1つではない場合はエラーとし、メッセージを表示
        if (args.length == 1) {
            try {
                // コマンドライン引数をint型に変換する
                int number = Integer.parseInt(args[0]);
                // 階乗を計算して表示する
                System.out.println(number * number);
            } catch (NumberFormatException e) {
                // int型への変換に失敗した場合はメッセージを表示
                System.out.println("入力する値は数値でなければいけません。");
            }
        } else {
            // 引数が1つではなかった場合はメッセージを表示
            System.out.println("1つの数値を入力して下さい。");
        }
    }
}
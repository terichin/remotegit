class StaticAccess3 {
    public static void main(String[] args) {
        // コマンドライン引数が不足している時は警告を表示
        if (args.length != 2) {
            warnMessage();
        } else {
            // コマンドライン引数の取得
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            // 和の演算
            System.out.println(StaticObject3.calc(num1, num2));
            // 積の演算
            StaticObject3.function = 1;
            System.out.println(StaticObject3.calc(num1, num2));
        }
    }
    // コマンドライン引数が不足しているときのメッセージ機能
    static void warnMessage() {
        System.out.println("整数の値を2つ与えて下さい。");
    }
}
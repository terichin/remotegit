class MemberAccess3 {
    public static void main(String[] args) {
        // コマンドライン引数が不足している時は警告を表示
        if (args.length != 2) {
            warnMessage();
        } else {
            // 計算の為のインスタンスを生成する
            InstanceObject3 util1 = new InstanceObject3();
            InstanceObject3 util2 = new InstanceObject3();
            util2.function = 1;
            // 計算を行い、結果を表示
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println(util1.calc(num1, num2));
            System.out.println(util2.calc(num1, num2));
        }
    }
    // コマンドライン引数が不足しているときのメッセージ機能
    // staticを忘れるとコンパイルエラーになるので、注意する
    static void warnMessage() {
        System.out.println("整数の値を2つ与えて下さい。");
    }
}
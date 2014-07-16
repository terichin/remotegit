class OverLoadCall3 {
    public static void main(String[] args) {
        // コマンドライン引数のチェック
        if (args.length != 1) {
            System.out.println("時刻の補正値を１つ入れて下さい");
            return;
        } else {
            int time = Integer.parseInt(args[0]);
            OverLoadObject3 obj = new OverLoadObject3();
            obj.printTime();
            obj.printTime(time);
        }
    }
}
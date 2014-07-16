class ExpThrow1 {
    public static void main(String[] args) {
        try {
            // メッセージの表示
            System.out.println("プログラム開始。");
            // 自作の例外を発生させる
            throw new MyException();
        } catch (MyException e) {
            // 自作の例外をキャッチし、メソッドを呼び出す
            e.printErrorMessage();
        }
    }
}
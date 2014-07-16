// 自作の例外クラス(Exceptionを継承して作成)
class MyException extends Exception {
    void printErrorMessage() {
        // エラーメッセージの表示
        System.out.println("エラーが発生しました。");
    }
    
    // 基礎問題10-5の追加メソッド
    void printMessage() {
        // エラーメッセージの表示
        System.out.println("0以外の数値を1つ入力してください。");
    }
}
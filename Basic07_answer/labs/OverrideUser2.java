// 基礎問題7-6 superキーワードを使用するプログラム
class OverrideUser2 {
    public static void main(String[] args) {
        // 本の情報を保持するためのItemBookインスタンスを生成する
        ItemBook book = new ItemBook();
        // 作成したインスタンスに情報を保存する
        book.name = "Javaプログラミング基礎";
        book.price = 5000;
        book.author = "NTTデータユニバーシティ";
        book.isbn = "XXXX-YYYYYY-ZZZZ";
        // インスタンスに保存された商品情報を表示する
        book.printInformation();
    }
}
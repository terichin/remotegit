// 基礎問題7-6 superキーワードを使用するプログラム
// 本の商品情報を保存・表示する機能を持つクラスです
class ItemBook extends Item {
    // 作者名を保存するメンバ変数
    String author;
    // ISBN番号を保存するメンバ変数
    String isbn;

    void printInformation() {
        // ItemクラスのprintInformationを呼び出す(名前、価格の表示)
        super.printInformation();
        // 作者を表示
        System.out.println("作者は" + author + "です");
        // ISBN番号を表示
        System.out.println("ISBNは" + isbn + "です");
    }
}
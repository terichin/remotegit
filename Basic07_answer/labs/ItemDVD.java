// オプション問題7-1 superキーワードを使用するプログラム
// DVDの商品情報を保存・表示する機能を持つクラスです
class ItemDVD extends Item {
    // 収録時間を保存するメンバ変数
    int time;

    void printInformation() {
        // ItemクラスのprintInformationを呼び出す(名前、価格の表示)
        super.printInformation();
        // 収録時間を表示
        System.out.println("収録時間は" + time + "分です");
    }
}
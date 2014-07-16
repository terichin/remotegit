// 基礎問題7-6 superキーワードを使用するプログラム
// 商品の情報を保存・表示する機能を持つクラスです
class Item {
    // 商品名を保存するメンバ変数
    String name;
    // 商品価格を保存するメンバ変数
    int price;
    
    void printInformation() {
        // 商品名を表示
        System.out.println("商品名は" + name + "です");
        // 商品価格を表示
        System.out.println("価格は" + price + "円です");
    }
}
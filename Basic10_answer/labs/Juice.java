// ジュースクラスの雛形
// ジュースの共通機能(値段、味、ID情報の提供)を持っているだけなので
// これ自身をインスタンス化して使うことは無い

class Juice implements IJuice {
    // 値段
    public int price = -1;
    // ID
    public int juiceId = -1;
    // 味
    public String taste = "無";

    public String getDrinkName() {
        // 味を返す
        return taste;
    }

    public int getJuiceID() {
        // IDを返す
        return juiceId;
    }

    public int getPrice() {
        // 値段を返す
        return price;
    }
}
// コーヒージュースを表すクラス
class CoffeeJuice implements IJuice {
    // 値段は120円
    public int price = 120;
    // 飲み物の種類はコーヒー
    public String taste = "コーヒー";
    // IDはJUICE_COFFEE(IJuiceインターフェースに定義)
    public int juiceId = JUICE_COFFEE;
    
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
class ItemDTO {
    // 商品名を保存するメンバ変数(非公開)
    private String name;
    // 価格を保存するメンバ変数(非公開)
    private int price;
    
    public ItemDTO(String name, int price) {
        // 引数で受け取った商品名をメンバ変数に代入する
        this.name = name;
        // 引数で受け取った価格をメンバ変数に代入する
        this.price = price;
    }
    
    // 商品名を返すgetterメソッド
    public String getName() {
        return name;
    }
    
    // 価格を返すgetterメソッド
    public int getPrice() {
        return price;
    }
}
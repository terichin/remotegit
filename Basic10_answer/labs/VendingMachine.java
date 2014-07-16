// 自動販売機の機能を持つクラス
// お金が提供されるとジュースを提供することができる
class VendingMachine {
    // 投入金額を保存するメンバ変数
    private int amountMoney = 0;

    // お金を投入するメソッド
    public void insertCoin(int price) {
        // 投入金額を増やす
        amountMoney += price;
    }

    // 投入金額を取得するメソッド
    public int getAmountMoney() {
        // 投入金額を返す
        return amountMoney;
    }

    // 指定のIDをジュースインスタンスを取得するメソッド
    public IJuice pushJuiceButton(int juiceId) throws NoMoneyException {
        // ジュースインスタンスを生成して返す
        IJuice selJuice;
        if (juiceId == IJuice.JUICE_COFFEE) {
            // コーヒー
            selJuice = new CoffeeJuice();
        } else if (juiceId == IJuice.JUICE_TEA) {
            // 紅茶
            selJuice = new TeaJuice();
        } else if (juiceId == IJuice.JUICE_ORANGE) {
            // オレンジ
            selJuice = new OrangeJuice();
        } else {
            selJuice = null;
        }
        // ジュースが投入金額で購入可能かどうか調べる
        if (selJuice.getPrice() <= amountMoney) {
            // 購入可能なので、投入金額を減らしてジュースインスタンスを返す
            amountMoney -= selJuice.getPrice();
            return selJuice;
        } else {
            // 残額不足なので例外を発生
            throw new NoMoneyException();
        }
    }

    // おつりを返すメソッド
    public int returnChange() {
        // 返すべき値(現在の投入金額)を保存
        int change = amountMoney;
        // 投入金額を0にする
        amountMoney = 0;
        // おつりの額を返す
        return change;
    }
}
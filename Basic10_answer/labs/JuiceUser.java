// 自動販売機を利用するユーザ
class JuiceUser {
    // 所持金を保存するメンバ変数
    private int money;
    
    // コンストラクタ
    public JuiceUser(int money) {
        // 所持金を初期化
        this.money = money;
    }
    
    // 所持金を払うメソッド
    public int pay() {
        // 支払う金額を表示
        System.out.println("お金を" + money + "円払います");
        // 現在の所持金の値を返し、所持金を0にする
        int pay = money;
        money = 0;
        return pay;
    }
    
    // おつりを受け取るメソッド
    public void receiveMoney(int money) {
        // 受け取ったおつりの額を表示
        System.out.println("おつりを" + money + "円受け取りました");
        // 受け取ったおつりを所持金に加算
        this.money += money; 
    }
    
    // ジュースを自動販売機から受け取るメソッド
    public void receiveJuice(IJuice juice) {
        // 飲み物の種類を表示する。
        System.out.println(juice.getDrinkName() + "が出ました");
    }
}
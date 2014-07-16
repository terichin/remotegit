// 紅茶ジュースを表すクラス
class TeaJuice extends Juice {
    // コンストラクタで各メンバ変数の初期値を設定
    public TeaJuice() {
        // 値段は130円
        price = 130;
        // IDはJUICE_TEA
        juiceId = JUICE_TEA;
        // 飲み物の種類は紅茶
        taste = "紅茶";
    }
}
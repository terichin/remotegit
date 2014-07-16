// ジュースを表すインターフェース
interface IJuice {
    // コーヒーを示すID値
    int JUICE_COFFEE = 1;
    // 紅茶を示すID値
    int JUICE_TEA = 2;
    // オレンジジュースを示すID値
    int JUICE_ORANGE = 3;
    
    // ジュースの値段の値を返すメソッド
    int getPrice();
    // ジュースの味の値を返すメソッド
    String getDrinkName();
    // ジュースのIDの値を返すメソッド
    int getJuiceID();
}
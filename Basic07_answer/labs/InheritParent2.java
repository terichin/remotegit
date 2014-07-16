// 基礎問題7-4 スーパークラス
class InheritParent2 {
    // double型のメンバ変数を定義します
    double number = 0;
    
    void calcTax() {
        // 税込みの値を計算し、メンバ変数numberにセットします
        number = number + number * 0.05;
    }
}
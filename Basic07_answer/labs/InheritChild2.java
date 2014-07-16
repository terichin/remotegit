// 基礎問題7-4 サブクラス
class InheritChild2 extends InheritParent2 {
    void printResult() {
        // スーパークラスのメソッドで税込みの値を計算します
        calcTax();
        int printValue = (int)number;
        // 計算した税込みの値を表示します
        System.out.println("税込みの値は" + printValue + "円です");
    }
}
class InheritChild3 extends InheritParent3 {
    // 世界標準時を取得するメソッド
    String getWorldTime() {
        int whour = hour - 9;
        // 時刻がマイナスの時は補正する
        if (whour < 0) {
            whour += 24;
        }
        return whour + ":" + minute + ":" + second;
    }
}
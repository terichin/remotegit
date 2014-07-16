class ObjectApp1 {
    // mainメソッドは、public static voidと宣言し定義する。
    public static void main(String[] args) {
        // Bookの配列を作成する。
        Book[] books = new Book[5];
        
        // 各本のインスタンスを作成して配列変数に代入する。
        books[0] = new Book(1001, "羅生門", "芥川龍之介");
        books[1] = new Book(1002, "坊ちゃん", "夏目漱石");
        books[2] = new Book("三四郎", "夏目漱石");
        books[3] = new Book(1004, "浮雲", "二葉亭四迷");
        books[4] = new Book("舞姫", "森鴎外");
        
        // 本配列の要素の長さだけ for を繰り返す。
        for (int i=0; i < books.length ; i++) {
            // 本のintroduce()メソッドを実行する。
            books[i].inform();
        }
    }
}
class StringUser1 {
    public static void main(String[] args) {
        // 同じ値を持ったStringオブジェクトを2つ生成する
        String str1 = new String("こんにちは");
        String str2 = new String("こんにちは");
        
        // 変数str1の文字列の長さを取得して表示する
        System.out.println("str1の文字列の長さは" + str1.length() + "です");
        
        // 変数str1と変数str2を==で比較する
        // ==は同じインスタンスを指しているかを調べる
        if (str1 == str2) {
            System.out.println("str1とstr2は同じオブジェクトです");
        } else {
            System.out.println("str1とstr2は違うオブジェクトです");
        }
        
        // 変数str1と変数str2をequals()メソッドで比較する
        // equals()メソッドは同じ値を持っているかを調べる
        if (str1.equals(str2)) {
            System.out.println("str1とstr2は同じ値です");
        } else {
            System.out.println("str1とstr2は違う値です");
        }
    }
}
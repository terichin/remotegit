import java.util.HashMap;

class Information {
    public static void main(String[] args) {
        // 必要な情報を作成する。
        MemberDTO member1 = new MemberDTO("データ一郎", 24);
        MemberDTO member2 = new MemberDTO("ユニバ花子", 23);
        BookDTO book = new BookDTO("Javaプログラミング基礎", 3000);

        // Hashmapを作成する。
        HashMap map = new HashMap();

        // 情報を登録する。
        map.put("id1", member1);
        map.put("id2", member2);
        map.put("bk1", book);
        map.put("ken1", "Javaプログラミング基礎");
        

        // 各種情報を表示する。
        print(map);
    }

    public static void print(HashMap map) {
        // Hashmapから情報を取得する。
        MemberDTO mdto1 = (MemberDTO) map.get("id1");
        MemberDTO mdto2 = (MemberDTO) map.get("id2");
        BookDTO bdto1 = (BookDTO) map.get("bk1");
        String ken1 = (String) map.get("ken1");

        // 表示する。
        System.out.println("id1の名前は、" + mdto1.getName() + "です。");
        System.out.println("id1の年齢は、" + mdto1.getAge() + "です。");
        System.out.println("id1は、" + bdto1.getBookName() 
                                    + "を購入しました。価格は、"
                                    + bdto1.getPrice()
                                    + "円です。");
    	System.out.println("id1は、" + ken1 + "を受講しました。");
        System.out.println("id2の名前は、" + mdto2.getName() + "です。");
        System.out.println("id2の年齢は、" + mdto2.getAge() + "です。");

    }
}
// オプション問題7-2
class InheritAdvance2 {
    public static void main(String[] args) {
        // 商品情報初期化
        Item[] itemArray = InheritAdvance1.init();
        
        if (args.length == 1) {
            // 値段のみで検索を実行
            int price = Integer.parseInt(args[0]);
            search(itemArray, price);
        } else if (args.length == 2) {
            // 値段と種類で検索を実行
            int price = Integer.parseInt(args[0]);
            int kind = Integer.parseInt(args[1]);
            search(itemArray, price, kind);
        } else {
            System.out.println("使用法: InheritAdvance2 値段 [種類]");
        }
        
    }
    
    static void search(Item[] itemArray, int price) {
        // 値段で検索を実行する
        System.out.println(price + "円以下の商品リスト");
        for (int i = 0; i < itemArray.length; ++i) {
            // 指定の金額以下の商品の名前を表示
            if (itemArray[i].price <= price) {
                System.out.println(itemArray[i].name);
            }
        }
    }
    
    static void search(Item[] itemArray, int price, int kind) {
        // 値段と種類で検索を実行する
        if (kind == 1) {
            // 指定の金額以下の本の名前を表示
            System.out.println(price + "円以下の本リスト");
            for (int i = 0; i < itemArray.length; ++i) {
                if ((itemArray[i].price <= price) && 
                         (itemArray[i] instanceof ItemBook)){
                    System.out.println(itemArray[i].name);
                }
            }
        } else if (kind == 2) {
            // 指定の金額以下のDVDの名前を表示
            System.out.println(price + "円以下のDVDリスト");
            for (int i = 0; i < itemArray.length; ++i) {
                if ((itemArray[i].price <= price) && 
                         (itemArray[i] instanceof ItemDVD)){
                    System.out.println(itemArray[i].name);
                }
            }
        } else {
            // 種類不正
            System.out.println("商品の種類は1か2で入力してください");
        }
    }
}
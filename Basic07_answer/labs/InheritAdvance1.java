// オプション問題7-1
class InheritAdvance1 {
    public static void main(String[] args) {
        // 商品情報初期化
        Item[] itemArray = init();
        
        // 合計値の取得と表示
        System.out.println("商品の合計金額は" + getTotal(itemArray) + "円です");
        
        // 本の合計値の取得と表示
        System.out.println("本の合計金額は" + getBookTotal(itemArray) + "円です");
        
        // DVDの合計値の取得と表示
        System.out.println("DVDの合計金額は" + getDVDTotal(itemArray) + "円です");        
    }
    
    static Item[] init() {
        // Itemの配列作成
        Item[] itemArray = new Item[5];
        
        // 商品1情報設定
        ItemBook book1 = new ItemBook();
        book1.name = "Javaプログラミング基礎";
        book1.price = 5000;
        book1.author = "NTTデータユニバーシティ";
        book1.isbn = "XXXX-YYYYYY-ZZZZ";
        itemArray[0] = book1;
        
        // 商品2情報設定
        ItemDVD dvd1 = new ItemDVD();
        dvd1.name = "プロジェクトJ";
        dvd1.price = 12000;
        dvd1.time = 120;
        itemArray[1] = dvd1;
        
        // 商品3情報設定
        ItemBook book2 = new ItemBook();
        book2.name = "Javaプログラミング応用";
        book2.price = 3500;
        book2.author = "NTTデータユニバーシティ";
        book2.isbn = "XXXX-YYYYYY-AAAA";
        itemArray[2] = book2;
        
        // 商品4情報設定
        ItemBook book3 = new ItemBook();
        book3.name = "業務手順基礎";
        book3.price = 7000;
        book3.author = "NTTデータ";
        book3.isbn = "XXXX-ZZZZZZ-AAAA";
        itemArray[3] = book3;
        
        // 商品5情報設定
        ItemDVD dvd2 = new ItemDVD();
        dvd2.name = "ネバーエンディング・プロジェクト";
        dvd2.price = 25000;
        dvd2.time = 250;
        itemArray[4] = dvd2;
        
        // 作成した商品情報配列を返す
        return itemArray;
    }
    
    static int getTotal(Item[] itemArray) {
        // 扱う全商品の合計金額を計算して返す
        int total = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            total += itemArray[i].price;
        }
        
        // 合計値
        return total;
    }
    
    static int getBookTotal(Item[] itemArray) {
        // 扱う本の合計金額を計算して返す
        int bookTotal = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            // 本かどうかを調べ、本であれば合計値に加算します
            if (itemArray[i] instanceof ItemBook) {
                bookTotal += itemArray[i].price;
            }
        }
        
        // 本の合計値
        return bookTotal;
    }
    
    static int getDVDTotal(Item[] itemArray) {
        // 扱うDVDの合計金額を計算して返す
        int dvdTotal = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            // DVDかどうかを調べ、DVDであれば合計値に加算します
            if (itemArray[i] instanceof ItemDVD) {
                dvdTotal += itemArray[i].price;
            }
        }
        
        // DVDの合計値
        return dvdTotal;
    }
}
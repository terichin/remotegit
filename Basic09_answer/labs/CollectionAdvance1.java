import java.util.*;

class CollectionAdvance1 {
    public static ArrayList<ItemDTO> init() {
        // 指定の情報を持った5つのItemDTOオブジェクトを生成する
        ItemDTO dto1 = new ItemDTO("Javaプログラミング基礎", 5000);
        ItemDTO dto2 = new ItemDTO("プロジェクトJ", 12000);
        ItemDTO dto3 = new ItemDTO("Javaプログラミング応用", 7000);
        ItemDTO dto4 = new ItemDTO("業務手順基礎", 3500);
        ItemDTO dto5 = new ItemDTO("ネバーエンディング・プロジェクト", 25000);
        
        // 生成した複数のItemDTOオブジェクトを1つのArrayListに保存する
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
        list.add(dto5);
        
        // 生成したArrayListを返す
        return list;
    }
    
    // ArrayListに保存された商品の価格の合計値を求める
    public static int getTotal(ArrayList<ItemDTO> list) {
        // 合計値を保存する変数totalを定義する
        int total = 0;
        // ArrayListのオブジェクト数分のループ
        for (int i = 0; i < list.size(); i++) {
            // 順番にItemDTOオブジェクトを取り出す
            ItemDTO dto = list.get(i);
            // 価格情報を取り出し、変数totalに加える
            total += dto.getPrice();
        }
        // 求めた合計値を返す
        return total;
    }
    
    public static void main(String[] args) {
        // 商品情報を保存したArrayListを生成し、変数listに保存する
        ArrayList<ItemDTO> list = init();
        // 合計値を求めるgetTotalメソッドを呼び出し、結果を表示する
        System.out.println("商品の合計金額は" + getTotal(list) + "円です");
    }
}
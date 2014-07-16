import java.util.*;

class ListUser2 {
    public static void main(String[] args) {
        // 指定の情報を持ったItemDTOオブジェクトを5つ生成する
        ItemDTO dto1 = new ItemDTO("Javaプログラミング基礎", 5000);
        ItemDTO dto2 = new ItemDTO("プロジェクトJ", 12000);
        ItemDTO dto3 = new ItemDTO("Javaプログラミング応用", 7000);
        ItemDTO dto4 = new ItemDTO("業務手順基礎", 3500);
        ItemDTO dto5 = new ItemDTO("ネバーエンディング・プロジェクト", 25000);
        // 生成したItemDTOオブジェクトを1つのArrayListに保存する
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
        list.add(dto5);
        // 3番目ItemDTOオブジェクトの一つを削除する
        // ArrayListは0から番号が始まるので、dto4が示すオブジェクトが削除される
        list.remove(3);
        // ArrayListに保存された全ItemDTOオブジェクトの情報を表示する
        print(list);
    }
    
    public static void print(ArrayList<ItemDTO> list) {
        // 引数で渡されたArrayListに保存されている
        // オブジェクト数分のループを作成
        for (int i = 0; i < list.size(); i++) {
            // 順番にオブジェクトを取り出す
            ItemDTO obj = list.get(i);
            // DTOオブジェクトから情報を取得する
            String name = obj.getName();
            int price = obj.getPrice();
            // DTOオブジェクトから取り出した情報を表示する
            System.out.println(name);
            System.out.println(price);
        }
    }
}
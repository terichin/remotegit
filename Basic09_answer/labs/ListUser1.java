// ArrayListを使用する時は必ずimport行を記述してください
import java.util.*;

class ListUser1 {
    public static void main(String[] args) {
        // 指定の値を持ったItemDTOオブジェクトを2つ生成する
        ItemDTO dto1 = new ItemDTO("Javaプログラミング基礎", 5000);
        ItemDTO dto2 = new ItemDTO("プロジェクトJ", 12000);
        // 複数のItemDTOオブジェクトを保存するためのArrayListを生成する
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        // 生成したArrayListに2つのItemDTOオブジェクトを保存する
        list.add(dto1);
        list.add(dto2);
        // ArrayListに保存されたオブジェクトの情報を表示する
        // print()メソッドの呼び出し
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
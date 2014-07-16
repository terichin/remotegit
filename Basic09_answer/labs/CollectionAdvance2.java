import java.util.*;

class CollectionAdvance2 {
    public static ArrayList<ItemDTO> search(ArrayList<ItemDTO> list, String target) {
        // 引数listに格納された商品一覧のうち、
        // 引数targetにある検索語と商品の名前の先頭部分が一致する
        // ItemDTOの一覧を返す
        ArrayList<ItemDTO> glist = new ArrayList<ItemDTO>();
        // ArrayListのオブジェクト数分のループ
        for (int i = 0; i < list.size(); i++) {
            // 順番にItemDTOオブジェクトを取り出す
            ItemDTO dto = list.get(i);
            // 取得したItemDTOオブジェクトから商品名を取得する
            String name = dto.getName();
            // DTOから取得した値と、引数で渡された商品名を前方一致検索する
            if (startsmatch(name, target)) {
                // 該当する商品のItemDTOオブジェクトを配列に格納する
                glist.add(dto);
            }
        }
        // 検索にヒットした商品を格納した配列を返す
        // 一致する商品が無かった場合は要素数０のArrayListオブジェクトを返す
        return glist;
    }

    public static void main(String[] args) {
        // 商品情報を保存したArrayListを生成し、変数listに保存する
        ArrayList<ItemDTO> list = CollectionAdvance1.init();
        // 商品リストと商品名を引数としてsearchメソッドを呼び出す
        ArrayList<ItemDTO> glist = search(list, args[0]);
        if (glist.size() == 0) {
            // glistのサイズが０の場合は商品が見つからなかったのでエラーを表示する
            System.out.println(args[0] + "ではじまる名前の商品はありません");
        } else {
            for (int i = 0; i < glist.size(); i++) {
                // 順番にItemDTOオブジェクトを取り出す
                ItemDTO dto = glist.get(i);
                // 指定の商品の価格を表示する
                System.out.println(dto.getName() + "の価格は" 
                                          + dto.getPrice() + "円です");
            }
        }
    }

    public static boolean startsmatch(String seq, String target) {
        // 引数targetに格納されている文字列が、
        // 引数seqの先頭部分と一致する場合はtrueを、
        // 一致しない場合はfalseを返す
        // 検索キーに指定されている文字数分のループを回す

        // 引数targetの文字数が引数seqの文字数より多い場合は、
        // 前方一致検索対象外なのでfalseを返す
        if (target.length() > seq.length()) {
            return false;
        }
        for (int i = 0; i < target.length(); i++) {
            // 検索対象のi番目の文字を格納する
            char seqchr = seq.charAt(i);
            // 検索キーのi番目の文字を格納する
            char tgtchr = target.charAt(i);
            // 一致しない文字があった場合は
            // 前方一致検索にヒットしないためfalseを返す
            if (seqchr != tgtchr) {
                return false;
            }
        }
        // 上記ループですべての文字が一致していた場合、
        // 前方一致検索にヒットするためtrueを返す
        return true;
    }
}
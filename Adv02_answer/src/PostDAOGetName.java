import dao.PostDAO;

// PostDAOクラスを使用し、postテーブルのデータの
// 参照を実行するプログラム
public class PostDAOGetName {
    // PostDAOクラスのgetName()メソッドを呼び出して実行するmain()メソッド
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);

            PostDAO dao = new PostDAO();
            String result = dao.getName(id);
            if (result == null) {
                System.out.println("指定されたIDが見つかりません。");
            } else {
                System.out.println("ID" + id + "の部署名は" + result + "です。");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("与えられたデータ項目の数が足りません。");
        } catch (NumberFormatException e) {
            System.out.println("IDは数値でなければなりません。");
        }
    }
}
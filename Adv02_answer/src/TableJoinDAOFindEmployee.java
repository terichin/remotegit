import dao.*;

// TableJoinDAOクラスを使用し、様々なテーブルのデータの
// 参照を実行するプログラム
public class TableJoinDAOFindEmployee {
    // TableJoinDAOクラスのfindEmployee()メソッドを呼び出して実行するmain()メソッド
    public static void main(String[] args) {
        try {
            TableJoinDAO dao = new TableJoinDAO();
            int id = Integer.parseInt(args[0]);

            String[] empInfo = dao.findEmployee(id);
            if (empInfo != null) {
                System.out.println("従業員ID" + id + "の情報を以下に表示します");
                System.out.println("従業員名: " + empInfo[0]);
                System.out.println("内線番号: " + empInfo[1]);
                System.out.println("携帯番号: " + empInfo[2]);
                System.out.println("所属部署名: " + empInfo[3]);
                System.out.println("上司名称: " + empInfo[4]);
            } else {
                System.out.println("ID" + id + "の情報はありません。");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("与えられたデータ項目の数が足りません。");
        } catch (NumberFormatException e) {
            System.out.println("IDは数値でなければなりません。");
        } catch (DAOException e) {
            System.out.println("DBアクセスでエラーが発生しました。");
        }
    }
}
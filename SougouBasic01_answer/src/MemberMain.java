/*
 * アプリケーションの動作を制御するクラス。
 */
public class MemberMain {

    //社員情報の項目名
    public static final String[] COLUMN_NAME = {
        "",
        "社員コード",
        "社員名",
        "部署",
        "資格",
        "特技",
        "趣味",
        "出身"
    };

    public static void main(String[] args) {
        while (true) {
            System.out.println("モードを選択してください");
            System.out.println();
            System.out.println("1 社員情報登録");
            System.out.println("2 社員情報検索");
            System.out.println("3 終了");
            System.out.println();

            //標準入力からモード番号をコンソールから取得する
            String number = InputUtility.inputNumber(1, 3);

            System.out.println();

            //入力されたモード番号に応じて処理を分岐する
            if (number.equals("1")) {
                Page10 page = new Page10();
                page.execute();
            } else if (number.equals("2")) {
                Page3 page = new Page3();
                page.execute();
            } else if (number.equals("3")) {
                System.exit(0);
            }
            System.out.println();
        }
    }

    public static String columnNameFormat(String str) {
        //引数の文字列数と５文字の差を取得
        int count = 5 - str.length();

        //５文字になるまで引数に空白文字を追加
        for (int i = 0; i < count; i++) {
            str += "　";
        }

        //５文字にフォーマットされた文字列を返す
        return str;
    }
}
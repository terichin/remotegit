/*
 * 社員情報の検索結果を表示するクラス
 */
public class Page5 {

    public void execute(String[] array) {

        //検索結果がある場合は内容を表示する
        if (array != null) {
            System.out.println("検索結果は以下の１件です。");
            System.out.println();
            for (int i = 0; i < 7; i++) {
                System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[i + 1]) + "：" + array[i]);
            }
        } else {
            System.out.println("該当データがありませんでした。");
        }
        System.out.println();
        System.out.println("次のアクションを選択してください。");
        System.out.println("1 モード選択に戻る");
        System.out.println("2 検索キー選択に戻る");
        System.out.println();

        //遷移先を決定する番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);

        if (number.equals("2")) {
            Page3 page = new Page3();
            page.execute();
        }
    }
}
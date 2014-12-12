/*
 * 社員情報の検索処理の検索キーを取得するクラス
 */
public class Page3 {

    public void execute() {
        System.out.println("社員検索を行います。");
        System.out.println("社員の検索キーを選択してください。");
        System.out.println();

        //社員情報の各項目を表示する
        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " " + MemberMain.COLUMN_NAME[i]);
        }
        System.out.println();

        //検索キーの番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 7);
        System.out.println();

        //検索キーの番号をPage4クラスのexecute()メソッドへ引き渡す
        Page4 page = new Page4();
        page.execute(Integer.parseInt(number));
    }
}
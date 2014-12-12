import java.util.ArrayList;
/*
 * 社員情報の検索結果を表示するクラス
 */
public class Page5 {

    public void execute(ArrayList<MemberBean> list) {

        //検索結果がある場合は内容を表示する
        if (list.size() != 0) {
            System.out.println("検索結果は以下の" + list.size() + "件です。");
            System.out.println();
            for (MemberBean bean : list) {
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[1]) + "：" + bean.getNo());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[2]) + "：" + bean.getName());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[3]) + "：" + bean.getBusho());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[4]) + "：" + bean.getShikaku());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[5]) + "：" + bean.getTokugi());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[6]) + "：" + bean.getHobby());
                System.out.println(MemberMain.columnNameFormat(
                        MemberMain.COLUMN_NAME[7]) + "：" + bean.getHometown());
                System.out.println();
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
/*
 * 社員情報の登録処理を行うクラス。
 */
public class Page11 {

    public void execute(String[] array) {
        //引き渡された社員情報を表示する
        System.out.println("入力内容をご確認ください。");
        for (int i = 0; i < 7; i++) {
            System.out.println(MemberMain.columnNameFormat(
                MemberMain.COLUMN_NAME[i + 1]) + "：" + array[i]);
        }
        System.out.println();

        //登録処理実行の確認を行う
        System.out.println("当該データを登録してもよろしいでしょうか？");
        System.out.println("1 はい");
        System.out.println("2 いいえ");

        String number = InputUtility.inputNumber(1, 2);

        //登録処理を行うことが確認された場合のみ、登録を実行する
        if (number.equals("1")) {
            CsvDao.insert(array);
        }
    }
}
/*
 * 社員情報の登録処理を行うクラス。
 */
public class Page11 {
    // 登録する社員情報をMemberBeanとして受け取る
    public void execute(MemberBean bean) {
        //引き渡された社員情報を表示する
        System.out.println("入力内容をご確認ください。");
        System.out.println();
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

        //登録処理実行の確認を行う
        System.out.println("当該データを登録してもよろしいでしょうか？");
        System.out.println("1 はい");
        System.out.println("2 いいえ");

        String number = InputUtility.inputNumber(1, 2);

        //登録処理を行うことが確認された場合のみ、MemberBeanを使用して登録を実行する
        if (number.equals("1")) {
            CsvDao.insert(bean);
        }
    }
}
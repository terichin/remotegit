/*
 * 社員情報の登録準備をおこない登録処理を行うクラスへ
 * 引き渡すクラス。
 */
public class Page10 {

    public void execute() {
        System.out.println("社員情報登録を行います。");
        System.out.println("社員の登録内容を入力してください");
        System.out.println(MemberMain.COLUMN_NAME[1] + "：");
        String shainNo;

        do {
            //社員番号をコンソールから取得する
            shainNo = InputUtility.inputNumber(1, 9999999);

            // ゼロサプレス(７桁以下のときに、先頭を0で埋める）処理
            int length = shainNo.length();
            if (length < 7) {
                for (int i = 0; i < 7 - length; i++) {
                    shainNo = "0" + shainNo;
                }
            }

            //社員番号がすでに存在していないか重複チェックを行う
            if (CsvDao.isDuplicateKey(shainNo)) {
                System.out.println("社員番号が重複しています。再度入力してください。");
            } else {
                break;
            }
        } while (true);

        //社員名を10文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[2] + "：");
        String shainName = InputUtility.inputString(10);

        //部署名を12文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[3] + "：");
        String bushoName = InputUtility.inputString(12);

        //資格を16文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[4] + "：");
        String shikaku = InputUtility.inputString(16, false);

        //特技を10文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[5] + "：");
        String tokugi = InputUtility.inputString(10, false);

        //趣味を14文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[6] + "：");
        String hobby = InputUtility.inputString(14, false);

        //出身を10文字以内でコンソールから取得する
        System.out.println(MemberMain.COLUMN_NAME[7] + "：");
        String hometown = InputUtility.inputString(10);

        //入力された各項目データを配列にまとめ、
        //その配列要素を持つMemberBeanを作成する
        String[] array = {shainNo, shainName, bushoName, shikaku, tokugi, hobby, hometown};
        MemberBean bean = new MemberBean(array);

        //上記で作成したMemberBeanをPage11クラスのexecute()メソッドに
        //引き渡し、登録処理をおこなう
        Page11 page = new Page11();
        page.execute(bean);
    }
}
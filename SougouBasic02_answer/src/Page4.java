/*
 * 社員情報の検索処理の検索キーワードを取得し、検索を行うクラス
 */
public class Page4 {

    public void execute(int key) {

        System.out.println(MemberMain.COLUMN_NAME[key] + "で社員検索を行います。");
        System.out.println("検索キーワードを入力してください。");
        System.out.println();

        //検索キーワードをコンソールから取得する
        String query = InputUtility.inputString();

        //検索キーとそれに対する検索キーワードで検索し、
        //一致する社員情報をMemberBeanとして取得する
        MemberBean bean = CsvDao.search(key, query);

        //検索結果であるMemberBeanをPage5クラスのexecute()メソッドへ
        Page5 page = new Page5();
        page.execute(bean);
    }
}
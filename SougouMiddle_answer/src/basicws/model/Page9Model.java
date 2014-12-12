package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * 変更対象の社員情報を取得し、変更処理の実行を制御するクラス
 */
public class Page9Model implements Model {

    public int execute(String parameter, HashMap session) {
        //引数parameterで渡された変更確認番号が"1"の場合のみ変更する
        if (parameter.equals("1")) {
            //"update"という名前で格納された社員情報1件をsessionから取得する
            MemberBean bean = (MemberBean) session.get("update");
            CsvDao.update(bean);
        }
        return 2;
    }
}
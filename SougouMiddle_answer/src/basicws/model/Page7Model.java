package basicws.model;

import java.util.ArrayList;
import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * 削除する社員情報を取得し、削除処理の実行を制御するクラス
 */
public class Page7Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"search"という名前で格納された社員情報1件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("search");

        if (bean == null) {
            return 4;
        } else {
            //引数parameterで渡された削除確認番号が"1"の場合のみ削除する
            if (parameter.equals("1")) {
                CsvDao.delete(bean);
            }
            return 2;
        }
    }
}
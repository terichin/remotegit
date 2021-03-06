package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * 登録する社員情報を取得し、登録処理の実行を制御するクラス
 */
public class Page11Model implements Model {

    public int execute(String parameter, HashMap session) {
        //引数parameterで渡された登録確認番号が"1"の場合のみ登録する
        if (parameter.equals("1")) {
            MemberBean bean = (MemberBean) session.get("insert");
            CsvDao.insert(bean);
        }
        return 2;
    }
}
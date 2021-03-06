package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * 変更する社員情報を取得し、変更属性番号をsessionに格納するクラス
 */
public class Page6Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"search"という名前で格納された社員情報1件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("search");

        if (bean == null) {
            return 4;
        } else {
            //引数parameterで渡された変更属性番号を"key"という名前で
            //sessionに格納する
            session.put("key", parameter);
            return 8;
        }
    }
}
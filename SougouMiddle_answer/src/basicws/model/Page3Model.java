package basicws.model;

import java.util.HashMap;
/*
 * 検索キー番号をsessionに格納するクラス
 */
public class Page3Model implements Model {

    public int execute(String parameter, HashMap session) {
        //引数parameterで渡された検索キー番号を"key"という名前でsessionに格納する
        session.put("key", parameter);
        return 4;
    }
}
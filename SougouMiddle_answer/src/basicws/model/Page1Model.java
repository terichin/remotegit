package basicws.model;

import java.util.HashMap;
/*
 * アクター番号に応じて処理を分岐するクラス
 */
public class Page1Model implements Model {

    public int execute(String parameter, HashMap session) {
        //アクター番号（1:社員,2:人事担当者）による分岐
        if (parameter.equals("1")) {
            //アクター番号が1（社員）の場合
            //アクター番号を"actor"という名前でsessionに格納する
            session.put("actor", "1");
            //モード番号4(検索)を"mode"という名前でsessionに格納する
            session.put("mode", "4");
            return 3;

        } else {
            //アクター番号が2（人事担当者）の場合
            //アクター番号を"actor"という名前でsessionに格納する
            session.put("actor", "2");
            return 2;
        }
    }
}
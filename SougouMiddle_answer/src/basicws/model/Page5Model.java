package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * 画面遷移(検索キー選択画面/モード選択画面/終了)を制御するクラス
 */
public class Page5Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"actor"という名前で格納されたアクター情報をsessionから取得する
        String actor = (String) session.get("actor");
        if (actor.equals("1")) {
            //アクター番号が1(社員)の場合は、検索キー選択画面か終了
            if (parameter.equals("1")) {
                return 3;
            } else {
                System.exit(0);
            }
        } else {
            //アクター番号が2(人事担当者)の場合は、モード選択画面か検索キー選択画面
            if (parameter.equals("1")) {
                return 2;
            } else {
                return 3;
            }
        }
        return -1;
    }
}
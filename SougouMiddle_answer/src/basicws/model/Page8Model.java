package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
/*
 * 変更対象の社員情報を取得し、情報の書き換えを行うクラス
 */
public class Page8Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"key"という名前で格納された変更属性番号をsessionから取得する
        int key = Integer.parseInt((String) session.get("key"));
        //"search"という名前で格納された社員情報1件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("search");

        // 変更前データの取得と変更後データの上書きを続けて実行
        String before = null;
        switch (key) {
            case 2:
                before = bean.getName();
                bean.setName(parameter);
                break;
            case 3:
                before = bean.getBusho();
                bean.setBusho(parameter);
                break;
            case 4:
                before = bean.getShikaku();
                bean.setShikaku(parameter);
                break;
            case 5:
                before = bean.getTokugi();
                bean.setTokugi(parameter);
                break;
            case 6:
                before = bean.getHobby();
                bean.setHobby(parameter);
                break;
            case 7:
                before = bean.getHometown();
                bean.setHometown(parameter);
                break;
        }

        //変更前の変更属性を"before"という名前でsessionに格納する
        session.put("before", before);
        //変更後の変更属性を"after"という名前でsessionに格納する
        session.put("after", parameter);
        //変更後の社員情報を"update"という名前でsessionに格納する
        session.put("update", bean);

        return 9;
    }
}
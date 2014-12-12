package basicws.model;

import java.util.HashMap;
/*
 * モード番号に応じて処理を分岐するクラス
 */
public class Page2Model implements Model {

    public int execute(String parameter, HashMap session) {
        if (parameter.equals("1")) {
            return 10;
        } else if (parameter.equals("2")) {
            //モード番号"2"(変更)を"mode"という名前でsessionに格納する
            session.put("mode", "2");
            //検索キー番号"1"(社員番号)を"key"という名前でsessionに格納する
            session.put("key", "1");
            return 4;
        } else if (parameter.equals("3")) {
            //モード番号"3"(削除)を"mode"という名前でsessionに格納する
            session.put("mode", "3");
            //検索キー番号"1"(社員番号)を"key"という名前でsessionに格納する
            session.put("key", "1");
            return 4;
        } else if (parameter.equals("4")) {
            //モード番号"4"(検索)を"mode"という名前でsessionに格納する
            session.put("mode", "4");
            return 3;
        } else if (parameter.equals("5")) {
            System.exit(0);
        }
        return -1;
    }
}
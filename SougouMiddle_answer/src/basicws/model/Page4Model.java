package basicws.model;

import java.util.ArrayList;
import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * モード番号によって処理を分岐するクラス
 */
public class Page4Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"key"という名前で格納された検索キーをsessionから取得する
        int key = Integer.parseInt((String) session.get("key"));
        //"mode"という名前で格納されたモード番号をsessionから取得する
        int mode = Integer.parseInt((String) session.get("mode"));

        if (mode == 2 || mode == 3) {
            //引数parameterで渡された検索キーワード(社員番号)で検索し、
            //社員情報を１件取得する
            MemberBean bean = CsvDao.searchById(parameter);
            //取得した社員情報を"search"という名前でsessionに格納する
            session.put("search", bean);

            if (mode == 2) {
                return 6;
            } else {
                return 7;
            }
        } else {
            //sessionから取得した検索キーと引数parameterで渡された
            //検索キーワードで検索し、社員情報を取得する
            ArrayList<MemberBean> list = CsvDao.search(key, parameter);
            //取得した社員情報リストを"search"という名前でsessionに格納する
            session.put("search", list);

            return 5;
        }
    }
}
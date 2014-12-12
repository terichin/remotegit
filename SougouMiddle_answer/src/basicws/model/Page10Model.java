package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
/*
 * 登録する社員情報を作成し、sessionに格納するクラス
 */
public class Page10Model implements Model {

    public int execute(String parameter, HashMap session) {

        //引数parameterで渡された登録用の社員情報をカンマで区切って
        //配列として取得する
        String[] record = parameter.split(",");

        // ゼロサプレス(7桁以下のときに、先頭を0で埋める）処理
        int length = record[0].length();
        if (length < 7) {
            for (int i = 0; i < 7 - length; i++) {
                record[0] = "0" + record[0];
            }
        }

        //取得した配列要素を保持するMemberBeanを作成する
        MemberBean bean = new MemberBean(record);

        //上記で作成した登録用のMemberBeanを"insert"という名前でsessionに格納する
        session.put("insert", bean);
        
        return 11;
    }
}
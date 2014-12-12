package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;
/*
 * 各Viewクラスの基底クラス
 * 各Viewクラスはこのクラスを継承して作成する
 */
public class View {
    private final static Logger logger = Logger.getLogger(View.class);

    //社員情報の項目名
    public static final String[] COLUMN_NAME = {
        "",
        "社員コード",
        "社員名",
        "部署",
        "資格",
        "特技",
        "趣味",
        "出身"
    };

    public String columnNameFormat(String str) {
        //引数の文字列数と５文字の差を取得
        int count = 5 - str.length();

        //5文字になるまで引数に空白文字を追加
        for (int i = 0; i < count; i++) {
            str += "　";
        }
        //5文字にフォーマットされた文字列を返す
        return str;
    }

    public String render(HashMap session) {
        System.out.println("Don't call this method. Please override it.");
        logger.error("Don't call this method. Please override it.");
        System.exit(0);
        return null;
    }
}
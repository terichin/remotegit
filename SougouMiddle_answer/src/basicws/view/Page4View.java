package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * 画面４を表示するクラス
 */
public class Page4View extends View {
    private final static Logger logger = Logger.getLogger(Page4View.class);

    public String render(HashMap session) {
        //"key"という名前で格納された検索キーをsessionから取得する
        int key = Integer.parseInt((String) session.get("key"));
        System.out.println(COLUMN_NAME[key] + "で社員検索を行います。");
        logger.info(COLUMN_NAME[key] + "で社員検索を行います。");
        System.out.println("検索キーワードを入力してください。");
        logger.info("検索キーワードを入力してください。");
        System.out.println();

        //検索キーワードをコンソールから取得する
        String query = InputUtility.inputString();
        System.out.println();

        return query;
    }
}
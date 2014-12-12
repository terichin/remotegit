package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * 画面８を表示するクラス
 */
public class Page8View extends View {
    private final static Logger logger = Logger.getLogger(Page8View.class);

    public String render(HashMap session) {
        System.out.println("変更後情報を入力してください。");
        logger.info("変更後情報を入力してください。");
        System.out.println();

        //"key"という名前で格納された変更属性番号をsessionから取得する
        int key = Integer.parseInt((String) session.get("key"));

        //社員番号以外の変更属性ごとに最大文字数をセットする
        int[] length = {-1, 10, 12, 16, 10, 14, 10};

        //sessionから取得した変更属性番号に応じて、上記でセットした
        //最大文字数で文字数チェックを行い、コンソールから
        //変更後情報を取得する
        String query = InputUtility.inputString(length[key - 1]);
        System.out.println();

        return query;
    }
}
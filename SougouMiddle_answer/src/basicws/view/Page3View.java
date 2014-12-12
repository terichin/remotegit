package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * 画面３を表示するクラス
 */
public class Page3View extends View {
    private final static Logger logger = Logger.getLogger(Page3View.class);

    public String render(HashMap session) {

        System.out.println("社員検索を行います。");
        logger.info("社員検索を行います。");
        System.out.println("社員の検索キーを選択してください。");
        logger.info("社員の検索キーを選択してください。");
        System.out.println();

        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " " + COLUMN_NAME[i]);
            logger.info(i + " " + COLUMN_NAME[i]);
        }
        System.out.println();

        //検索キーの番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 7);
        System.out.println();

        return number;
    }
}
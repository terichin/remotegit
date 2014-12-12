package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * 画面２を表示するクラス
 */
public class Page2View extends View {
    private final static Logger logger = Logger.getLogger(Page2View.class);

    public String render(HashMap session) {
        System.out.println("モードを選択してください");
        logger.info("モードを選択してください");
        System.out.println();
        System.out.println("1 社員情報登録");
        logger.info("1 社員情報登録");
        System.out.println("2 社員情報変更");
        logger.info("2 社員情報変更");
        System.out.println("3 社員情報削除");
        logger.info("3 社員情報削除");
        System.out.println("4 社員情報検索");
        logger.info("4 社員情報検索");
        System.out.println("5 終了");
        logger.info("5 終了");
        System.out.println();

        //モード番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 5);
        System.out.println();

        return number;
    }
}
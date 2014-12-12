package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * 画面１を表示するクラス
 */
public class Page1View extends View {
    private final static Logger logger = Logger.getLogger(Page1View.class);

    public String render(HashMap session) {
        System.out.println("社員 or 人事部担当者を選択してください。");
        logger.info("社員 or 人事部担当者を選択してください。");
        System.out.println();
        System.out.println("1 社員");
        logger.info("1 社員");
        System.out.println("2 人事担当者");
        logger.info("2 人事担当者");

        //アクター番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);

        return number;
    }
}
package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * 画面11を表示するクラス
 */
public class Page11View extends View {
    private final static Logger logger = Logger.getLogger(Page11View.class);

    public String render(HashMap session) {
        //"insert"という名前で格納された社員情報１件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("insert");

        System.out.println("入力内容をご確認ください。");
        logger.info("入力内容をご確認ください。");
        System.out.println(columnNameFormat(
                COLUMN_NAME[1]) + "：" + bean.getNo());
        logger.info(columnNameFormat(
                COLUMN_NAME[1]) + "：" + bean.getNo());
        System.out.println(columnNameFormat(
                COLUMN_NAME[2]) + "：" + bean.getName());
        logger.info(columnNameFormat(
                COLUMN_NAME[2]) + "：" + bean.getName());
        System.out.println(columnNameFormat(
                COLUMN_NAME[3]) + "：" + bean.getBusho());
        logger.info(columnNameFormat(
                COLUMN_NAME[3]) + "：" + bean.getBusho());
        System.out.println(columnNameFormat(
                COLUMN_NAME[4]) + "：" + bean.getShikaku());
        logger.info(columnNameFormat(
                COLUMN_NAME[4]) + "：" + bean.getShikaku());
        System.out.println(columnNameFormat(
                COLUMN_NAME[5]) + "：" + bean.getTokugi());
        logger.info(columnNameFormat(
                COLUMN_NAME[5]) + "：" + bean.getTokugi());
        System.out.println(columnNameFormat(
                COLUMN_NAME[6]) + "：" + bean.getHobby());
        logger.info(columnNameFormat(
                COLUMN_NAME[6]) + "：" + bean.getHobby());
        System.out.println(columnNameFormat(
                COLUMN_NAME[7]) + "：" + bean.getHometown());
        logger.info(columnNameFormat(
                COLUMN_NAME[7]) + "：" + bean.getHometown());
        System.out.println();
        System.out.println("該当データを登録してもよろしいでしょうか？");
        logger.info("該当データを登録してもよろしいでしょうか？");
        System.out.println("1 はい");
        logger.info("1 はい");
        System.out.println("2 いいえ");
        logger.info("2 いいえ");

        //登録確認番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);
        return number;
    }
}
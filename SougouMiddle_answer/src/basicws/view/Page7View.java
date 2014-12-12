package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * 画面７を表示するクラス
 */
public class Page7View extends View {
    private final static Logger logger = Logger.getLogger(Page7View.class);

    public String render(HashMap session) {
        //"search"という名前で格納された社員情報1件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("search");

        if (bean != null) {
            System.out.println("検索結果は次の1件です。");
            logger.info("検索結果は次の1件です。");
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
        } else {
            System.out.println("該当データがありませんでした。");
            logger.error("該当データがありませんでした。");
            return null;
        }
        System.out.println("該当データを削除してもよろしいでしょうか？");
        logger.error("該当データを削除してもよろしいでしょうか？");
        System.out.println("1 はい");
        logger.error("1 はい");
        System.out.println("2 いいえ");
        logger.error("2 いいえ");

        //削除確認番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);
        return number;
    }
}
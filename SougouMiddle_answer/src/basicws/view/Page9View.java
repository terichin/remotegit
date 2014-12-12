package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * 画面９を表示するクラス
 */
public class Page9View extends View {
    private final static Logger logger = Logger.getLogger(Page9View.class);

    public String render(HashMap session) {

        // 変更データsessionからを取得する
        String before = (String) session.get("before");
        String after = (String) session.get("after");
        MemberBean bean = (MemberBean) session.get("update");

        System.out.println("変更前後、ならびに変更後データは以下の通りです。");
        logger.info("変更前後、ならびに変更後データは以下の通りです。");
        System.out.println();
        System.out.println("【変更前】");
        logger.info("変更前】");
        System.out.println(before);
        logger.info(before);
        System.out.println();
        System.out.println("【変更後】");
        logger.info("【変更後】");
        System.out.println(after);
        logger.info(after);
        System.out.println();
        System.out.println("【変更後データ】");
        logger.info("【変更後データ】");
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
        System.out.println("該当データを変更してもよろしいでしょうか？");
        logger.info("該当データを変更してもよろしいでしょうか？");
        System.out.println("1 はい");
        logger.info("1 はい");
        System.out.println("2 いいえ");
        logger.info("2 いいえ");

        //変更確認番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);
        System.out.println();

        return number;
    }
}
package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;

/*
 * 画面６を表示するクラス
 */
public class Page6View extends View {
    private final static Logger logger = Logger.getLogger(Page6View.class);

    public String render(HashMap session) {
        //"search"という名前で格納された社員情報１件をsessionから取得する
        MemberBean bean = (MemberBean) session.get("search");

        if (bean != null) {
            System.out.println("検索結果は以下の1件です。");
            logger.info("検索結果は以下の1件です。");
            System.out.println();
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
        } else {
            System.out.println("該当データがありませんでした。");
            logger.error("該当データがありませんでした。");
            return null;
        }
        System.out.println();
        System.out.println("変更する属性を選択してください。");
        logger.info("変更する属性を選択してください。");
        System.out.println();
        for (int i = 2; i <= 7; i++) {
            System.out.println(i + " " + COLUMN_NAME[i]);
            logger.info(i + " " + COLUMN_NAME[i]);
        }

        //変更する属性番号をコンソールから取得する
        String number = InputUtility.inputNumber(2, 7);
        System.out.println();

        return number;
    }
}
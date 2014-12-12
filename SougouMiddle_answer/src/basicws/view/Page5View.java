package basicws.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * 画面５を表示するクラス
 */
public class Page5View extends View {
    private final static Logger logger = Logger.getLogger(Page5View.class);

    public String render(HashMap session) {
        //"search"という名前で格納された社員情報リストをsessionから取得する
        ArrayList<MemberBean> list =
                (ArrayList<MemberBean>)session.get("search");

        if (list != null && list.size() != 0) {
            System.out.println("検索結果は以下です。");
            logger.info("検索結果は以下です。");
            System.out.println();
            for (MemberBean bean : list) {
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
            }
        } else {
            System.out.println("該当データがありませんでした。");
            logger.error("該当データがありませんでした。");
        }
        System.out.println();
        System.out.println("次のアクションを選択してください。");
        logger.info("次のアクションを選択してください。");

        //"actor"という名前で格納されたアクター情報をsessionから取得する
        String actor = (String) session.get("actor");
        if (actor.equals("1")) {
            //アクター番号が1(社員)の場合は、再検索か終了
            System.out.println("1 検索キー選択に戻る");
            logger.info("1 検索キー選択に戻る");
            System.out.println("2 終了");
            logger.info("2 終了");
            System.out.println();
        } else {
            //アクター番号が2(人事担当者)の場合は、モード選択か、再検索
            System.out.println("1 モード選択に戻る");
            logger.info("1 モード選択に戻る");
            System.out.println("2 検索キー選択に戻る");
            logger.info("2 検索キー選択に戻る");
            System.out.println();
        }
        //次のアクション番号をコンソールから取得する
        String number = InputUtility.inputNumber(1, 2);

        return number;
    }
}
package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.CsvDao;
import basicws.util.InputUtility;
/*
 * 画面10を表示するクラス
 */
public class Page10View extends View {

    private final static Logger logger = Logger.getLogger(Page10View.class);

    public String render(HashMap session) {
        System.out.println("社員情報登録を行います。");
        System.out.println("社員の登録内容を入力してください");
        logger.info("社員情報登録を行います。");
        logger.info("社員の登録内容を入力してください");

        System.out.println(COLUMN_NAME[1] + "：");
        logger.info(COLUMN_NAME[1] + "：");
        String no;
        do {
            //登録する社員番号をコンソールから取得する
            no = InputUtility.inputString(7, false);

            // ゼロサプレス(７桁以下のときに、先頭を0で埋める）処理
            int length = no.length();
            if (length < 7) {
                for (int i = 0; i < 7 - length; i++) {
                    no = "0" + no;
                }
            }

            try {
                Integer.parseInt(no);
            } catch (NumberFormatException e) {
                System.out.println("整数で入力してください。");
                logger.info(no);
                logger.error("整数で入力してください。");
                continue;
            }

            //社員番号がすでに存在していないか重複チェックを行う
            if (CsvDao.isDuplicateKey(no)) {
                System.out.println("社員番号が重複しています。"
                        + "再度入力してください。");
                logger.info(no);
                logger.error("社員番号が重複しています。"
                        + "再度入力してください。");
            } else {
                break;
            }
        } while (true);

        logger.info(no);

        //社員名を10文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[2] + "：");
        logger.info(COLUMN_NAME[2] + "：");
        String name = InputUtility.inputString(10);
        logger.info(name);

        //部署名を12文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[3] + "：");
        logger.info(COLUMN_NAME[3] + "：");
        String busho = InputUtility.inputString(12);
        logger.info( busho);

        //資格を16文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[4] + "：");
        logger.info(COLUMN_NAME[4] + "：");
        String shikaku = InputUtility.inputString(16, false);
        logger.info(shikaku);

        //特技を10文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[5] + "：");
        logger.info(COLUMN_NAME[5] + "：");
        String tokugi = InputUtility.inputString(10, false);
        logger.info(tokugi);

        //趣味を14文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[6] + "：");
        logger.info(COLUMN_NAME[6] + "：");
        String hobby = InputUtility.inputString(14, false);
        logger.info(hobby);

        //出身を10文字以内でコンソールから取得する
        System.out.println(COLUMN_NAME[7] + "：");
        logger.info(COLUMN_NAME[7] + "：");
        String hometown = InputUtility.inputString(10);
        logger.info(hometown);

        //上記で取得した各項目データをカンマで区切って１つの文字列にまとめる
        String result =
                no + ","
                + name + ","
                + busho + ","
                + shikaku + ","
                + tokugi + ","
                + hobby + ","
                + hometown;

        return result;
    }
}
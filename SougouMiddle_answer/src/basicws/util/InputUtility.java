package basicws.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
/*
 * 入力受付を行うクラス。
 */
public class InputUtility {
    private final static Logger logger = Logger.getLogger(InputUtility.class);

    public static String inputString() {
        return inputString(true);
    }

    public static String inputString(boolean required) {
        //標準入力から入力を受け付けるためのオブジェクトを取得する
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            while (true) {
                //標準入力から１行読み込む
                String input = br.readLine();

                //引数がfalseの場合、未入力に関係なく入力された値を返す。
                //引数がtrueの場合、未入力なら再入力を促し、何か入力されていれば
                //その値を返す
                if (required == false || input.length() > 0) {
                    logger.info(input);
                    return input;
                }
                System.out.println("入力は必須です。再度入力してください。");
                logger.error("入力は必須です。再度入力してください。");

            }
        } catch (IOException e) {
            System.out.println("コンソールからの入力に失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("コンソールからの入力に失敗しました。"+e.toString());
            logger.error("アプリケーションを終了します。");
            System.exit(0);
        }
        return null;

    }

    public static String inputString(int maxLength) {
        return inputString(maxLength, true);
    }

    public static String inputString(int maxLength, boolean required) {
        while (true) {
            //引数の値(true/false)で未入力チェックの有無を
            //判断し、入力を受け付ける
            String value = inputString(required);

            //入力された値の文字数をチェックし、範囲内であれば
            //その値を返す
            if (value.length() <= maxLength) {
                return value;
            }

            //範囲外であれば再入力を促す
            System.out.println(maxLength + "文字以内で入力してください。");
            logger.error(maxLength + "文字以内で入力してください。");
            System.out.println();
        }

    }

    public static String inputNumber() {
        while (true) {
            try {
                //未入力チェックをして入力された値を取得する
                String str = inputString();

                //入力された値が整数かどうか整数に変換して確認する
                Integer.parseInt(str);

                //変換に成功した場合、入力された値を返す
                return str;

            } catch (NumberFormatException ex) {
                //変換に失敗した場合、再入力を促す
                System.out.println("整数で入力してください。");
                logger.error("整数で入力してください。"+ex.toString());
                System.out.println();
            }

        }
    }

    public static String inputNumber(int min, int max) {
        while (true) {
            //入力された整数を取得する
            String str = inputNumber();

            //整数に変換して、引数で指定されている範囲内かをチェックし、
            //範囲内の場合、入力された値（変換前の値）を返す
            int value = Integer.parseInt(str);
            if ((min <= value) && (value <= max)) {
                return str;
            }

            //範囲外の場合、再入力を促す
            System.out.println(min + "から" + max
                    + "までの整数を入力してください。");
            System.out.println();
            logger.error(min + "から" + max
                    + "までの整数を入力してください。");
        }
    }
}
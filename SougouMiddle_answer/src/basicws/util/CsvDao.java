package basicws.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;

public class CsvDao {

    private static final String FILE_NAME = "member.csv";
    //ファイル内の社員情報をキャッシュするためのArrayList。
    //社員情報一件をMemberBeanで格納する。
    private static ArrayList<String[]> memberList;
    //ファイル更新フラグ。trueの場合にはmemberListをキャッシュしなおす。
    private static boolean isChanged = true;

    private final static Logger logger = Logger.getLogger(CsvDao.class);

    public static ArrayList<MemberBean> search(int key, String query) {

        //社員情報を格納するためのArrayListを作成する
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する
            String[] record = fetch(index);

            //取得結果がnullの場合、ループを抜ける
            if (record == null) {
                break;
            }

            //取得した社員情報が引数で指定した値を含んでいる場合、
            //その社員情報でMemberBeanを作成し、ArrayListに格納する
            if (record[key - 1].indexOf(query) != -1) {
                MemberBean bean = new MemberBean(record);
                list.add(bean);
            }
            index++;
        }
        //ArratListを返す
        return list;
    }

    public static MemberBean searchById(String query) {
        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する
            String[] record = fetch(index);

            //取得結果がnullの場合、nullを返す
            if (record == null) {
                return null;
            }

            //取得した社員情報の社員番号が引数で指定した番号と等しい場合、
            //その社員情報でMemberBeanを作成して返す
            if (record[0].equals(query)) {
                MemberBean bean = new MemberBean(record);
                return bean;
            }
            index++;
        }
    }

    public static void insert(MemberBean bean) {

        try {
            //ファイル書き込みのためのオブジェクトを取得する
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            //社員情報をカンマで区切りながらファイルへ書き込む
            bw.write(
                    bean.getNo() + ","
                    + bean.getName() + ","
                    + bean.getBusho() + ","
                    + bean.getShikaku() + ","
                    + bean.getTokugi() + ","
                    + bean.getHobby() + ","
                    + bean.getHometown());
            bw.newLine();
            bw.close();
            //ファイルに変更を加えたので、isChangedフラグをtrueにする。
            isChanged = true;

        } catch (IOException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("ファイルアクセスに失敗しました。"+ex.toString());
            logger.error("アプリケーションを終了します。");
            System.exit(0);
        }

    }

    public static void update(MemberBean bean) {

        //社員情報を格納するためのArrayListを作成する
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する
            String[] record = fetch(index);

            //取得結果がnullの場合、ループを抜ける
            if (record == null) {
                break;
            }

            //取得した社員情報の社員番号が引数で指定したMemberBeanの
            //社員番号と等しい場合、引数のMemberBeanをArrayListに格納する
            //等しくない場合、上記で取得した社員情報でMemberBeanを
            //作成してArrayListに格納する
            if (record[0].equals(bean.getNo())) {
                list.add(bean);
            } else {
                MemberBean mb = new MemberBean(record);
                list.add(mb);
            }
            index++;
        }

        try {
            //ファイル書き込みのためのオブジェクトを取得する
            FileWriter fw = new FileWriter(FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(fw);

            //ArrayListにある社員情報を取り出して
            //カンマで区切ってファイルへ書き込む
            for (MemberBean mb : list) {
                bw.write(
                        mb.getNo() + ","
                        + mb.getName() + ","
                        + mb.getBusho() + ","
                        + mb.getShikaku() + ","
                        + mb.getTokugi() + ","
                        + mb.getHobby() + ","
                        + mb.getHometown());
                bw.newLine();
            }
            bw.close();
            //ファイルに変更を加えたので、isChangedフラグをtrueにする。
            isChanged = true;

        } catch (FileNotFoundException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("ファイルアクセスに失敗しました。"+ex.toString());
            logger.error("アプリケーションを終了します。");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("ファイルアクセスに失敗しました。"+ex.toString());
            logger.error("アプリケーションを終了します。");
           System.exit(0);
        }
    }

    public static void delete(MemberBean bean) {

        //社員情報を格納するためのArrayListを作成する
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する
            String[] record = fetch(index);

            //取得結果がnullの場合、ループを抜ける
            if (record == null) {
                break;
            }

            //取得した社員情報でMemberBeanを作成して
            //ArrayListに格納する
            MemberBean mb = new MemberBean(record);
            list.add(mb);

            index++;
        }

        try {
            //ファイル書き込みのためのオブジェクトを取得する
            FileWriter fw = new FileWriter(FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(fw);

            //ArrayListにある社員情報を取り出して、引数のMemberBeanの
            //社員番号と比較し、等しくない場合のみ、カンマで区切って
            //ファイルへ書き込む
            for (MemberBean mb : list) {
                if (!bean.getNo().equals(mb.getNo())) {
                    bw.write(
                            mb.getNo() + ","
                            + mb.getName() + ","
                            + mb.getBusho() + ","
                            + mb.getShikaku() + ","
                            + mb.getTokugi() + ","
                            + mb.getHobby() + ","
                            + mb.getHometown());
                    bw.newLine();
                }
            }
            bw.close();
            //ファイルに変更を加えたので、isChangedフラグをtrueにする。
            isChanged = true;

        } catch (FileNotFoundException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("ファイルアクセスに失敗しました。"+ex.toString());
            logger.error("アプリケーションを終了します。");
           System.exit(0);
        } catch (IOException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            logger.error("ファイルアクセスに失敗しました。"+ex.toString());
            logger.error("アプリケーションを終了します。");
            System.exit(0);
        }
    }

    public static boolean isDuplicateKey(String no) {

        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する。
            String[] record = fetch(index);

            //取得できなかった場合、falseを返す
            if (record == null) {
                return false;
            }

            //取得した社員番号とこのメソッドで指定された引数が
            //一致する場合、社員番号が重複しているので、tureを返す
            if (record[0].equals(no)) {
                return true;
            }
            index++;
        }

    }

    private static String[] fetch(int index) {
        // isChangedフラグがtrueの場合には、
        // CSVファイルから社員情報をキャッシュしなおす。
        if (isChanged) {
            //社員情報リストを生成する
            memberList = new ArrayList<String[]>();
            try {
                //ファイル読み込みのためのオブジェクトを取得する
                FileReader fr = new FileReader(FILE_NAME);
                BufferedReader br = new BufferedReader(fr);
                while (true) {
                    //ファイルから１行、社員情報を読み込む
                    String line = br.readLine();

                    //読み込む社員情報がなかった場合、ループを抜ける
                    if (line == null) {
                        //キャッシュ更新が完了したので、
                        //isChangedフラグをfalseにする
                        memberList.add(null);
                        isChanged = false;
                        //ファイルをクローズする
                        br.close();
                        break;
                    }

                    //読み込んだ社員情報をカンマで区切って配列に格納する
                    String[] record = line.split(",");
                    memberList.add(record);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("ファイルアクセスに失敗しました。");
                System.out.println("アプリケーションを終了します。");
                logger.error("ファイルアクセスに失敗しました。"+ex.toString());
                logger.error("アプリケーションを終了します。");
                System.exit(0);
            } catch (IOException ex) {
                System.out.println("ファイルアクセスに失敗しました。");
                System.out.println("アプリケーションを終了します。");
                logger.error("ファイルアクセスに失敗しました。"+ex.toString());
                logger.error("アプリケーションを終了します。");
                System.exit(0);
            }
        }
        //引数で指定された行番号の社員情報を返す。
        return memberList.get(index - 1);
    }
}
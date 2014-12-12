import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * CSVファイルとのやり取りを行うDAOクラス
 */
public class CsvDao {

    private static final String FILE_NAME = "member.csv";
    // ファイル内の社員情報をキャッシュするためのArrayList。社員情報一件をString[]で格納する
    private static ArrayList<String[]> memberList;
    //ファイル更新フラグ。trueの場合にはmemberListをキャッシュしなおす
    private static boolean isChanged = true;

    // 該当する社員情報を複数件数返すため、
    // 戻り値の型をArrayList<MemberBean>型に変更
    public static ArrayList<MemberBean> search(int key, String query) {

        //検索結果を返すためのArrayListを生成する
        ArrayList<MemberBean> searchList = new ArrayList<MemberBean>();
        //行番号に１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する。
            String[] record = fetch(index);

            //取得結果がnullの場合、ループを抜ける
            if (record == null) {
                break;
            }

            //取得した社員情報が引数で指定した値を含んでいる場合、
            //その社員情報をMemberBeanとしてArrayListに格納する
            if (record[key - 1].indexOf(query) != -1) {
                MemberBean bean = new MemberBean(record);
                searchList.add(bean);
            }
            index++;
        }
        //検索結果のArrayListを返す
        return searchList;
    }

    public static void insert(MemberBean bean) {

        try {
            //ファイル書き込みのためのオブジェクトを取得する
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            //社員情報をカンマで区切りながらファイルへ書き込む
            String record = bean.getNo() + ","
                    + bean.getName() + ","
                    + bean.getBusho() + ","
                    + bean.getShikaku() + ","
                    + bean.getTokugi() + ","
                    + bean.getHobby() + ","
                    + bean.getHometown();
            bw.write(record);

            bw.newLine();
            bw.close();

            //ファイルに変更を加えたので、isChangedフラグをtrueにする。
            isChanged = true;
        } catch (IOException ex) {
            System.out.println("ファイルアクセスに失敗しました。");
            System.out.println("アプリケーションを終了します。");
            System.exit(0);
        }
    }

    private static String[] fetch(int index) {
        // isChangedフラグがtrueの場合には、CSVファイルから社員情報をキャッシュしなおす
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
                        //キャッシュ更新が完了したので、isChangedフラグをfalseにする
                        isChanged = false;
                        //ファイルをクローズする
                        br.close();
                        //memberListにnullを代入する
                        memberList.add(null);
                        break;
                    }

                    //読み込んだ社員情報をカンマで区切って配列に格納する
                    String[] record = line.split(",");
                    memberList.add(record);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("ファイルアクセスに失敗しました。");
                System.out.println("アプリケーションを終了します。");
                System.exit(0);
            } catch (IOException ex) {
                System.out.println("ファイルアクセスに失敗しました。");
                System.out.println("アプリケーションを終了します。");
                System.exit(0);
            }
        }
        //引数で指定された行番号の社員情報を返す。
        return memberList.get(index - 1);
    }

    public static boolean isDuplicateKey(String no) {

        //行番号の１をセットする
        int index = 1;

        while (true) {
            //引数で指定した行番号の社員情報を１件取得する
            String[] record = fetch(index);

            //取得できなかった場合、falseを返す
            if (record == null) {
                return false;
            }

            //取得した社員コードとこのメソッドで指定された引数が
            //一致する場合、社員コードが重複しているので、trueを返す
            if (record[0].equals(no)) {
                return true;
            }
            index++;
        }
    }
}
// CSV形式のファイルからデータを読み込み、整形して表示するプログラム
// 使用するクラスのimport宣言
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class CsvViewer {
    public static void main(String[] args) {
        try {
            // FileReaderとBufferedReaderでファイルからのデータを読み込む
            FileReader fr = new FileReader("C:\\sample.csv");
            BufferedReader br =new BufferedReader(fr);
            
            // ファイルから全てのデータを読み込む
            while(true) {
                // readLineで1行読み込み
                String line = br.readLine();
                // ファイルの最後かどうかを判定する
                if (line == null) {
                    // ファイルの最後の場合は処理終了
                    break;
                }
                
                // 読み込んだ1行の文字列をカンマ(,)で分割
                StringTokenizer st = new StringTokenizer(line, ",");
                
                // カンマで区切った文字列要素のループ
                while(st.hasMoreTokens()) {
                    // 要素を取得して表示。タブで区切る。
                    System.out.print(st.nextToken() + "\t");
                }
                // 1行の表示の最後に改行する
                System.out.println();
            }
            // 開いたファイルを閉じる
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // 指定したファイルが無い場合
            e.printStackTrace();
        } catch (IOException e) {
            // 入力エラーの場合
            e.printStackTrace();
        }
    }
}
import java.io.*;

class FileIO{
	public static void main(String args[]){
		try {
			//ファイル書き込みのためのオブジェクトを取得する
			FileWriter fw = new FileWriter("greeting.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			//データと最後に改行記号を書き込む
			bw.write("こんにちわ！ユニバ一郎さん！");
			bw.newLine();
			//ファイル書き込みが完了したので、ファイルをクローズする
			bw.close();
			
			//ファイル読み込みのためのオブジェクトを取得する
			FileReader fr = new FileReader("greeting.txt");
			BufferedReader br = new BufferedReader(fr);
			//改行までの一行を読み込む
			String input = br.readLine();
			//ファイル読み込みが完了したので、ファイルをクローズする
			br.close();
			
			System.out.println("読み込んだデータは、" + input + "です。");
		} catch(IOException ex) {
			System.out.println("ファイルアクセスに失敗しました。");
			System.out.println("アプリケーションを終了します。");
			System.exit(0);
		}
	}
}
import java.io.*;

// 標準入力（キーボード）から入力されたデータを表示するプログラム
class StdIO{
    public static void main(String args[]){
    	// BuffredReader型の変数を宣言
    	BufferedReader br = null;
    	try{
    		// 標準入力（キーボード）から入力データを受け付けるためのインスタンスを生成
    		br = new BufferedReader(new InputStreamReader(System.in));
    		// 無限ループ
    		while(true){
    			// 入力を促す
    			System.out.print("Please Input Data > ");
    			// Enterキーが押されるまでの入力データを文字列として読み込む
    			String input = br.readLine();
    			System.out.println("Inputed data : " + input);
    		}
    	} catch (IOException e){
    		System.out.println("入出力エラーが発生しました");
    	} finally{
    		// 通常は入出力に使用したファイルをクローズする処理が必要
    	}
    }
}

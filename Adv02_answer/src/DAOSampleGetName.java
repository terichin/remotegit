import dao.DAOSample;


// DAOを利用しemployeeテーブルからデータを取得するプログラム
public class DAOSampleGetName {
	public static void main(String[] args) {
		// DAOクラスを利用する場合はオブジェクトを生成する
		DAOSample dao = new DAOSample();

		// DAOクラスのオブジェクトを使用してDBにアクセスする
		String result = dao.getName(100);
		if (result == null) {
			// 取得失敗時はエラーメッセージを表示する
        	System.out.println("指定されたIDが見つかりません。");
		} else {
			// 取得成功時は取得したデータを表示する
			System.out.println("ID100の氏名は" + result + "です。");
		}
	}
}
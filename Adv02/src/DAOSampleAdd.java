import dao.DAOSample;


// DAOを利用しemployeeテーブルからデータを取得するプログラム
public class DAOSampleAdd {
	public static void main(String[] args) {
		DAOSample dao = new DAOSample();
		
		int id = 200;
		String name = "ユニバ花子";
		String password = "univ875";
		
		// データをEMPLOYEEテーブルに追加する
		int count = dao.add(id, name, password);
		if (count != 1) {
			System.out.println("データの挿入に失敗しました。");
		} else {
			System.out.println(count + "行追加しました。");
		}
	}
}
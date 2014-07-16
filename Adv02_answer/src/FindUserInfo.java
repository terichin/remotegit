import dao.*;
// employeeテーブルとcontactテーブルから指定の従業員の情報を取得するプログラム
public class FindUserInfo {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			// 従業員名取得
			EmployeeDAO empDao = new EmployeeDAO();
			String name = empDao.getName(id);
			
			// 内線番号取得
			ContactDAO contactDao = new ContactDAO();
			int extension = contactDao.getExtension(id);
			
			System.out.println("ID" + id + "の氏名は" + name +
				"、内線番号は" + extension + "です。");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("検索するIDを引数で与える必要があります。");
		} catch (NumberFormatException e) {
			System.out.println("検索するIDは数値でなければなりません。");
		}
	}
}
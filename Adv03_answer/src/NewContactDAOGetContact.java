import dao.NewContactDAO;
import dto.ContactDTO;
import dao.DAOException;

// NewContactDAOからDTOでデータを取得するプログラム
public class NewContactDAOGetContact {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			NewContactDAO dao = new NewContactDAO();
			ContactDTO dto = dao.getContact(id);
			if (dto == null) {
	        	System.out.println("指定されたIDが見つかりません。");
			} else {
				System.out.println("ID" + dto.getId() + "の内線番号は" +
					dto.getExtension() + "、携帯番号は" +
					dto.getMobile() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		} catch (NumberFormatException e) {
			System.out.println("IDは整数で指定して下さい。");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("引数の指定が間違っています。");
		}
	}
}

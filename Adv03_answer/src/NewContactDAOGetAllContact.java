import dao.NewContactDAO;
import dto.ContactDTO;

import java.util.ArrayList;
import dao.DAOException;

// NewEmployeeDAOからDTOでデータを取得するプログラム
public class NewContactDAOGetAllContact {
	public static void main(String[] args) {
		try {
			NewContactDAO dao = new NewContactDAO();
			ArrayList<ContactDTO> list = dao.getAllContact();
			for(int i = 0; i < list.size(); i++) {
				ContactDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() +
						"の内線番号は" + dto.getExtension() + 
						"、携帯番号は" + dto.getMobile() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}
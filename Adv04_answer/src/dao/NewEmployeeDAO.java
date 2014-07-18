package dao;
import java.sql.*;
import java.util.*;
import dto.*;

// employeeテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はCommonDAOにあるため、必ず継承します
public class NewEmployeeDAO extends NewCommonDAO {
	// employeeテーブルからIDで指定した氏名を検索するメソッド
	public String getName(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
		try {
		    String username = null;
		    init();
			pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
                username = rs.getString(1);
    			return username;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} finally {
			destroy();
		}
		
		return null;
	}
	
	// employeeテーブルに1件データを挿入するメソッド
	public int add(int id, String name, String password) throws DAOException {
	    PreparedStatement pstmt = null;
		try {
			init();
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);

			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
			throw new DAOException();
		} finally {
			destroy();
		}
	}
	
	// employeeテーブルからIDで指定した従業員情報を検索するメソッド
	public EmployeeDTO getEmployee(int id) throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
	    try {
			pstmt = conn.prepareStatement(
				"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE WHERE ID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 全カラムの情報を取得します
				int userId = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				// DTOクラスのオブジェクトを生成します
				// 引数には取得した各カラムの変数を指定します
				EmployeeDTO dto = new EmployeeDTO(userId, name, password);
				return dto;
           		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return null;
	}

	// employeeテーブルから全従業員情報を検索するメソッド
	public ArrayList<EmployeeDTO> getAllEmployee() throws DAOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    init();
		// 検索結果を複数格納するリスト
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			pstmt = conn.prepareStatement(
				"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE");
			rs = pstmt.executeQuery();
			// 検索結果レコード数回繰り返します
			while (rs.next()) {
				int userId = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				// DTOクラスのオブジェクトを生成します
				EmployeeDTO employee = new EmployeeDTO(userId, name, password);
				// 作成したDTOをリストに追加します
				list.add(employee);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return list;
	}
}
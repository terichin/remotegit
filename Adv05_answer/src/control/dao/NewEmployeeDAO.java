package control.dao;
import java.sql.*;
import java.util.*;
import control.dto.*;

public class NewEmployeeDAO extends NewCommonDAO {
    /*
     * 機　能：　ログイン可能かチェックするメソッド。
     *
     * 引　数：　ユーザ情報を収めたDTOオブジェクト。
     * 戻り値：　ログイン可能ならばtrueを返す。それ以外はfalseを返す。
     * 解　説：　引数で受け取ったDTOからユーザコードとパスワードを取得し、
     *           その情報に該当するユーザ情報がユーザテーブルに存在するか確認し、
     *           存在すればtrueを返し、存在しなければfalseを返す。
     */
    public boolean checkLogin(EmployeeDTO emp) throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt =    conn.prepareStatement("SELECT * FROM EMPLOYEE"
                            + " WHERE ID = ? AND PASSWORD = ?");
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getPassword());
            rs = pstmt.executeQuery();
            boolean isExists = rs.next();
            return isExists;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        } finally {
            destroy();
        }
    }

    /*
     * 機　能：　ユーザ情報を追加するメソッド。
     *
     * 引　数：　追加するユーザ情報を収めたDTOオブジェクト。
     * 戻り値：　追加に成功すれば1を返す。失敗した場合は1以外の値を返す。
     * 解　説：　引数に指定されたユーザ情報をユーザテーブルに登録する。
     */
    public int addUser(EmployeeDTO emp) throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // ユーザコードを採番します
            pstmt = conn.prepareStatement("SELECT NEXTVAL('EMPNO')");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt(1);

                emp.setId(no);
            } else {
                // 採番できなかったため、追加することができません
                return -1;
            }
            // シーケンスから取得したIDを使って登録します
            pstmt =    conn.prepareStatement("INSERT INTO EMPLOYEE"
                            + " (ID, PASSWORD, USERNAME) VALUES (?,?,?)");
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getPassword());
            pstmt.setString(3, emp.getName());
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        } finally {
            destroy();
        }
    }
    
    /*
     * 機　能：　現在登録されているユーザの情報一覧を取得する。
     *
     * 引　数：　なし。
     * 戻り値：　ユーザ情報一覧を収めたArrayList。
     * 解　説：　ArrayListを生成する。ユーザ情報テーブルに登録されている全ユーザ情報の
     *           全情報を取得して、各ユーザ情報をDTOに格納して先に生成したArrayListに
     *           格納し、最後に作成したArrayListを返却する。
     */
    public ArrayList<EmployeeDTO> searchAllUser() throws DAOException {
        init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
        try {
            pstmt =    conn.prepareStatement(
                    "SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                EmployeeDTO dto = new EmployeeDTO(id, name, password);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        } finally {
            destroy();
        }
        return list;
    }

	/*
	 * 機　能：　指定したユーザコードに該当するユーザ情報を取得するメソッド。
	 *
	 * 引　数：　ユーザコード。
	 * 戻り値：　ユーザ情報を収めたDTOオブジェクト。
	 * 解　説：　引数で受け取ったユーザコードを条件として検索を実行し、
	 *           取得したユーザ情報はDTOオブジェクトに収めて返却する。
	 */
	public EmployeeDTO getUser(int empId) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =	conn.prepareStatement(
					"SELECT ID, PASSWORD, USERNAME FROM EMPLOYEE WHERE ID = ?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				EmployeeDTO dto = new EmployeeDTO(id, name, password);
				
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
	
	/*
	 * 機　能：　ユーザ情報を更新するメソッド。
	 *
	 * 引　数：　更新するユーザ情報を収めたDTOオブジェクト。
	 * 戻り値：　成功時は1を返す。失敗時は1以外を返す。
	 * 解　説：　引数のDTOで渡されたユーザ情報を使用して、ユーザ情報テーブルの
	 *           当該ユーザ情報を更新する。
	 */
	public int updateUser(EmployeeDTO emp) throws DAOException {
		init();
        PreparedStatement pstmt = null;
		try {
			pstmt =	conn.prepareStatement(
				"UPDATE EMPLOYEE SET PASSWORD = ?, USERNAME = ? WHERE ID = ?");
			pstmt.setString(1, emp.getPassword());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
	}	
}
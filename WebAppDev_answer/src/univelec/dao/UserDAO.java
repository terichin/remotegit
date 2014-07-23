package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * ユーザテーブルとのやり取りを行うクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDAO extends CommonDAO {

	/*
	 * 機　能：　ユーザ情報を追加するメソッド。
	 *
	 * 引　数：　追加するユーザ情報を収めたDTOオブジェクト。
	 * 戻り値：　追加に成功すれば1を返す。失敗した場合は1以外の値を返す。
	 * 解　説：　引数に指定されたユーザ情報をユーザテーブルに登録する。
	 */
	public int add(UserDTO user) throws DAOException {
		init();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

		try {
            // ユーザコードを採番する。
            pstmt = conn.prepareStatement("SELECT NEXTVAL('USERNO')");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int no = rs.getInt(1);

                user.setId(no);
            } else {
                // 採番できなかったため、追加不可。
                return -1;
            }

			pstmt =	conn.prepareStatement("INSERT INTO USERTBL"
							+ " (CODE, NAME, KANA, PHONE, MAIL, PASSWORD, PRIVILEGE)"
							+ " VALUES (?,?,?,?,?,?,?)");
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getKana());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getMail());
			pstmt.setString(6, user.getPassword());
			pstmt.setInt(7, user.getPrivilege());
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
	 * 機　能：　ログイン可能かチェックするメソッド。
	 *
	 * 引　数：　ユーザ情報を収めたDTOオブジェクト。
	 * 戻り値：　ログイン可能ならばtrueを返す。それ以外はfalseを返す。
	 * 解　説：　引数で受け取ったDTOからユーザコードとパスワードを取得し、
	 *           その情報に該当するユーザ情報がユーザテーブルに存在するか確認し、
	 *           存在すればtrueを返し、存在しなければfalseを返す。
	 */
	public boolean checkLogin(UserDTO user) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT * FROM USERTBL"
							+ " WHERE CODE = ? AND PASSWORD = ?");
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getPassword());
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
	 * 機　能：　ユーザ情報を削除するメソッド。
	 *
	 * 引　数：　削除するユーザ情報のユーザコード。
	 * 戻り値：　成功時は1を返す。失敗時は1以外を返す。
	 * 解　説：　引数で指定されたユーザコードに紐付くユーザ情報を削除する。
	 */
	public int delete(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM USERTBL WHERE CODE = ?");
			pstmt.setInt(1, id);
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
	 * 機　能：　ユーザ情報を更新するメソッド。
	 *
	 * 引　数：　更新するユーザ情報を収めたDTOオブジェクト。
	 * 戻り値：　成功時は1を返す。失敗時は1以外を返す。
	 * 解　説：　引数のDTOで渡されたユーザ情報を使用して、ユーザ情報テーブルの
	 *           当該ユーザ情報を更新する。
	 */
	public int edit(UserDTO user) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt =	conn.prepareStatement("UPDATE USERTBL SET"
							+ " NAME = ?, KANA = ?, PHONE = ?,"
							+ " MAIL = ?, PASSWORD = ?, PRIVILEGE = ? WHERE CODE = ?");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getKana());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getMail());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getPrivilege());
			pstmt.setInt(7, user.getId());
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
	 * 機　能：　指定したユーザコードに該当するユーザ情報を取得するメソッド。
	 *
	 * 引　数：　ユーザコード。
	 * 戻り値：　ユーザ情報を収めたDTOオブジェクト。
	 * 解　説：　引数で受け取ったユーザコードを条件として検索を実行し、
	 *           取得したユーザ情報はDTOオブジェクトに収めて返却する。
	 */
	public UserDTO getUser(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT"
							+ " CODE, NAME, KANA, PHONE, MAIL, PASSWORD, PRIVILEGE"
							+ " FROM USERTBL WHERE CODE = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String kana = rs.getString(3);
				String phone = rs.getString(4);
				String mail = rs.getString(5);
				String password = rs.getString(6);
				int privilege = rs.getInt(7);

				UserDTO dto =
						new UserDTO(no, name, kana, phone, mail, password, privilege);

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
	 * 機　能：　現在登録されているユーザの情報一覧を取得する。
	 *
	 * 引　数：　なし。
	 * 戻り値：　ユーザ情報一覧を収めたArrayList。
	 * 解　説：　ArrayListを生成する。ユーザ情報テーブルに登録されている全ユーザ情報の
	 *           全情報を取得して、各ユーザ情報をDTOに格納して先に生成したArrayListに
	 *           格納し、最後に作成したArrayListを返却する。
	 */
	public ArrayList<UserDTO> getUserList() throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();

		try {
			pstmt =	conn.prepareStatement("SELECT CODE, NAME, PHONE, MAIL"
							+ " FROM USERTBL");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String mail = rs.getString(4);

				UserDTO dto = new UserDTO(id, name, phone, mail);

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

}

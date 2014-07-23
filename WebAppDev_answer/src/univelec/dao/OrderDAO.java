package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * 注文テーブルとのやり取りを行うDAOクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderDAO extends CommonDAO {

	/*
	 * 機　能：　指定された番号を持つ注文情報を削除するメソッド。
	 *
	 * 引　数：　キャンセルする注文の注文番号。
	 * 戻り値：　成功時は1を返す。失敗時は1以外の値を返す。
	 * 解　説：　対象となる注文情報に対してDELETE文を発行し、その更新行数を
	 *           返却する。
	 */
	public int delete(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM ORDERTBL WHERE NO = ?");
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
	 * 機　能：　注文情報を追加するメソッド。
	 *
	 * 引　数：　注文DTO。
	 * 戻り値：　成功時は注文番号を返す。注文に失敗した場合は-1。
	 * 解　説：　在庫テーブルでDTOで指定された商品番号の商品在庫を確認する。
	 *           その後注文番号をDBMSのシーケンスから取得し、取得した注文番号を
	 *           注文DTOに設定して注文情報を確定し、そのDTOを使用して
	 *           注文テーブルへ情報を登録する。
	 */
	public int add(OrderDTO dto) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT STOCK FROM ITEMTBL"
							+ " WHERE NO = ?");
			pstmt.setInt(1, dto.getItemNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int stock = rs.getInt(1);

				if (dto.getQuantity() > stock) {
					return -1;
				}
			} else {
				return -1;
			}

			// 注文番号を採番する。
			pstmt = conn.prepareStatement("SELECT NEXTVAL('ORDERNO')");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt(1);

				dto.setNo(no);
			} else {
				// 採番できなかったため、注文不可。
				return -1;
			}
			// 採番した注文番号を使って注文情報を登録する。
			pstmt =	conn.prepareStatement("INSERT INTO ORDERTBL"
							+ " (NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE)"
							+ " VALUES (?,?,?,?,?,?)");
			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getItemNo());
			pstmt.setString(3,dto.getItemName());
			pstmt.setInt(4, dto.getQuantity());
			pstmt.setInt(5, dto.getUserId());
			pstmt.setTimestamp(6, dto.getOrderDate());

			int result = pstmt.executeUpdate();
			if (result != 1) {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}

		return dto.getNo();
	}

	/*
	 * 機　能：　注文番号に紐付く注文情報を取得するメソッド。
	 *
	 * 引　数：　注文番号。
	 * 戻り値：　注文情報DTOを返す。見つからない場合はnullを返す。
	 * 解　説：　注文テーブルより注文情報を検索条件として情報を取得し、
	 *           取得した情報をDTOオブジェクトに格納して返却する。
	 */
	public OrderDTO getOrder(int orderId) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT"
						+ " NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE"
						+ " FROM ORDERTBL WHERE NO = ?");
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt(1);
				int itemNo = rs.getInt(2);
				String itemName = rs.getString(3);
				int count = rs.getInt(4);
				int usercode = rs.getInt(5);
				Timestamp orderdate = rs.getTimestamp(6);

				OrderDTO dto = new OrderDTO(
						no, itemNo, itemName, count, usercode, orderdate);

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
	 * 機　能：　ユーザの注文履歴を取得するメソッド。
	 *
	 * 引　数：　ユーザコード。
	 * 戻り値：　当該ユーザの注文履歴を保存したArrayListを返す。
	 *           注文履歴が1件も無い場合は空のArrayListを返す。
	 * 解　説：　ArrayListを生成し、注文テーブルからユーザコードを検索条件として
	 *           注文の履歴を取得する。取得した注文情報はそれぞれDTOオブジェクトに
	 *           保存し、DTOオブジェクトを先に作成したArrayListに追加して注文履歴を
	 *           保存したArrayListを最後に返却する。
	 */
	public ArrayList<OrderDTO> getOrderList(int id) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();

		try {
			pstmt =	conn.prepareStatement("SELECT"
						+ " NO, ITEMNO, ITEMNAME, COUNT, USERCODE, ORDERDATE"
						+ " FROM ORDERTBL WHERE USERCODE = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				int itemNo = rs.getInt(2);
				String itemName = rs.getString(3);
				int count = rs.getInt(4);
				int usercode = rs.getInt(5);
				Timestamp orderdate = rs.getTimestamp(6);

				OrderDTO dto = new OrderDTO(
						no, itemNo, itemName, count, usercode, orderdate);

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

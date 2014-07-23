package univelec.dao;
import java.sql.*;
import java.util.*;
import univelec.dto.*;

/*
 * 商品テーブルとのやり取りを行うクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemDAO extends CommonDAO {

	/*
	 * 機　能：　商品情報を取得するメソッド。
	 *
	 * 引　数：　取得する商品情報の商品番号。
	 * 戻り値：　商品情報を保存するDTOオブジェクト。
	 * 解　説：　商品番号に紐付く商品情報を取得し、返却する。
	 */
	public ItemDTO getItem(int no) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt =	conn.prepareStatement("SELECT NO, NAME, PRICE"
							+ " FROM ITEMTBL WHERE NO = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				ItemDTO item = new ItemDTO(code, name, price);
				return item;
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
	 * 機　能：　指定したカテゴリ内の商品情報一覧を取得するメソッド。
	 *
	 * 引　数：　カテゴリコード。
	 * 戻り値：　商品情報一覧を保存したArrayList。
	 *           1つも商品が無い場合は空のArrayListを返す。
	 * 解　説：　一覧を保存するArrayListを生成した上で、指定されたカテゴリコードと
	 *           一致する商品情報を検索する。該当する商品情報がある場合は、それぞれ
	 *           DTOに格納して先に生成したArrayListに追加する。
	 *           最後に一覧を保存したArrayListを返す。
	 */
	public ArrayList<ItemDTO> getItemList(int category) throws DAOException {
		init();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		try {
			pstmt =	conn.prepareStatement("SELECT NO, NAME, PRICE"
							+ " FROM ITEMTBL WHERE CATEGORY = ?");
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				ItemDTO item = new ItemDTO(no, name, price);
				list.add(item);
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

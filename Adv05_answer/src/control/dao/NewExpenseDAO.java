package control.dao;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import control.dto.*;

public class NewExpenseDAO extends NewCommonDAO {
	/*
	 * 機　能：　経費情報を追加するメソッド。
	 *
	 * 引　数：　ExpenseDTO。
	 * 戻り値：　成功時は注文番号を返す。注文に失敗した場合は-1。
	 * 解　説：　経費番号をDBMSのシーケンスから取得し、取得した経費番号を
	 *           ExpenseDTOに設定して経費情報を確定し、そのDTOを使用して
	 *           経費テーブルへ情報を登録する。
	 */
	public int addExpense(ExpenseDTO exp) throws DAOException {
		init();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		try {
            // 経費コードを採番します
            pstmt = conn.prepareStatement("SELECT NEXTVAL('EXPENSEID')");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int no = rs.getInt(1);

                exp.setExpenseId(no);
            } else {
                // 採番できなかったため、追加することができません
                return -1;
            }
            // 採番した経費コードを使用して経費情報をテーブルに追加する
			pstmt =	conn.prepareStatement("INSERT INTO EXPENSE"
							+ " (EXPENSEID, ID, USEDATE, USE, COST) VALUES (?,?,?,?,?)");
			pstmt.setInt(1, exp.getExpenseId());
			pstmt.setInt(2, exp.getId());
			pstmt.setDate(3, exp.getUseDate());
			pstmt.setString(4, exp.getUse());
			pstmt.setInt(5, exp.getCost());
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
	 * 機　能：　ユーザの経費情報を取得するメソッド。
	 *
	 * 引　数：　ユーザコード。
	 * 戻り値：　当該ユーザの経費情報を保存したArrayListを返す。
	 *           経費情報が1件も無い場合は空のArrayListを返す。
	 * 解　説：　ArrayListを生成し、経費テーブルからユーザコードを検索条件として
	 *           経費情報を取得する。取得した経費情報はそれぞれDTOオブジェクトに
	 *           保存し、DTOオブジェクトを先に作成したArrayListに追加して経費情報を
	 *           保存したArrayListを最後に返却する。
	 */
	public ArrayList<ExpenseDTO> getExpenseList(int id) throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExpenseDTO> list = new ArrayList<ExpenseDTO>();
		try {
			pstmt =	conn.prepareStatement(
					"SELECT USEDATE, USE, COST FROM EXPENSE WHERE ID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				java.sql.Date useDate = rs.getDate(1);
				String use = rs.getString(2);
				int cost = rs.getInt(3);
				ExpenseDTO dto = new ExpenseDTO(-1, id, useDate, use, cost);
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
	 * 機　能：　ユーザと年月を指定して経費情報を取得するメソッド。
	 *
	 * 引　数：　検索条件に使用するユーザコード・年・月
	 * 戻り値：　当該条件の経費情報を保存したArrayListを返す。
	 *           経費情報が1件も無い場合は空のArrayListを返す。
	 * 解　説：　ArrayListを生成し、経費テーブルからユーザコード・年・月を検索条件
	 *           として経費情報を取得する。取得した経費情報はそれぞれDTOオブジェ
	 *           クトに保存し、DTOオブジェクトを先に作成したArrayListに追加して
	 *           経費情報を保存したArrayListを最後に返却する。
	 */
	public ArrayList<ExpenseDTO> getExpenseList(int id, int year, int month)
		throws DAOException {
		init();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ExpenseDTO> list = new ArrayList<ExpenseDTO>();
		try {
			String start = year + "/" + month + "/"  + 01;
			String end = year + "/" + month + "/"  + 31;
			java.util.Date date1 = DateFormat.getDateInstance().parse(start);
			java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
			java.util.Date date2 = DateFormat.getDateInstance().parse(end);
			java.sql.Date sqldate2 = new java.sql.Date(date2.getTime());
			pstmt =	conn.prepareStatement(
					"SELECT USEDATE, USE, COST FROM EXPENSE " + 
					"WHERE ID = ? AND USEDATE >= ? AND USEDATE <= ?");
			pstmt.setInt(1, id);
			pstmt.setDate(2, sqldate1);
			pstmt.setDate(3, sqldate2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				java.sql.Date useDate = rs.getDate(1);
				String use = rs.getString(2);
				int cost = rs.getInt(3);
				ExpenseDTO dto = new ExpenseDTO(-1, id, useDate, use, cost);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return list;
	}
}
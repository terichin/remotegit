package dao;
import java.sql.*;
import java.util.ArrayList;

// expenseテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はNewCommonDAOにあるため、必ず継承します
public class NewExpenseDAO extends NewCommonDAO {

    // expenseテーブルに1件のデータを挿入するメソッド
    public int add(int exid, int id, Date date, String use, int cost) throws DAOException {
        PreparedStatement pstmt = null;
        try {
            init();
            pstmt = conn.prepareStatement(
            	"INSERT INTO EXPENSE VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, exid);
            pstmt.setInt(2, id);
            pstmt.setDate(3, date);
            pstmt.setString(4, use);
            pstmt.setInt(5, cost);
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
    
    // expenseテーブルから指定のID・日付を持つレコードのCOST合計を返すメソッド
    public int getCost(int id, Date date) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cost = 0;
        try {
            init();
            pstmt = 
            	conn.prepareStatement("SELECT SUM(COST) FROM EXPENSE WHERE ID = ? AND USEDATE = ?");
            pstmt.setInt(1, id);
            pstmt.setDate(2, date);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	cost = rs.getInt(1);
            }
            return cost;
        } catch (SQLException e) {
            e.printStackTrace();
			// ユーザ定義例外を使用してエラーを通知する
            throw new DAOException();
        } finally {
            destroy();
        }
    }
    
    // expenseテーブルの指定IDの全コストをArrayListで返すメソッド
    public ArrayList getAllCost(int id) throws DAOException {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ArrayList list = null;
    	try {
    		init();
    		pstmt = conn.prepareStatement("SELECT COST FROM EXPENSE WHERE ID = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
            	list.add(rs.getInt(1));
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

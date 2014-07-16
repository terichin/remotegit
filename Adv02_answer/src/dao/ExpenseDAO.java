package dao;
import java.sql.*;

// expenseテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はCommonDAOにあるため、必ず継承します
public class ExpenseDAO extends CommonDAO {
    // expenseテーブルに1件のデータを挿入するメソッド
    public int add(int exid, int id, Date date, String use, int cost) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
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
        } finally {
            destroy();
        }
        return -1;
    }
    
    // expenseテーブルから指定のID・日付を持つレコードのCOST合計を返すメソッド
    public int getCost(int id, Date date) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cost = 0;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            pstmt = conn.prepareStatement(
            			"SELECT SUM(COST) FROM EXPENSE WHERE ID = ? AND USEDATE = ?");
            pstmt.setInt(1, id);
            pstmt.setDate(2, date);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	cost = rs.getInt(1);
            }
            return cost;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return -1;
    }
}
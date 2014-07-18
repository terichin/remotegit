package dao;
import java.sql.*;

// POSTテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はNewCommonDAOにあるため、必ず継承する
public class NewPostDAO extends NewCommonDAO {
    // POSTテーブルからIDで指定した氏名を検索するメソッド
    public String getName(int id) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String username = null;
            init();
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE id=?");
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
    
    // POSTテーブルに1件のデータを挿入するメソッド
    public int add(int id, String postname, int bossid) throws DAOException {
        PreparedStatement pstmt = null;
        try {
            init();
            pstmt = conn.prepareStatement("INSERT INTO POST VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, postname);
            pstmt.setInt(3, bossid);
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
}

package dao;
import java.sql.*;

// postテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はCommonDAOにあるため、必ず継承します
public class PostDAO extends CommonDAO {
    // postテーブルからIDで指定した部署名を検索するメソッド
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String postname = null;
            boolean connected = init();
            if (connected == false) {
                return null;
            }
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                postname = rs.getString(1);
                return postname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return null;
    }

    // postテーブルに1件のデータを挿入するメソッド
    public int add(int id, String postname, int bossid) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
                return -1;
            }
            pstmt = conn.prepareStatement("INSERT INTO POST VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, postname);
            pstmt.setInt(3, bossid);
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return -1;
    }
}
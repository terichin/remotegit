package dao;
import java.sql.*;

// postテーブルにアクセスする機能を受け持つプログラム
// 接続・切断機能はNewCommonDAOにあるため、必ず継承する
public class NewPostDAO extends NewCommonDAO {

    // postテーブルからIDで指定した部署名を検索するメソッド
    public String getName(int id) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String postname = null;
            init();
            pstmt = conn.prepareStatement("SELECT POSTNAME FROM POST WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                postname = rs.getString(1);
                return postname;
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
    
}
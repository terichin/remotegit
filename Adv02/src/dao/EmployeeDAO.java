package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//employeeテーブルにアクセスする機能を受け持つプログラム
//接続・切断機能はCommonDAOにあるため、必ず継承します
public class EmployeeDAO extends CommonDAO{
    // employeeテーブルからIDで指定した氏名を検索するメソッド
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String username = null;
            boolean connected = init();
            if (connected == false) {
            	return null;
            }
            pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
                return username;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return null;
    }
    
    // employeeテーブルに1件のデータを挿入するメソッド
    public int add(int id, String name, String password) {
        PreparedStatement pstmt = null;
        try {
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
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
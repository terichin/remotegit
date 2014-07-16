package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAOパターンでemployeeテーブルへのアクセスを代行するプログラム
public class DAOSample {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "postgres";
  private static final String DB_PASSWORD = "Univ2014";

    private Connection conn;

    // データベースとの接続を行うためのメソッド
    // コネクションオブジェクトを取得するまでの処理を行います
    // データベースへの接続に失敗したときはfalse、成功時にはtrueを返します
    private boolean init() {
        // データベースドライバの読込と接続を行う
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // データベースとのコネクションを切断するメソッド
    // 取得したコネクションオブジェクトをクローズします
    private void destroy() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // employeeテーブルからIDで指定した氏名を検索するメソッド
    // 検索が失敗した時はnullを返します
    public String getName(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // DBから取得した氏名を保存する変数
            String username = null;
            // initメソッドを呼び出し、DB接続処理を実行します
            boolean connected = init();
            if (connected == false) {
            	return null;
            }
            // 引数のIDを検索キーにして氏名を検索します
            pstmt = conn.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // SELECTの実行結果から氏名を取得します
                username = rs.getString(1);
                // 取得した氏名を返します
                return username;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // destroyメソッドを呼び出し、切断処理を実行します
            destroy();
        }
        // 取得に失敗したのでnullを返します
        return null;
    }
    
    // employeeテーブルに1件のデータを挿入するメソッド
    public int add(int id, String name, String password) {
        PreparedStatement pstmt = null;

        try {
            // initメソッドを呼び出し、接続処理を実行します
            boolean connected = init();
            if (connected == false) {
            	return -1;
            }
            // 引数の値を挿入します
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            // INSERTを実行し、戻り値から更新行数を取得する
            int count = pstmt.executeUpdate();
            // 更新成功を返す
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // destroyメソッドを呼び出し、切断処理を実行する
            destroy();
        }
        // 更新に失敗したので-1を返す
        return -1;
    }
}
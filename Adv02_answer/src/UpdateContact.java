import java.sql.*;
// contactテーブルへ1件のデータ更新を行うプログラム
public class UpdateContact {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // ResultSetは必要ありません

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // レコード更新を行うための準備をする
            pstmt = conn.prepareStatement(
                    "UPDATE CONTACT SET EXTENSION = ?, MOBILE = ? WHERE ID = ?");
            // 更新条件をSQL文に追加する
            pstmt.setInt(1, Integer.parseInt(args[1]));
            pstmt.setString(2, args[2]);
            pstmt.setInt(3, Integer.parseInt(args[0]));
            // UPDATE実行
            // 失敗時は SQLException が発生します
            int count = pstmt.executeUpdate();
            System.out.println(count + "件のデータを更新しました。");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データの更新に失敗しました。");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("与えられたデータ項目の数が足りません。");
        } catch (NumberFormatException e) {
            System.out.println("ID、内線番号は数値でなければなりません。");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
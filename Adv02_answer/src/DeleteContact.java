import java.sql.*;
// contactテーブルから1件のデータ削除を行うプログラム
public class DeleteContact {
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
            // レコード削除を行うための準備をする
            pstmt = conn.prepareStatement("DELETE FROM CONTACT WHERE ID=?");
            // 削除条件をSQL文に追加する
            pstmt.setInt(1, Integer.parseInt(args[0]));
            // DELETE実行
            // 失敗時に例外は発生しません
            int count = pstmt.executeUpdate();
            // 戻り値の値が 1 なら1件削除されたことになります
            if (count == 1) {
                System.out.println("1件のデータを削除しました。");
            } else {
                System.out.println("指定されたIDのレコードが存在しません。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("削除するIDを引数で与える必要があります。");
        } catch (NumberFormatException e) {
            System.out.println("削除するIDは数値でなければなりません。");
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
import java.sql.*;
// INNER JOINしたテーブルから1件の検索を行うプログラム
public class FindJoin {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // クエリを行うための準備をする
            pstmt = conn.prepareStatement(
                    "SELECT * FROM EMPLOYEE INNER JOIN CONTACT "
                    + "ON EMPLOYEE.ID = CONTACT.ID  WHERE EMPLOYEE.ID=?");
            // 検索条件をSQL文に追加する
            // args[0]が与えられなかった時には ArrayIndexOutOfBoundsException が発生する
            // intに変換出来なかった時には NumberFormatException が発生する
            pstmt.setInt(1, Integer.parseInt(args[0]));
            rs = pstmt.executeQuery();
            // 検索結果は必ず1件以下であるため、if文で良い
            if (rs.next()) {
                System.out.println("ID\tPASSWORD\tUSERNAME\tID\tEXTENSION\tMOBILE");
                int empId = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                int contactId = rs.getInt(4);
                int extension = rs.getInt(5);
                String mobile = rs.getString(6);
                // 検索結果を表示する
                System.out.println(empId + "\t" + password + "\t\t" + username
                        + "\t" + contactId + "\t" + extension + "\t\t" + mobile);
            } else {
                System.out.println("指定されたIDが見つかりません。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            // args引数から値が取り出せない時に発生する例外
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("検索するIDを引数で与える必要があります。");
            // String型のIDをint型へ変換出来なかった時に発生する例外
        } catch (NumberFormatException e) {
            System.out.println("検索するIDは数値でなければなりません。");
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
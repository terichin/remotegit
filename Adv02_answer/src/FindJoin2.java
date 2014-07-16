import java.sql.*;
// INNER JOINしたテーブルから範囲指定した検索を行うプログラム
public class FindJoin2 {
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
            pstmt = conn.prepareStatement(
                    "SELECT * FROM EMPLOYEE INNER JOIN CONTACT "
                    + "ON EMPLOYEE.ID = CONTACT.ID "
                    + "WHERE EMPLOYEE.ID >= ? AND EMPLOYEE.ID <= ?");
            pstmt.setInt(1, Integer.parseInt(args[0]));
            pstmt.setInt(2, Integer.parseInt(args[1]));
            rs = pstmt.executeQuery();
            System.out.println("ID\tPASSWORD\tUSERNAME\tID\tEXTENSION\tMOBILE");
            while (rs.next()) {
                int empId = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                int contactId = rs.getInt(4);
                int extension = rs.getInt(5);
                String mobile = rs.getString(6);
                System.out.println(empId + "\t" + password + "\t\t" + username + "\t"
                        + contactId + "\t" + extension + "\t\t" + mobile);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("検索するIDを引数で与える必要があります。");
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
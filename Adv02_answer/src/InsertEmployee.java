import java.sql.*;
// employeeテーブルとcontactテーブルに1件ずつのデータ挿入を行うプログラム
public class InsertEmployee {
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/univ";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String password = args[1];
            String username = args[2];
            int extension = Integer.parseInt(args[3]);
            String mobile = args[4];

            int empCount = insertEmployee(id, password, username);
            int contactCount = 0;
            if (empCount == 1) {
                contactCount = insertContact(id, extension, mobile);
            }

            if ((empCount == 1) && (contactCount == 1)) {
                System.out.println("データの登録が成功しました。");
            } else {
                System.out.println("データの登録に失敗しました。");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("与えられたデータ項目の数が足りません。");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("ID、内線番号は数値でなければなりません。");
            e.printStackTrace();
        }
    }

    public static int insertEmployee(int empId, String password, String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?)");
            pstmt.setInt(1, empId);
            pstmt.setString(2, password);
            pstmt.setString(3, username);
            int count = pstmt.executeUpdate();
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データの挿入に失敗しました。");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static int insertContact(int contactId, int extension, String mobile) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            pstmt = conn.prepareStatement("INSERT INTO CONTACT VALUES (?, ?, ?)");
            pstmt.setInt(1, contactId);
            pstmt.setInt(2, extension);
            pstmt.setString(3, mobile);
            int count = pstmt.executeUpdate();
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データの挿入に失敗しました。");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
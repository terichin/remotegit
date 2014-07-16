package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableJoinDAO extends NewCommonDAO {
    public String[] findEmployee(int id) throws DAOException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[] empInfo = null;

        try {
            init();
            pstmt = conn.prepareStatement(
                    "SELECT EMPLOYEE.USERNAME, "
                    + "CONTACT.EXTENSION, CONTACT.MOBILE, P.POSTNAME, "
                    + "(SELECT USERNAME FROM EMPLOYEE WHERE ID = P.BOSSID)"
                    + "FROM EMPLOYEE, CONTACT, POST P "
                    + "WHERE EMPLOYEE.ID = ? AND EMPLOYEE.ID = CONTACT.ID "
                    + "AND EMPLOYEE.ID = P.ID");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                empInfo = new String[5];
                empInfo[0] = rs.getString(1);
                empInfo[1] = rs.getString(2);
                empInfo[2] = rs.getString(3);
                empInfo[3] = rs.getString(4);
                empInfo[4] = rs.getString(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        } finally {
            destroy();
        }
        return empInfo;
    }
}
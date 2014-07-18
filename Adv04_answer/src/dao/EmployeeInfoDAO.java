package dao;
import java.sql.*;
import java.util.*;

import dto.EmployeeInfoDTO;

public class EmployeeInfoDAO extends NewCommonDAO {
	public EmployeeInfoDTO getEmployeeInfo(int id) throws DAOException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeInfoDTO dto = null;
		init();
		try {
			pstmt = conn.prepareStatement(
				"SELECT * FROM EMPLOYEE INNER JOIN CONTACT " +
				"ON EMPLOYEE.ID = CONTACT.ID " +
				"WHERE EMPLOYEE.ID = " + id
				);
			rs = pstmt.executeQuery();
			if (rs.next()) {
                int empId = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                int contactId = rs.getInt(4);
                int extension = rs.getInt(5);
                String mobile = rs.getString(6);
                dto = new EmployeeInfoDTO(
                	empId, password, username, extension, mobile);
                return dto;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return null;
	}
	
	public ArrayList<EmployeeInfoDTO> getAllEmployeeInfo() throws DAOException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		init();
		ArrayList<EmployeeInfoDTO> list = new ArrayList<EmployeeInfoDTO>();
		try {
			pstmt = conn.prepareStatement(
				"SELECT * FROM EMPLOYEE INNER JOIN CONTACT " +
				"ON EMPLOYEE.ID = CONTACT.ID"
				);
			rs = pstmt.executeQuery();
			while (rs.next()) {
                int empId = rs.getInt(1);
                String password = rs.getString(2);
                String username = rs.getString(3);
                int contactId = rs.getInt(4);
                int extension = rs.getInt(5);
                String mobile = rs.getString(6);
                EmployeeInfoDTO dto = new EmployeeInfoDTO(
                	empId, password, username, extension, mobile);
                list.add(dto);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			destroy();
		}
		return list;
	}
}
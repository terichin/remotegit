<%-- ‘S]‹Æˆõî•ñ‚ðˆê——•\Ž¦‚·‚éJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%-- ArrayList‚ðŽg—p‚·‚é‚Ì‚Åimport‚µ‚Ü‚· --%>
<%@ page import="java.util.*" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head><title>AllEmployeeFind.jsp</title></head>
<body>
<%-- DB‚©‚ç]‹Æˆõî•ñ‚ÌƒŠƒXƒg‚ðŽæ“¾‚µ‚Ü‚· --%>
<%
	// DAO‚ðŽg—p‚µ‚ÄDB‚©‚ç’l‚ðŽæ“¾‚·‚é
	NewEmployeeDAO dao = new NewEmployeeDAO();
	ArrayList<EmployeeDTO> list = null;
	try {
		list = dao.getAllEmployee();
%>
<%-- •\‚Ìƒwƒbƒ_•”•ª‚ð•\Ž¦‚µ‚Ü‚· --%>
<table border="1">
<tr>
<th>ID</th>
<th>Ž–¼</th>
<th>ƒpƒXƒ[ƒh</th>
</tr>
<%-- •\‚ÌŠe—v‘f‚ð•\Ž¦‚µ‚Ü‚· --%>
<%
		for (int i = 0; i < list.size(); i++) {
			EmployeeDTO dto = list.get(i);
%>
<tr>
  <td><% out.print(dto.getId()); %></td>
  <td><% out.print(dto.getName()); %></td>
  <td><% out.print(dto.getPassword()); %></td>
</tr>
<%
		}
%>
<%-- DB‚©‚ç‚Ìî•ñŽæ“¾Ž¸”sŽž‚Ìˆ— --%>
<%
	} catch (DAOException e) {
		// Žæ“¾Ž¸”s
		e.printStackTrace();
		out.print("]‹Æˆõî•ñ‚ÌŽæ“¾‚ÉŽ¸”s‚µ‚Ü‚µ‚½B");
	}
%>

</table>
</body>
</html>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AllEmployeeInfo.jsp</title></head>
<body>
<%
	EmployeeInfoDAO dao = new EmployeeInfoDAO();
	ArrayList<EmployeeInfoDTO> list = null;
	try {
		list = dao.getAllEmployeeInfo();
%>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>
<%
		for (int i = 0; i < list.size(); i++) {
			EmployeeInfoDTO dto = list.get(i);
%>
<tr>
<td><% out.println(dto.getId()); %></td>
<td><% out.println(dto.getUserName()); %></td>
<td><% out.println(dto.getPassword()); %></td>
<td><% out.println(dto.getExtension()); %></td>
<td><% out.println(dto.getMobile()); %></td>
</tr>
<%
		}
%>
<%
	} catch (DAOException e) {
		// �擾���s
		e.printStackTrace();
		out.print("�]�ƈ����̎擾�Ɏ��s���܂����B");
	}
%>

</table>
</body>
</html>

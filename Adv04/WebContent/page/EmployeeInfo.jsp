<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>EmployeeInfo.jsp</title></head>
<body>
<h2>

<%
	try {
		// ���̓p�����[�^�𐮐��l�ɕϊ�����
		String strId = request.getParameter("ID");
		int id = Integer.parseInt(strId);
		// DAO���g�p����DB����l���擾����
		EmployeeInfoDAO dao = new EmployeeInfoDAO();
		EmployeeInfoDTO dto = null;
		try {
			dto = dao.getEmployeeInfo(id);
		} catch (DAOException e) {
			// �G���[����(�擾���s)
			e.printStackTrace();
		}

		if (dto != null) {
%>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>
<tr>
<td><% out.println(dto.getId()); %></td>
<td><% out.println(dto.getUserName()); %></td>
<td><% out.println(dto.getPassword()); %></td>
<td><% out.println(dto.getExtension()); %></td>
<td><% out.println(dto.getMobile()); %></td>
</tr>
</table>
<%
		} else {
			out.println("�w���ID��������܂���B");
		}
	} catch (NumberFormatException e) {
		out.println("ID�ɂ͐�������͂��Ă��������B");
	}
%>
</h2>
</body>
</html>

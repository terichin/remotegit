<%-- �S�]�ƈ������ꗗ�\������JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%-- ArrayList���g�p����̂�import���܂� --%>
<%@ page import="java.util.*" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head><title>AllEmployeeFind.jsp</title></head>
<body>
<%-- DB����]�ƈ����̃��X�g���擾���܂� --%>
<%
	// DAO���g�p����DB����l���擾����
	NewEmployeeDAO dao = new NewEmployeeDAO();
	ArrayList<EmployeeDTO> list = null;
	try {
		list = dao.getAllEmployee();
%>
<%-- �\�̃w�b�_������\�����܂� --%>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
</tr>
<%-- �\�̊e�v�f��\�����܂� --%>
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
<%-- DB����̏��擾���s���̏��� --%>
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
<%-- �S�]�ƈ������ꗗ�\������JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%-- ArrayList���g�p����̂�import���܂� --%>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AllContactFind.jsp</title></head>
<body>
<%-- DB����]�ƈ����̃��X�g���擾���܂� --%>
<%
	NewContactDAO dao = new NewContactDAO();
	ArrayList<ContactDTO> list = null;
	try {
		list = dao.getAllContact();
%>
<%-- �\�̃w�b�_������\�����܂� --%>
<table border="1">
<tr>
<th>ID</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>
<%-- �\�̊e�v�f��\�����܂� --%>
<%
		for (int i = 0; i < list.size(); i++) {
			ContactDTO dto = list.get(i);
%>
<tr>
<td><% out.println(dto.getId()); %></td>
<td><% out.println(dto.getExtension()); %></td>
<td><% out.println(dto.getMobile()); %></td>
</tr>
<%
		}
%>
<%-- DB����̏��擾���s���̏��� --%>
<%
	} catch (DAOException e) {
		// �擾���s
		e.printStackTrace();
		out.print("�A������̎擾�Ɏ��s���܂����B");
	}
%>

</table>
</body>
</html>

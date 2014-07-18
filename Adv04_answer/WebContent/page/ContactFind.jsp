<%-- ID���󂯎���Ďw��̏]�ƈ������擾�E�\������JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- DAO/DTO���g�p����̂�import�����s���܂� --%>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ContactFind.jsp</title></head>
<body>
<h2>

<%-- DAO/DTO���g�p����DB��������擾���܂� --%>
<%
	try {
		// ���̓p�����[�^�𐮐��l�ɕϊ�����
		String strId = request.getParameter("CONTACTID");
		int id = Integer.parseInt(strId);
		// DAO���g�p����DB����l���擾����
		NewContactDAO dao = new NewContactDAO();
		ContactDTO dto = null;
		try {
			dto = dao.getContact(id);
		} catch (DAOException e) {
			// �G���[����(�擾���s)
			e.printStackTrace();
		}
%>	

<%-- �擾�ɐ��������ꍇ�̏��� --%>
<%
		if (dto != null) {
%>
<table border="1">
<tr>
<th>ID</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>
<tr>
<td><%= dto.getId() %></td>
<td><%= dto.getExtension() %></td>
<td><%= dto.getMobile() %></td>
</tr>
</table>
<%-- �擾�Ɏ��s����/���͒l�̎擾�Ɏ��s�����ꍇ�̏��� --%>
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

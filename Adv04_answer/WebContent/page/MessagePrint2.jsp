<%-- �O���form����f�[�^���󂯎���ĕ\������JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>

<%-- ���N�G�X�g�p�����[�^���擾���܂� --%>
<%-- �擾����O�ɓ��{��G���R�[�h�̎w������s���܂� --%>
<%
	request.setCharacterEncoding("Windows-31J");
	String firstName = request.getParameter("FIRSTNAME");
	String lastName = request.getParameter("LASTNAME");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>MessagePrint2.jsp</title></head>
<body>
<h2>
<%-- ���N�G�X�g�p�����[�^��\�����܂� --%>
<%
		out.println("����ɂ��́A" + lastName + " " + firstName + "����B");
%>
</h2>
</body>
</html>

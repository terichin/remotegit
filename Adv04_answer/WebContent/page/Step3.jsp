<%-- �Z�b�V��������f�[�^���擾����JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Step3.jsp</title></head>
<body>
<h2>
<%-- EL�\�����g�p���ăZ�b�V��������l���擾���� --%>
���͂������b�Z�[�W�́u
${KeyMessage}
�v�ł��ˁB
<% session.removeAttribute("KeyMessage"); %>
</h2>
</body>
</html>
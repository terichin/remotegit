<%-- ��������\������JSP --%>
<%-- ���̃y�[�W�̓��{��R�[�h���w�肵�܂� --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- ���̃y�[�W�Ŏg�p����Date�N���X��import���܂� --%>
<%@ page import="java.util.*" %>

<%-- ���ݎ��������擾���܂� --%>
<%
  Date date = new Date();
%>

<%-- �o�͂���HTML���쐬���܂� --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>TimePrint.jsp</title></head>
<body>
<h2>
<%-- ���ݎ�����\�����܂� --%>
<%
	out.print("���݂̎�����" + date + "�ł��B");
%>
</h2>
</body>
</html>
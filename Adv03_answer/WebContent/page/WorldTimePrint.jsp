<%-- ���E�̌�������\������JSP --%>
<%-- ���̃y�[�W�̓��{��R�[�h���w�肵�܂� --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- ���̃y�[�W�Ŏg�p����Date�N���X��import���܂� --%>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<%-- ���ݎ��������擾���܂� --%>
<%
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int h = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int m = cal.get(java.util.Calendar.MINUTE);
		int s = cal.get(java.util.Calendar.SECOND);
		String time_local = h + ":" + m + ":" + s;
		int wh = h - 9;
		if (wh < 0) {
			wh +=24;
		}
		String time_world = wh + ":" + m + ":" + s;
%>

<%-- �o�͂���HTML���쐬���܂� --%>
<html>
<head><title>WorldTimePrint.jsp</title></head>
<body>
<h2>
<%-- ���E�̌��ݎ�����\�����܂� --%>
<%
		out.println("���{�W�����̌��ݎ�����" + time_local + "�ł��B");
		out.println("<br>");
		out.println("���E�W�����̌��ݎ�����" + time_world + "�ł��B");
%>
</h2>
</body>
</html>
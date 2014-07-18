<%-- 世界の現時刻を表示するJSP --%>
<%-- このページの日本語コードを指定します --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- このページで使用するDateクラスをimportします --%>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<%-- 現在時刻情報を取得します --%>
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

<%-- 出力するHTMLを作成します --%>
<html>
<head><title>WorldTimePrint.jsp</title></head>
<body>
<h2>
<%-- 世界の現在時刻を表示します --%>
<%
		out.println("日本標準時の現在時刻は" + time_local + "です。");
		out.println("<br>");
		out.println("世界標準時の現在時刻は" + time_world + "です。");
%>
</h2>
</body>
</html>
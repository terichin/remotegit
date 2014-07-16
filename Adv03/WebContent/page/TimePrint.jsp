<%-- 現時刻を表示するJSP --%>
<%-- このページの日本語コードを指定します --%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- このページで使用するDateクラスをimportします --%>
<%@ page import="java.util.*" %>

<%-- 現在時刻情報を取得します --%>
<%
  Date date = new Date();
%>

<%-- 出力するHTMLを作成します --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>TimePrint.jsp</title></head>
<body>
<h2>
<%-- 現在時刻を表示します --%>
<%
	out.print("現在の時刻は" + date + "です。");
%>
</h2>
</body>
</html>
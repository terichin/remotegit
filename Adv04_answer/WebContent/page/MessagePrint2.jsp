<%-- 前画面formからデータを受け取って表示するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>

<%-- リクエストパラメータを取得します --%>
<%-- 取得する前に日本語エンコードの指定を実行します --%>
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
<%-- リクエストパラメータを表示します --%>
<%
		out.println("こんにちは、" + lastName + " " + firstName + "さん。");
%>
</h2>
</body>
</html>

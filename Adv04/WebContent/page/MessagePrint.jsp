<%-- 入力パラメータを表示する JSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>MessagePrint.jsp</title></head>
<body>
<h2>
<%
    request.setCharacterEncoding("Windows-31J");
    String msg = request.getParameter("MESSAGE");
	out.println(msg);
%>
</h2>
</body>
</html>

<%-- セッションからデータを取得するJSP --%>
<%@ page contentType="text/html; charset=Windows-31J" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Step3.jsp</title></head>
<body>
<h2>
<%-- EL構文を使用してセッションから値を取得する --%>
入力したメッセージは「
${KeyMessage}
」ですね。
<% session.removeAttribute("KeyMessage"); %>
</h2>
</body>
</html>
<%@ page contentType="text/html; charset=Windows-31J" %>

<%-- 氏名検索の結果を表示する --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>NameFind.jsp</title></head>
<body>
<h2>
取得した名前は
${name}
です。
<% session.removeAttribute("name"); %>
</h2>
</body>
</html>
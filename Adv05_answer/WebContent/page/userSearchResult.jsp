<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユーザ情報検索結果</title>
</head>

<body>
<center>

  <h1> ユーザ情報検索結果 </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>氏名</th>
    </tr>

    <tr>
      <td>${emp_dto.id}</td>
      <td>${emp_dto.name}</td>
    </tr>
  </table>
<% session.removeAttribute("emp_dto"); %>

<br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>
</center>
</body>
</html>
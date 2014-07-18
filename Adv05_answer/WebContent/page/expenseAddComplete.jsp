<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>経費登録完了</title>
</head>

<body>
<center>

  <h1> 経費登録完了 </h1>
  <br><hr><br>

  下記経費情報を登録しました。<br><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <td>${expense_dto.id}</td>
    </tr>
    <tr>
      <th>日付</th>
      <td>${expense_dto.useDate}</td>
    </tr>
    <tr>
      <th>用途</th>
      <td>${expense_dto.use}</td>
    </tr>
    <tr>
      <th>費用</th>
      <td>${expense_dto.cost}</td>
    </tr>
  </table>
<% session.removeAttribute("expense_dto"); %>

  <br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>

</center>
</body>
</html>
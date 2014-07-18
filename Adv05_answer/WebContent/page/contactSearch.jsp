<%@ page contentType="text/html; charset=Windows-31J"
         import="control.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>電話番号一覧</title>
</head>

<body>
<center>

  <h1> 電話番号一覧 </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>内線番号</th>
      <th>携帯番号</th>
    </tr>

    <c:forEach items="${contact_list}" var="dto">
      <tr>
        <td>${dto.id}</td>
        <td>${dto.extension}</td>
        <td>${dto.mobile}</td>
      </tr>
    </c:forEach>
  </table>
<% session.removeAttribute("emp_list"); %>

  <br>
  <form action="/advance05/control" method="POST">
    <input type="hidden" name="action" value="menu">
    <input type="submit" value="メニューへ戻る">
  </form>

</center>
</body>
</html>
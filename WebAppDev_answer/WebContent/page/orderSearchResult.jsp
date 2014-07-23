<%--
  注文履歴表示画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユニバ電器注文履歴表示</title>
</head>
<body>
<center>

  <h1> ユニバ電器　注文履歴表示 </h1>
  <br><hr><br>

  ユーザコード ${order_id} 様のご利用履歴です。<br>
  注文キャンセルは、注文番号を入力して選択ボタンを押してください。<br>
  <br>

  <table border="1">
    <tr>
      <th>注文番号</th>
      <th>注文日</th>
      <th>商品名</th>
      <th>数量</th>
    </tr>

    <c:forEach items="${order_list}" var="order">
      <tr>
        <td>${order.no}</td>
        <td>${order.orderDate}</td>
        <td>${order.itemName}</td>
        <td>${order.quantity}</td>
      </tr>
    </c:forEach>
  </table>
<%
session.removeAttribute("order_id");
session.removeAttribute("order_list");
%>

  <br>
  <form action="/univelec/control" method="POST">
    注文番号：<input type="text" name="no">
    <input type="hidden" name="action" value="p201-select">
    <input type="submit" value="選択">
  </form>

</center>
</body>
</html>

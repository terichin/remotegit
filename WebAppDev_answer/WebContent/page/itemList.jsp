<%--
  商品一覧画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>ユニバ電器商品検索結果</title>
</head>

<body>
<center>
  <h1> ユニバ電器　商品検索結果 </h1>
  <br><hr><br>

  購入したい商品の商品番号を入力し、選択ボタンを押してください。<br><br>

  <table border="1">
    <tr>
      <th>商品番号</th>
      <th>商品名</th>
      <th>価格</th>
    </tr>

    <c:forEach items="${item_list}" var="item">
      <tr>
        <td>${item.no}</td>
        <td>${item.name}</td>
        <td>\ ${item.price}</td>
      </tr>
    </c:forEach>
    <% session.removeAttribute("item_list"); %>
  </table>

  <br>
  <form action="/univelec/control" method="POST">
    商品番号：<input type="text" name="itemNo">
    <input type="hidden" name="action" value="p101-select">
    <input type="submit" value="選択">
  </form>
</center>
</body>
</html>

<%--
  商品注文画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J"
         import="univelec.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>ユニバ電器商品注文</title>
</head>

<body>
<center>

  <h1> ユニバ電器　商品注文 </h1>
  <br><hr><br>

  <form action="/univelec/control" method="POST">
  <table border="1">
    <tr>
      <th>商品番号</th>
      <td>${item_dto.no}</td>
    </tr>
    <tr>
      <th>商品名</th>
      <td>${item_dto.name}</td>
    </tr>
    <tr>
      <th>価格</th>
      <td>\ ${item_dto.price}</td>
    </tr>
  </table>

  <br>
  数量：<input type="text" name="quantity">
  <input type="hidden" name="action" value="p102-order">
  <input type="submit" value="注文"><br>
  </form>

</center>
</body>
</html>

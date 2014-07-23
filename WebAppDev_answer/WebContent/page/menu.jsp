<%--
  メニュー画面
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>ユニバ電器メニュー</title>
</head>

<body>
<center>
  <h1> ユニバ電器　メニュー </h1>
  <br><hr><br>
</center>
  <ul>
    <li>商品検索
    <form action="/univelec/control" method="POST">
      <select name="category">
        <option value="1">パソコン</option>
        <option value="2">カメラ</option>
        <option value="3">家電</option>
      </select>
      <input type="hidden" name="action" value="p002-itemSearch">
      <input type="submit" value="商品検索">
    </form>

    <li>注文履歴
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-orderHistory">
            <input type="submit" value="表示">
          </form>
        </td>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-orderSearch">
            <input type="submit" value="検索">
          </form>
        </td>
      </tr>
    </table>

    <li>ユーザ情報
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-userList">
            <input type="submit" value="一覧">
          </form>
        </td>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-userAdd">
            <input type="submit" value="登録">
          </form>
        </td>
      </tr>
    </table>

    <li>ログアウト
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-logout">
            <input type="submit" value="ログアウト">
          </form>
        </td>
      </tr>
    </table>
  </ul>

</body>
</html>

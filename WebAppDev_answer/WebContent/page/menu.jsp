<%--
  ���j���[���
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>���j�o�d�탁�j���[</title>
</head>

<body>
<center>
  <h1> ���j�o�d��@���j���[ </h1>
  <br><hr><br>
</center>
  <ul>
    <li>���i����
    <form action="/univelec/control" method="POST">
      <select name="category">
        <option value="1">�p�\�R��</option>
        <option value="2">�J����</option>
        <option value="3">�Ɠd</option>
      </select>
      <input type="hidden" name="action" value="p002-itemSearch">
      <input type="submit" value="���i����">
    </form>

    <li>��������
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-orderHistory">
            <input type="submit" value="�\��">
          </form>
        </td>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-orderSearch">
            <input type="submit" value="����">
          </form>
        </td>
      </tr>
    </table>

    <li>���[�U���
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-userList">
            <input type="submit" value="�ꗗ">
          </form>
        </td>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-userAdd">
            <input type="submit" value="�o�^">
          </form>
        </td>
      </tr>
    </table>

    <li>���O�A�E�g
    <table>
      <tr>
        <td>
          <form action="/univelec/control" method="POST">
            <input type="hidden" name="action" value="p002-logout">
            <input type="submit" value="���O�A�E�g">
          </form>
        </td>
      </tr>
    </table>
  </ul>

</body>
</html>

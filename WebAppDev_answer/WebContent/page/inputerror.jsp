<%--
  �G���[���
  Copyright (c) NTT DATA UNIVERSITY CORPORATION
--%>
<%@ page contentType="text/html; charset=Windows-31J" %>
<html>
<head>
<title>���j�o�d��G���[</title>
</head>

<%
    // �G���[�����������̂ŃZ�b�V������ؒf����B
    if (session != null) {
        session.invalidate();
    }
%>

<body>
<center>

  <h1> ��ʂ���̓��͏��ɕs��������܂��B</h1>
  <h1> ���͏����ēx�m�F���ĉ������B </h1>
  <br><hr><br>

  <form action="/univelec/control" method="GET">
    <input type="submit" value="���O�C����ʂ֖߂�">
  </form>

</center>
</body>
</html>

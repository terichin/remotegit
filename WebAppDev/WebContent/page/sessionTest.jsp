<%@ page contentType="text/html;charset=Windows-31J" %>
<%@ page import="java.util.*" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�Z�b�V�����I�u�W�F�N�g�̃e�X�g�h���C�o</title>
</head>
<body>
<h1>�Z�b�V�����I�u�W�F�N�g�̃e�X�g�h���C�o</h1>

<%
javax.servlet.http.HttpSession session = request.getSession(false);

if (session == null) {
%>
<p>�Z�b�V�����I�u�W�F�N�g������܂���B</p>
<%
} else {
%>  

<p>�Z�b�V�����I�u�W�F�N�g�̓��e�͈ȉ��̂Ƃ���ł��B</p>

<table border>
<tr>
  <th>������</th>
  <th>���e</th>
</tr>

<%
Enumeration names = session.getAttributeNames();
while(names.hasMoreElements()) {
	String atrName = (String)names.nextElement();
%>
<tr>
<td><%= atrName %></td>
<td>
<%
Object value = session.getAttribute(atrName);

if (value instanceof ArrayList) {
  ArrayList list = (ArrayList)value;
%>
<% for(Object o:list) { %>
    <%= o %><br>
<% } %>
<% } else { %>
  <%= value %>
<% } %> 
</td>
</tr>

<%
} // if (value instanceof...
} // if (session == null...
%>
</table>

</body>
</html>
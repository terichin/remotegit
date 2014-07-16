<%@ page contentType="text/html;charset=Windows-31J" %>
<%@ page import="java.util.*" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>セッションオブジェクトのテストドライバ</title>
</head>
<body>
<h1>セッションオブジェクトのテストドライバ</h1>

<%
javax.servlet.http.HttpSession session = request.getSession(false);

if (session == null) {
%>
<p>セッションオブジェクトがありません。</p>
<%
} else {
%>  

<p>セッションオブジェクトの内容は以下のとおりです。</p>

<table border>
<tr>
  <th>属性名</th>
  <th>内容</th>
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
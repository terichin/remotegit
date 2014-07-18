<%@ page contentType="text/html; charset=Windows-31J"
         import="java.util.*"
         import="control.dto.*" %>
<html>
<head>
<title>ユーザ情報</title>
</head>

<body>
<center>

  <h1> ユーザ情報 </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>氏名</th>
      <th>内線番号</th>
      <th>携帯番号</th>
      <th>部署</th>
      <th>上司氏名</th>
    </tr>
    <tr>
      <%
        ArrayList list = (ArrayList)session.getAttribute("emp_list");
        EmployeeDTO empDTO = (EmployeeDTO)list.get(0);
        ContactDTO contactDTO = (ContactDTO)list.get(1);
        PostDTO postDTO = (PostDTO)list.get(2);
        EmployeeDTO bossDTO = (EmployeeDTO)list.get(3);
      %>
      <td><% out.print(empDTO.getId()); %></td>
      <td><% out.print(empDTO.getName()); %></td>
      <td><% out.print(contactDTO.getExtension()); %></td>
      <td><% out.print(contactDTO.getMobile()); %></td>
      <td><% out.print(postDTO.getPostName()); %></td>
      <td>
      <%
      	if (bossDTO != null) {
			out.print(bossDTO.getName());
      	}
      %>
      </td>
    </tr>
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
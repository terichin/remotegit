<%@ page contentType="text/html; charset=Windows-31J"
         import="java.util.*"
         import="control.dto.*" %>
<html>
<head>
<title>���[�U���</title>
</head>

<body>
<center>

  <h1> ���[�U��� </h1>
  <br><hr><br>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>����</th>
      <th>�����ԍ�</th>
      <th>�g�єԍ�</th>
      <th>����</th>
      <th>��i����</th>
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
    <input type="submit" value="���j���[�֖߂�">
  </form>

</center>
</body>
</html>
<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>PrintAllEmployeeInfo.jsp</title></head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>����</th>
<th>�p�X���[�h</th>
<th>�����ԍ�</th>
<th>�g�єԍ�</th>
</tr>

<c:forEach items="${employeeinfo_list}" var="dto">
  <tr>
    <td>${dto.id}</td>
    <td>${dto.userName}</td>
    <td>${dto.password}</td>
    <td>${dto.extension}</td>
    <td>${dto.mobile}</td>
  </tr>
</c:forEach>

</table>
</body>
</html>
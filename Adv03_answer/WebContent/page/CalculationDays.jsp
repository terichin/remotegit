<%@ page contentType="text/html; charset=Windows-31J" %>
<%@ page import="java.util.*" %>

<%
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_YEAR);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		int dayCount = lastDay - today;
%>

<html>
<head><title>CalculationDays.jsp</title></head>
<body>
<h2>
<%
		out.println("¡”N‚Í‚ ‚Æ" + dayCount + "“ú‚Å‚·B");
%>
</h2>
</body>
</html>
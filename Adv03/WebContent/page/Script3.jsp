<%@ page contentType="text/html; charset=Windows-31J" %>
<%-- 変数countを定義します --%>
<%! private int count = 0; %>
<%!
    private int getCount() {
        return count;
    }
%>
<%!
    private void addCount() {
        count++;
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ScriptSample</title></head>
<body>
アクセス回数：<%= getCount() %>
<% addCount(); %>
</body>
</html>
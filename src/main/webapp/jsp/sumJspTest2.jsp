<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<% int num = Integer.parseInt(request.getParameter("parameter1"));
	   int num2 = Integer.parseInt(request.getParameter("parameter2"));
	   int res = num * num2;
		
	%>
	result = <%=res %>
</body>
</html>
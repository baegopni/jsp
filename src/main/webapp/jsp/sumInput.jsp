<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="post">
	첫번째 숫자 : <input type="text" name="start"><br>
	두번째 숫자 : <input type="text" name="end"><br>
	<input type="submit" value="전송">
	
	</form>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		
	})

</script>
</head>

<body>
	더하기 <input type="radio" name="mod" value="더하기">
	곱하기 <input type="radio" name="mod" value="곱하기">
	<br><br>
		
	<h2>더하기</h2>
	<form action="<%=request.getContextPath() %>/jsp/sumJspTest.jsp" method="get">
		<input type="text" name="parameter1" value="num1">
		<input type="text" name="parameter2" value="num2">
		<input type="submit" value="전송">
	</form>
	
	<h2>곱하기</h2>
	<form action="<%=request.getContextPath() %>/jsp/sumJspTest2.jsp" method="get">
		<input type="text" name="parameter1" value="num1">
		<input type="text" name="parameter2" value="num2">
		<input type="submit" value="전송">
	</form>
	

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 스클립틀릿, 표현식 --> jstl, el --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	times tables.jsp <br>
	
	<table border="1">
		<c:forEach begin="2" end="9" var="i">
		<tr>
			<c:forEach begin="1" end="9" var="j">
				<td>${i} * ${j} = ${i*j}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
</body>

</html>
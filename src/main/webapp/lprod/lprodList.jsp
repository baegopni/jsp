<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

	<table>
		<tr>
			<th>LPROD_ID</th>
			<th>LPROD_GU</th>
			<th>LPROD_NM</th>
		</tr>
		
		<c:forEach items="${lprodList }" var="lprod">
		<tr>
			<td>${lprod.lprodId }</td>
			<td>${lprod.lprodGu }</td>
			<td>${lprod.lprodNm }</td>	
		</tr>
		</c:forEach>
	</table>

</body>
</html>
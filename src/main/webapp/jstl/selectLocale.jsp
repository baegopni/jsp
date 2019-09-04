<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<script src="../js/jquery-3.4.1.min.js"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
$(document).ready(function(){
		$("#locale").val('${locale}').prop("selected", true);
});
</script>

</head>


<body>

<form id="frm" action="${cp }/selectLocale" method="get">
	<select onchange="this.form.submit()" name="locale" id="locale">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="zh">中国话</option>
	</select>
	<!--  <input type="submit" id="select" value="전송"/> -->
	
</form>
	<fmt:setLocale value="${locale}"/>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg}"/><br>

</body>


</html>
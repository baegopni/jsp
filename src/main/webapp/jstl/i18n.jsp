<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>jstl fmt</h2>

<c:set var="userId" value="brown"/>
<%--
	<fmt:bundle> : 출력할 메시지를 담고있는 리소스 번들 지정
					<fmt:message>태그가 bundle 태그 안에 기술
	<fmt:message> : 출력하고자 하는 code
	<fmt:param> : message에 파라미터가 있는 경우 전달
--%>

	<fmt:bundle basename="kr.or.ddit.msg.message">
		<%--message_국가_언어.properties 에서 다떼고 message까지만 기술하면됨 --%>
		GREETING : <fmt:message key="GREETING"/> <br>
		VISITOR : <fmt:message key="VISITOR">
				  	<fmt:param value="${userId }"/>
				  </fmt:message>
	</fmt:bundle> 
	
	<br><br>
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.message">
		GREETING : <fmt:message key="GREETING"/><br>
		VISITOR : <fmt:message key="VISITOR">
				  	<fmt:param value="${userId }"/>
				  </fmt:message>
	</fmt:bundle> 
	
	<br><br>
	<fmt:setLocale value="zh"/>
	<fmt:bundle basename="kr.or.ddit.msg.message">
		GREETING : <fmt:message key="GREETING"/><br>
		VISITOR : <fmt:message key="VISITOR">
				  	<fmt:param value="${userId }"/>
				  </fmt:message>
	</fmt:bundle> 


<h2>fmt setBundle</h2>
	<fmt:setLocale value="ko"/>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
			<%-- 이런 방식으로하면 굳이 번들안에다가 안넣어도됨--%>
			GREETING : <fmt:message key="GREETING" bundle="${msg }"/><br>
			VISITOR : <fmt:message key="VISITOR" bundle="${msg }">
				  		<fmt:param value="${userId }"/>
					  </fmt:message>
					  
<h2>fmt number</h2>
	<c:set var="num" value="1000000.100"/>
		<fmt:setLocale value="ko"/>
		ko : <fmt:formatNumber value="${num }"/><br>
		
		<fmt:setLocale value="de"/>
		de : <fmt:formatNumber value="${num }" var="deNum"/>${deNum }<br>
		<%-- var이 있으면 결과값을 var 속성에 넣는다. -> 즉 ${deNum } 처럼 입력해줘야 출력됨 --%>
		
		
<h2>fmt parseNumber</h2>
	<fmt:setLocale value="ko"/>
	<%-- 문자열을 숫자로 변환 --%>
	<fmt:parseNumber value="1,000,000" var="koNum"/>
	no pattern parseNumber : ${koNum } <br>
	

<h2>fmt formatDate</h2>
	<%--데이트 객체를 포맷팅된 문자열로 변환 --%>
	${dt }<br>
	formatDate : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>
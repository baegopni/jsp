<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- 파라미터를 받는다
		input tag의 name 속성이 파라미터 이름
		userId, password
		String userId = request.getParameter("userId");
		//String userId = request.getParameter(userId); 위에와 다르다
		
		String password = request.getPrameter("password");
	-->
	<%
		//post방식에서 한글 안깨지게 하는 방법▼
		//parameter 관련 메소드를 호출하기전에 호출해야 인코딩 설정이 적용된다.
		request.setCharacterEncoding("utf-8");
	%>
	request method : <%=request.getMethod() %><br>
	
	<%
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
	%>
	
	<h2>request.getParameter()</h2>
	parameter userId : <%=userId %><br>
	parameter password : <%=password %><br>
	
	
	<h2>request.getParameterValues()</h2>
	<%
	  String[] userIds = request.getParameterValues("userId");
	  for(String str:userIds) {%>
		parameter userId : <%=str %><br>
	<%} %>
	
	
	<h2>request.getParameterMap()</h2>
	<%
		Map<String, String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		for(String key:keySet){ %>
			<%= key %> : <%= Arrays.toString(requestMap.get(key)) %><br>
	<% }%>
	
	
	<h2>request.getParameterNames()</h2>
	<%
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
	%>
		<%=parameterName %><br>
	<%} %>
		
</body>

</html>
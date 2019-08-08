<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%--1. userdao 선언
		2. getUserList() 호출
		3. 호출결과(List<UserVo>)를 for loop를 통해 tr태그를 반복 생성
	 --%>
	 
	<table>
		<tr>
			<th>이름</th>
		</tr>
		
		<%
					IUserDao userDao = new UserDao();
						List<User> list = userDao.getUserList();
						for(int i = 0; i<list.size(); i++){
				%>
		<tr><td><%= list.get(i).getUserNm() %></td></tr>
		<%} %>
		
	</table>
</body>

</html>
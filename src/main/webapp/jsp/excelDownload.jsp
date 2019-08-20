<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
	response.setHeader("Content-Disposition", "attachement; filename=line.xls");
	IUserService userService = new UserService();
	List<User> list = userService.getUserList();
%>
	<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<%
			for(User userVo : list){
		%>
			<tr>
				<td><%=userVo.getUserNm() %></td>
				<td></td>
			</tr>
		<%} %>
	</table>
</body>

</html>
<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/commonJsp/basicLib.jsp"%>

<script>
	$(document).ready(function(){
		$('.lprodTr').on('click', function(){
			
			//input태그에 값 설정
			var dataValue = $(this).data("lprod_gu");
			$('#lprod_gu').val(dataValue);
			
			//form 태그이용 전송
			$('#frm').submit();
		});
	});
</script>
</head>

<body>
<form id="frm" action="${cp }/prodList" method="get">
	<input type="hidden" id="lprod_gu" name="lprod_gu"/>
</form>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">

			<!-- left -->
			<%@ include file="/commonJsp/left.jsp"%>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>LPROD_ID</th>
									<th>LPROD_GU</th>
									<th>LPROD_NM</th>
								</tr>

<%--								<%
									List<User> userList = (List<User>) request.getAttribute("userList");
									for (User user : userList) { %>
								<tr>
									<td><%=user.getUserId()%></td>
									<td><%=user.getUserNm()%></td>
									<td></td>
									<td></td>
								</tr>

								<% } %>
--%>								

								<%-- ★★위에 for(User user : userList) 와 동일하다 ★★--%>
								<c:forEach items="${lprodList }" var="lprod">
								<tr class="lprodTr" data-lprod_Gu="${lprod.lprod_Gu }">					
									<td>${lprod.lprod_Id }</td>
									<td>${lprod.lprod_Gu }</td>
									<td>${lprod.lprod_Nm }</td>	
								</tr>
								</c:forEach>
							</table>
						</div>


						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

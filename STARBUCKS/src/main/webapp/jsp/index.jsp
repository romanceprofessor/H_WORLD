<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스타벅스</title>
	</head>
	<body>
		<div>
			<h1>스타벅스에 오신걸 환영합니다!</h1>
		</div>
		<c:if test="${ null eq sessionScope.userName }">
			<div>
				<span style="color:red">${msg }</span>
			</div>
			<div>
				<form id="frmLogin" method="post" action="<c:url value='/login.star'/>">
					<input type="text" name="userId" placeholder="아이디"><br>
					<input type="text" name="userPw" placeholder="암호"><br>
					<input type="button" id="btnLogin" value="로그인">
				</form>
			</div>
		</c:if>
		<c:if test="${ null ne sessionScope.userName }">
			<div>
				<span>${userName }님 로그인중</span>
			</div>
			<div>
				<ul>
					<li><a href="<c:url value='/starbucks/menu.star'/>">메뉴</a></li>
				</ul>
			</div>
		</c:if>
		<script>
			document.getElementById('btnLogin').addEventListener('click',function(){
				document.getElementById('frmLogin').submit();
			});
		</script>
		
		
		
		
		
		
		
	</body>
</html>
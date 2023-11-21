<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div>
			<ul>
				<li><a href="<c:url value='/starbucks/menu.star'/>">메뉴</a></li>
			</ul>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String menu = (String)request.getAttribute("menu");
	int amount = (Integer)request.getAttribute("amount");
	String sum = (String)request.getAttribute("sum");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스타벅스</title>
	</head>
	<body>
		<div>
			<ul>
				<li><a href="http://localhost/">첫화면으로</a></li>
			</ul>
		</div>
		<div>
			<h2>고객님 주문하신 음식이 나왔습니다.</h2>
		</div>
		<div>
			<h3>결제하실 금액은 <%=sum %>원 입니다.</h3>
		</div>
		<div>
		<%
			for (int i = 0 ; i < amount ; i++) {
		%>
			<span>
				<img style="width:10%" src="http://localhost/images/starbucks/<%=menu %>.jpg">
			</span>
		<%
			}
		%>
		</div>
	</body>
</html>
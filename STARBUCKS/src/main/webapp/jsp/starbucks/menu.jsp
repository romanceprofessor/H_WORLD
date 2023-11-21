<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스타벅스</title>
		<link href="http://localhost/css/starbucks.css" rel="stylesheet">
	</head>
	<body>
		<div>
			<span>
				<img class="menuImg" data-menu="cake" src="http://localhost/images/starbucks/cake.jpg">
			</span>
			<span>
				<img class="menuImg" data-menu="coffee" src="http://localhost/images/starbucks/coffee.jpg">
			</span>
			<span>
				<img class="menuImg" data-menu="sandwich" src="http://localhost/images/starbucks/sandwich.jpg">
			</span>
		</div>
		<div>
			<span>
				<input type="number" id="count" value="1">개
			</span>
		</div>
		<div>
			<span>
				<input type="button" id="btnOrder" value="주문하기">
			</span>
		</div>
		<form id="orderForm" method="post" action="http://localhost/starbucks/order.star">
			<input type="hidden" id="menu" name="menu">
			<input type="hidden" id="amount" name="amount">
		</form>
		<script src="http://localhost/js/starbucks_menu.js"></script>
	</body>
</html>
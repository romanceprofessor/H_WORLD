<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Hello Index!</title>
	</head>
	<body>
		<div>
			Hello Index!
		</div>
		<div>
			<input type="button" id="btnCalc" value="계산기">
		</div>
		<script>
			document.getElementById('btnCalc')
			.addEventListener('click',function(){
				location.href = 'http://localhost/calc/show.do';
			});
		</script>
	</body>
</html>
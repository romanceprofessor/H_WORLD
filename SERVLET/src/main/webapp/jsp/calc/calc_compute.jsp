<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>계산기</title>
	</head>
	<body>
		<div>
			<form id="frmCalc" method="post" action="http://localhost/calc/compute.do">
				<input type="number" name="num1" id="num1" placeholder="숫자1"><br>
				<input type="radio" name="operator" value="add" checked>+
				<input type="radio" name="operator" value="del">-
				<input type="radio" name="operator" value="mul">*
				<input type="radio" name="operator" value="div">/
				<br>
				<input type="number" name="num2" id="num2" placeholder="숫자2"><br>
				<input type="button" id="btnConfirm" value="확인">
			</form>
		</div>
		<script>
			document.getElementById('btnConfirm')
			.addEventListener('click',function(){
				let num1 = document.getElementById('num1').value;
				if ('' == num1) {
					alert('숫자1은 필수입력입니다.');
					document.getElementById('num1').focus();
					return;
				}
				
				document.getElementById('frmCalc').submit();
			});
		</script>
	</body>
</html>
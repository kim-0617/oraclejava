<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RSP</title>
</head>
<body>
	<form action="../game.mvc" method="post">
		가위 / 바위 / 보 <br />
		<select name="you">
			<option value="1">가위</option>
			<option value="2">바위</option>
			<option value="3">보</option>
		</select>
		
		<input type="submit" value="선택" />
	</form>
</body>
</html>
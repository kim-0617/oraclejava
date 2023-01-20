<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<form action="BoardDeleteAction.do" method="post" class="insert__form">
			<table>
				<caption>글 삭제</caption>
				<tr>
					<th>번호</th>
					<td>
						${no}<input readonly type="hidden" name="no" autofocus required ="required" value="${no}" />
					</td>
				</tr>
								
				<tr>
					<th>비밀번호</th>
					<td>
						<input style="margin-bottom: 10px" type="password" name="password" required="required"  /> <br />
						* 처음 글을 작성 시 입력한 비밀번호를 동일하게 재입력 해주세요.
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="custom-btn btn-1" type="submit" value="삭제" />
						<a class="custom-btn btn-1" href="BoardLost.do">취소</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
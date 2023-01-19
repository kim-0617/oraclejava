<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<form action="BoardInsertAction.do" method="post" class="insert__form">
			<table>
				<caption>글 쓰기</caption>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" autofocus required="required" />
					</td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" required="required"  />
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" required="required"  />
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content" required="required" ></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="custom-btn btn-1" type="submit" value="완료" />
						<a class="custom-btn btn-1" href="BoardList.do">취소</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
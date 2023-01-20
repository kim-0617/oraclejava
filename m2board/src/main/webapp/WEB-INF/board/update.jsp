<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<form action="BoardUpdateAction.do" method="post" class="insert__form">
			<table>
				<caption>글 수정</caption>
				<tr>
					<th>번호</th>
					<td>
						${boardDto.no}<input readonly type="hidden" name="no" autofocus required ="required" value="${boardDto.no}" />
					</td>
				</tr>				
				
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" autofocus required="required" value="${boardDto.title}" />
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content" required="required" >${boardDto.content}</textarea>
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
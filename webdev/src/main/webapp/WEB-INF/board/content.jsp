<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<table style="width:600px">
			<caption>글 ${boardDto.no}</caption>
			<tr>
				<th>글 번호</th>
				<td>${boardDto.no}</td>
			</tr>
				
			<tr>
				<th>제목</th>
				<td>${boardDto.title}</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>${boardDto.name}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardDto.content}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${boardDto.writeday}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardDto.readcount}</td>
			</tr>
		</table>
		<div class="btn__wrap">
			<a href="BoardList.do" class="custom-btn btn-1">목록</a>
			<a href="BoardInsert.do" class="custom-btn btn-1">글 쓰기</a>
			<a href="BoardUpdate.do?no=${boardDto.no}" class="custom-btn btn-1">글 수정</a>
			<a href="BoardDelete.do?no=${boardDto.no}" class="custom-btn btn-1">글 삭제</a>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
<script type="text/javascript">
	function confirm_delete() {
		if(!confirm("정말로 삭제할까요?")) {
			return;	
		}
		location.href='BoardDeleteAction.do?no=${boardDto.no}';
		
	}
</script>
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
				<td>${boardDto.memberDto.name} (${boardDto.memberDto.id})</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardDto.content}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${boardDto.regdate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardDto.readcount}</td>
			</tr>
		</table>
		<div class="btn__wrap">
			<a href="BoardList.do" class="custom-btn btn-1">목록</a>
			<a href="BoardInsert.do" class="custom-btn btn-1">글 쓰기</a>
			<c:if test="${boardDto.memberDto.id == sessionScope.userInfo.id}">			
				<a href="BoardUpdate.do?no=${boardDto.no}" class="custom-btn btn-1">글 수정</a>
				<a href="javascript:;" onclick="confirm_delete();" class="custom-btn btn-1">글 삭제</a>
			</c:if>
		</div>
	</div>
</body>
</html>
<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Long no = Long.parseLong(request.getParameter("no"));
	BoardDao boardDao = BoardDao.getInstance();
	
	boolean result = boardDao.updateReadCount(no);
	
	if(!result) {
%>
	<script>
		alert("해당하는 글이 존재하지 않습니다.");
		location.href="list.jsp";
	</script>
<%
		return;
	}
	
	BoardDto boardDto = boardDao.getBoardView(no);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" href="../css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<table style="width:600px">
			<caption>글 <%=boardDto.getNo()%></caption>
			<tr>
				<th>글 번호</th>
				<td><%=boardDto.getNo()%></td>
			</tr>
				
			<tr>
				<th>제목</th>
				<td><%=boardDto.getTitle()%></td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td><%=boardDto.getName()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=boardDto.getContent()%></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=boardDto.getWriteday()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=boardDto.getReadcount()%></td>
			</tr>
		</table>
		<div class="btn__wrap">
			<a href="list.jsp" class="custom-btn btn-1">목록</a>
			<a href="insert.jsp" class="custom-btn btn-1">글 쓰기</a>
			<a href="update.jsp?no=<%=boardDto.getNo()%>" class="custom-btn btn-1">글 수정</a>
			<a href="delete.jsp?no=<%=boardDto.getNo()%>" class="custom-btn btn-1">글 삭제</a>
		</div>
	</div>
</body>
</html>
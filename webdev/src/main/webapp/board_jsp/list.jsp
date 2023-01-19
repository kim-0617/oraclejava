<%@page import="board.model.BoardDao"%>
<%@page import="board.model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardDao boardDao = BoardDao.getInstance();
	System.out.println("boardDao hashcode : " + boardDao.hashCode());
	List<BoardDto> list = boardDao.getBoardList();
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
<link rel="stylesheet" href="../css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<table style="width : 600px">
			<caption>게시판 리스트</caption>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<%for(BoardDto dto : list) {%>
				<tr>
					<td><%=dto.getNo()%></td>
					<td><a href="content.jsp?no=<%=dto.getNo()%>"><%=dto.getTitle()%></a></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getWriteday()%></td>
					<td style="text-align : right"><%=dto.getReadcount()%></td>
				</tr>
			<%}%>
		</table>
		<a href="insert.jsp" class="custom-btn btn-1">글 쓰기</a>
	</div>
</body>
</html>
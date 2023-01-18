<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Long no = Long.parseLong(request.getParameter("no"));
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto boardDto = boardDao.getBoardView(no);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="../css/board.css" type="text/css" />
</head>
<body>
	<div class="table__wrap">
		<form action="update_action.jsp" method="post" class="insert__form">
			<table>
				<caption>글 수정</caption>
				<tr>
					<th>번호</th>
					<td>
						<%=boardDto.getNo()%><input readonly type="hidden" name="no" autofocus required ="required" value="<%=boardDto.getNo()%>" />
					</td>
				</tr>
				
				
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" autofocus required="required" value="<%=boardDto.getTitle()%>" />
					</td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" required="required" value="<%=boardDto.getName()%>"  />
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
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content" required="required" ><%=boardDto.getContent()%></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="custom-btn btn-1" type="submit" value="완료" />
						<a class="custom-btn btn-1" href="list.jsp">취소</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
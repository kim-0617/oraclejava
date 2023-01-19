<%@page import="board.model.BoardDao"%>
<%@page import="board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setNo(no);
	boardDto.setPassword(password);
	
	BoardDao boardDao = BoardDao.getInstance();
	System.out.println("boardDao hashcode : " + boardDao.hashCode());
	boolean result = boardDao.deleteBoard(boardDto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Action</title>
</head>
<body>
	<script type="text/javascript">
		<%if(result){%>
			alert("글이 삭제되었습니다.");
			location.href="list.jsp";
		<%}else{%>
			alert("비밀번호가 틀립니다.");
			location.href="javascript:history.back();";
		<%}%>
	</script>
</body>
</html>
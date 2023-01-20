<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js"></script>
<script type="text/javascript">
	function goUpdate() {
		const f = document.myform;
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		
		f.submit();
	}
</script>
</head>
<body>
	<div class="table__wrap">
		<form name="myform" action="BoardInsertAction.do" method="post" class="insert__form">
			<table>
				<caption>글 쓰기</caption>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" style="width:645px;" autofocus required="required" />
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" style="width:645px;" name="content" id="content" required="required" ></textarea>
						<script type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator.createInIFrame({
							 oAppRef: oEditors,
							 elPlaceHolder: "content",
							 sSkinURI: "se2/SmartEditor2Skin.html",
							 fCreator: "createSEditor2"
							});
						</script>						
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="custom-btn btn-1" type="button" value="완료" onClick="goUpdate();" />
						<a class="custom-btn btn-1" href="BoardList.do">취소</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
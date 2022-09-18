<%@page import="model.BoardBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div table {
	width: 700;
	border: 1px solid #444444;
	background-color: skyblue;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<div align="center">

		<h2>전체 게시글 보기</h2>
		<table>
			<tr height="40">
				<td align="right" colspan="5"><input type="button" value="글쓰기"
					onclick="location.href='write.do'"></td>
			</tr>
			<tr height="40">
				<td width="50" align="center">번호</td>
				<td width="320" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>
			${list}
		</table>
		${page}
	</div>
</body>
</html>
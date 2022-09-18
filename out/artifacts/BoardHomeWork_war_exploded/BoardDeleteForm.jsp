<%@ page import="model.BoardDAO" %>
<%@ page import="model.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 삭제</title>
</head>
<%
    //InfoServlet 에서 작동하고 이건 지울것
    BoardDAO bdao = new BoardDAO();

    int num = Integer.parseInt(request.getParameter("num"));
    BoardBean bean = bdao.getOneUpdateBoard(num);
%>
<body>
<br><br><div align="center" class="container">
    <form action="delete.do" method="post">
        <table width="600" border="1" bgcolor="skyblue">
            <tr height="40">
                <td width="120" align="center">작성자</td>
                <td width="180" align="center"><%=bean.getWriter()%></td>
                <!-- InfoServlet에서 받을 경우
                <td width="180" align="center">${bean.writer}</td> -->
                <td width="120" align="center">작성일</td>
                <td width="180" align="center"><%=bean.getReg_date()%></td>
                <!-- <td width="180" align="center">${bean.reg_date}</td> -->
            </tr>
            <tr height="40">
                <td width="120" align="center">제목</td>
                <td width="180" align="center"><%=bean.getSubject()%></td>
                <!-- <td width="180" align="center">${bean.subject}</td> -->
            </tr>
            <tr height="40">
                <td width="120" align="center">패스워드</td>
                <td align="left" colspan="3"><input type="password" name="password"></td>
            </tr>
            <tr height="40">
                <td align="center" colspan="4"><input type="hidden" name="num" value="<%=num%>"> <!--${bean.num}-->
                    <input type="submit" value="글삭제">&nbsp;&nbsp;<input type="button" onclick="location.href='list.do'" value="목록보기">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

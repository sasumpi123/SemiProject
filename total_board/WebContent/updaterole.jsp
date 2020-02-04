<%@page import="com.dto.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html, charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MemberDto dto = (MemberDto)request.getAttribute("select");
	%>

	<h1>회원등급 변경</h1>
	<form action="member.do" method="post">
		<input type="hidden" name="command" value="updateroleres"> <input
			type="hidden" name="mbno" value="<%=dto.getMbno()%>">

		<table border="1">
			<tr>
				<th>번호</th>
				<th><%=dto.getMbno()%></th>
			</tr>
			<tr>
				<th>등급</th>
				<td><select name="role">
						<option value="USER">일반회원</option>
						<option value="MANAGER">우수회원</option>
						<option value="ADMIN"> 관리자</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="변경"> <input
					type="button" value="취소" onclick="location.href='member.do?command=userselectenabled'"></td>
			</tr>
		</table>
	</form>

</body>
</html>
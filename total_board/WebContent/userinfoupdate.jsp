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

<%
	MemberDto dto = new MemberDto();
	dto = (MemberDto) session.getAttribute("dto");
%>
<body>

	<h1>회원정보 변경</h1>
	<form action="member.do" method="post">
	<input type="hidden" name="command" value="userinfoupdateres">
	<input type="hidden" name="mbno" value="<%=dto.getMbno()%>">

		<table border="1">
			<tr>
				<th>아이디</th>
				<th><%=dto.getMbid()%></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="text" name="mbpw" value="<%=dto.getMbpw()%>">
				</th>
			</tr>
			<tr>
				<th>주소</th>
				<th><input type="text" name="mbaddr"
					value="<%=dto.getMbaddr()%>"></th>
			</tr>
			<tr>
				<th>전화번호</th>
				<th><input type="text" name="mbphone"
					value="<%=dto.getMbphone()%>"></th>
			</tr>
			<tr>
				<th>이메일</th>
				<th><input type="text" name="mbemail"
					value="<%=dto.getMbemail()%>"></th>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="변경">
				<input type="button" value="취소" onclick="location.href='member.do?command=userinfo'"></td>
			</tr>
		</table>
	</form>

</body>
</html>
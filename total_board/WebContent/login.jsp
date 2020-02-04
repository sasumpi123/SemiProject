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
<script type="text/javascript">
function forgot(){
	open("forgot.do?command=forgotinfo","","width=600,height=400");
}
</script>
</head>
<body>

	<form action="member.do" method="post">
		<input type="hidden" name="command" value="login">
		<table border="1">
			<col width="100">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='member.do?command=regist'">
					<input type="button" value="비밀번호 찾기" onclick="forgot()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
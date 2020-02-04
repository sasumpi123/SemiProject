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
	<form action="forgot.do">
		<input type="hidden" id="chk" name="command" value="forgotpw">
			아이디 : <input type="text" name="mbid" value="" required="required"><br>
			이름 : <input type="text" name="mbname" value="" required="required"><br>
			이메일 : <input type="text" name="mbemail" value="" required="required"><br>
		<input type="submit" value="찾기">
	</form>
</body>
</html>
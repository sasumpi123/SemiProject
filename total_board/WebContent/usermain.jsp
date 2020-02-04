<%
	//브라우저가 캐시에 화면(응답된 도큐먼트) 저장하지 않도록 설정 
	response.setHeader("Pragma", "no-cache");				// http 1.0
	response.setHeader("Cache-control", "no-store");		// http 1.1
	response.setHeader("Expires", "0");						// proxy server
%>
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
		MemberDto dto = (MemberDto) session.getAttribute("dto");
	if(dto==null){
		pageContext.forward("index.jsp");
	}
	%>

	<h1><%=dto.getMbname()%>님 환영합니다.</h1>
	
	
	<a href="member.do?command=userinfo">내정보</a>
	<a href="member.do?command=userdelete">회원탈퇴</a>
	<a href="member.do?command=logout">로그아웃</a>
 	

</body>
</html>
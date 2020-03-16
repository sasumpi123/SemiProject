<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="http://localhost:8787/MyAnimals/assets/css/main.css" />
	<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />



</head>
<body>

	
 				<header id="header">
 				<c:choose>
				<c:when test="${memberDto.member_role eq 'USER' || memberDto.member_role eq 'CENTER'}">
				<a href="/MyAnimals/main.jsp" class="logo"><strong>MyAnimals</strong></a>
				   <ul class="icons">
				      <li><button onclick="location.href='/MyAnimals/member.do?command=myinfo'">내정보</button></li>
				      <li><button onclick="location.href='/MyAnimals/letter.do?command=receiveList&id=${memberDto.member_id}'">쪽지함</button></li>
				      <li><a href="/MyAnimals/shop.do?command=buylistform" class="button big">결제목록</a></li>
				      <li><button onclick="location.href='/MyAnimals/member.do?command=logout'">로그아웃</button></li>
				   </ul>
				</c:when>
				<c:when test="${memberDto.member_role eq 'ADMIN' }">
				   <ul class="icons">
				      <li><button onclick="location.href='/MyAnimals/member.do?command=selectall'">회원전체조회</button></li>
				      <li><button onclick="location.href='/MyAnimals/member.do?command=volunteer'">User조회</button></li>
				      <li><button onclick="location.href='/MyAnimals/member.do?command=centerallinfo'">Center조회</button></li>
				      <li><button onclick="location.href='/MyAnimals/member.do?command=updateroleform'">등급조정</button></li>
				      <li><button onclick="location.href='/MyAnimals/member.do?command=logout'">로그아웃</button></li>
				   </ul>
				</c:when>
				<c:otherwise>
				<a href="/MyAnimals/main.jsp" class="logo"><strong>MyAnimals</strong></a>
				   <ul class="icons">
						<li><button onclick="location.href='/MyAnimals/member.do?command=loginform'">로그인</button></li>
						<li><button onclick="location.href='/MyAnimals/member.do?command=registselectres'">회원가입</button></li>
					</ul>
				</c:otherwise>
				</c:choose>
				</header>
				

</body>
</html>
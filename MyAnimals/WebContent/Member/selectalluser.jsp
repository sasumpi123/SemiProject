<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<%@ include file="/form/header.jsp"%>
				<!-- Header -->
				<!-- 				<header id="header">
					<a href="index.html" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a>
						</li>
						<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
					</ul>
				</header> -->


				<!-- Section -->
				<section>
					<header class="major">
						<h2>전체 회원 조회</h2>
					</header>
					<div class="features">
						<table border="1">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							<col width="auto">
							
							<tr>
								<th>탈퇴여부</th>
								<th>등급</th>
								<th>닉네임</th>
								<th>아이디</th>
								<th>이름</th>
								<th>생일</th>
								<th>성별</th>
								<th>핸드폰번호</th>
								<th>이메일</th>
								<th>주소</th>
								<th>가입날짜</th>
							</tr>


							<c:choose>
								<c:when test="${empty memberList }">
									<tr>
										<td colspan="11">----------유저 정보가 없습니다----------</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${memberList }" var="memberDto">
										<tr>
											<td>${memberDto.member_delflag }</td>
											<td>${memberDto.member_role }</td>
											<td>${memberDto.member_nickname }</td>
											<td>${memberDto.member_id }</td>
											<td>${memberDto.member_name }</td>
											<td>${memberDto.member_birth }</td>
											<td>${memberDto.member_gender }</td>
											<td>${memberDto.member_phone }</td>
											<td>${memberDto.member_email }</td>
											<td>${memberDto.member_address }</td>
											<td>${memberDto.member_regdate }</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						
						</table>

					</div>
				</section>

				<!-- Section -->


			</div>
		</div>

		<!-- 사이드바 시작  -->
		<%@ include file="/form/footer.jsp"%>

		<!-- 사이드바 끝 -->
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>
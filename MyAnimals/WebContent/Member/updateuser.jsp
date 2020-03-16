<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<h2>회원정보 수정</h2>
					</header>
					<div class="features">
						<form action="/MyAnimals/member.do" method="post">
							<input type="hidden" name="command" value="updateuserres">
							<input type="hidden" name="id" value="${memberDto.member_id }" />
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
									<th>이름</th>
									<td><input type="text" name="name" readonly="readonly"
										value="${memberDto.member_name }"></td>
								</tr>
								<tr>
									<th>아이디</th>
									<td><input type="text" name="id" readonly="readonly"
										value="${memberDto.member_id }"></td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td><input type="password" name="pw"
										value="${memberDto.member_pw }"></td>
								</tr>
								<tr>
									<th>비밀번호 확인</th>
									<td><input type="text" name="pwpw"
										value="${memberDto.member_pw }"></td>
								</tr>
								<tr>
									<th>닉네임</th>
									<td><input type="text" name="nickname"
										value="${memberDto.member_nickname }"></td>
								</tr>
								<tr>
									<th>생일</th>
									<td><input type="text" name="birth" readonly="readonly"
										value="${memberDto.member_birth }"></td>
								</tr>
								<tr>
									<th>이메일</th>
									<td><input type="text" name="email" readonly="readonly"
										value="${memberDto.member_email }"></td>
								</tr>
								<tr>
									<th>성별</th>
									<td><input type="text" name="gender" readonly="readonly"
										value="${memberDto.member_gender }"></td>
								</tr>
								<tr>
									<th>주소</th>
									<td><input type="text" name="address"
										value="${memberDto.member_address }"></td>
								</tr>
								<tr>
									<th>핸드폰</th>
									<td><input type="text" name="phone"
										value="${memberDto.member_phone }"></td>
								</tr>
								<tr>
									<th>가입 날짜</th>
									<td><input type="text" name="regdate" readonly="readonly"
										value="${memberDto.member_regdate }"></td>
								</tr>
								<tr>
									<th>등급</th>
									<td><input type="text" name="role" readonly="readonly"
										value="${memberDto.member_role }"></td>
								</tr>
								<tr>
									<td><input type="submit" value="수정"> <input
										type="button" value="취소"
										onclick="location.href='/MyAnimals/member.do?command=myinfo'">
									</td>
								</tr>
							</table>
						</form>

					</div>
				</section>

				<!-- Section -->


			</div>
		</div>

		<!-- 사이드바 시작  -->
		<%@ include file="../form/footer.jsp"%>

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
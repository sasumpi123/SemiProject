<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.member.dto.MemberDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />
</head>

<script type="text/javascript">
	function updaterolechk() {
		if (confirm("정말 변경 하시겠습니까??") == true) { //확인
			document.getElementById("popuprole").submit();

			opener.location.href = 'main.jsp';
			self.close();
		} else { //취소

			return false;
			self.close();
		}

	}
</script>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

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
						<h1>등급조정</h1>
					</header>
					<div class="features">
						<form action="/MyAnimals/member.do" method="post" id="popuprole">
							<input type="hidden" name="command" value="updaterolepopup">
							<input type="hidden" name="id" value="${memberDto.member_id }">
							<table>
								<tr>
									<th>아이디</th>
									<td>${memberDto.member_id }
									<td>
									<td><select name="selectrole">
											<option value="USER"
												${memberDto.member_role == "USER" ? "selected" : ""}>USER</option>
											<option value="CENTER"
												${memberDto.member_role == "CENTER" ? "selected" : ""}>CENTER</option>
											<option value="ADMIN"
												${memberDto.member_role == "ADMIN" ? "selected" : ""}>ADMIN</option>
									</select></td>
								</tr>
							</table>
						</form>
						<input type="button" value="변경" onclick="updaterolechk()">
					</div>
				</section>

				<!-- Section -->


			</div>
		</div>

		<!-- 사이드바 시작  -->


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
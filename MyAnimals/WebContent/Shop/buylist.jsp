<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<h2>결제 내역</h2>
					</header>
					<div class="features">
	<table border="1">
		
		<tr>
			<th>아이디</th>
			<th>상품이름</th>
			<th>상품내용</th>
			<th>구매수량</th>
			<th>결제금액</th>
		</tr>
	<c:choose>
		<c:when test="${empty orderList }">
				<tr>
					<td colspan="5" align="center">- - - - - - - - - -구매내역이 없습니다- - - - - - - - - -</td>
				</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${orderList }" var="orderDto">
				<tr>
					<td>${memberDto.member_id}</td>
					<td><a href="shop.do?command=detail&shop_seq=${orderDto.shop_seq }">${orderDto.order_stuff }</a></td>
					<td>${orderDto.order_content }</td>
					<td>${orderDto.order_count }</td>
					<td>${orderDto.order_buymoney }원</td>
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
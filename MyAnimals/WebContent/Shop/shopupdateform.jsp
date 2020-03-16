<%@page import="com.member.dto.MemberDto"%>
<%@page import="com.shop.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
<%
	ShopDto shopDto = (ShopDto)request.getAttribute("shopDto");
%>
	

	<head>
		<title>MyAnimals</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<script type="text/javascript">
		function inNumber() {
			if (event.keyCode < 48 || event.keyCode > 57) {
				event.returnValue = false;
			}
		}
	</script>

	<body class="is-preload">

		<!-- Wrapper -->
		<div id="wrapper">

			<!-- Main -->
			<div id="main">
				<div class="inner">

					<!-- Header -->
					<header id="header">
						<a href="index.html" class="logo"><strong>후원물품</strong></a>
						<ul class="icons">
						</ul>
					</header>
					<section id="banner">
						<form action="/MyAnimals/shopinsert.do" method="post" enctype="multipart/form-data">
							<input type="hidden" name="command" value="updateres">
							<input type="hidden" name="shop_seq" value="<%=shopDto.getShop_seq()%>">
							
							<div class="row gtr-uniform">
								<div class="col-12">
									<span class="image object"> <img src="${shopDto.shop_photo}" style="width: 500px; height: 400px;"/></span>
								</div>
								<div class="col-6 col-12-xsmall">
									<input type="text" name="shop_name" id="demo-name" value="<%=shopDto.getShop_name() %>" placeholder="Name" required="required"/>
								</div>
								<div class="col-12">
									<select name="shop_kind" id="demo-category" required="required">
										<option>종류</option>
										<option>Manufacturing</option>
										<option>Shipping</option>
										<option>Administration</option>
										<option>Human Resources</option>
									</select>
									
								</div>
								<div class="col-6 col-12-xsmall">
									<input type="text" name="shop_price" id="demo-email" value="<%=shopDto.getShop_price() %>" required="required" placeholder="가격" onkeypress="inNumber();" />
								</div>
								<div class="col-6 col-12-xsmall">
									<input type="text" name="shop_quantity" required="required" id="demo-email" value="<%=shopDto.getShop_quantity() %>" placeholder="수량" onkeypress="inNumber();" />
								</div>
								<div class="col-12">
									<textarea name="shop_content" id="demo-message" placeholder="제품 설명을 작성해 주세요" rows="6"><%=shopDto.getShop_content() %></textarea>
								</div>
								
								

								<ul class="actions">
									<li><input type="submit" value="수정하기"></li>
									<li>
										<input type="file" name="file" accept=".png,.jsp"
											class="button icon solid fa-download">
									</li>
								</ul>
							</div>
						</form>
					</section>
				</div>
			</div>

			<!-- Sidebar -->
			<div id="sidebar">
				<div class="inner">

					<!-- Search -->
					<section id="search" class="alt">
						<form method="post" action="#">
							<input type="text" name="query" id="query" placeholder="Search" />
						</form>
					</section>

					<!-- Menu -->
					<nav id="menu">
						<header class="major">
							<h2>Menu</h2>
						</header>
						<ul>
							<li><a href="/MyAnimals/main.jsp">Homepage</a></li>
						<li><a href="/MyAnimals/planServlet?command=select">봉사 일정</a></li>
						<li><a href="/MyAnimals/shop.do?command=selectList">shop</a></li>
						<li><span class="opener">커뮤니티</span>
							<ul>
								<li><a href="/MyAnimals/answer.do?command=list&page=1">커뮤니티
										게시판</a></li>
								<li><a href="/MyAnimals/chat.xhtml" onclick="window.open(this.href, '','width=650px, height=500px, left=500px, top=100px ');return false;" target="_blank">채팅방</a></li>
							
								</ul>
							</li>
						</ul>
					</nav>



					<!-- Footer -->
					<footer id="footer">
						<p class="copyright">
							&copy; Untitled. All rights reserved. Demo Images: <a
								href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
								UP</a>.
						</p>
					</footer>

				</div>
			</div>

		</div>

		<!-- Scripts -->
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/browser.min.js"></script>
		<script src="assets/js/breakpoints.min.js"></script>
		<script src="assets/js/util.js"></script>
		<script src="assets/js/main.js"></script>

	</body>

</html>
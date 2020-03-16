<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/MyAnimals/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/MyAnimals/js/weatherajax.js"></script>
</head>
<body>

	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">


		<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>Menu</h2>
					</header>
					<ul>
						<li><a href="/MyAnimals/main.jsp">Homepage</a></li>
						<li><a href="/MyAnimals/planServlet?command=select">봉사 일정</a></li>
						<li><a href="/MyAnimals/shop.do?command=selectList">shop</a></li>						
						<li>
							<span class="opener">커뮤니티</span>
							<ul>
								<li><a href="/MyAnimals/answer.do?command=list&page=1">커뮤니티 게시판</a></li>
								<li><a href="/MyAnimals/chat.xhtml?name=${memberDto.member_id}" onclick="window.open(this.href, '','width=650px, height=500px, left=500px, top=100px ');return false;" target="_blank">채팅방</a></li>
							</ul>
						</li>
					</ul>
				</nav>
      

			<!-- Section -->
			<section>
				<header class="major">
					<h2>실시간 날씨정보</h2>
				</header>


				
	<!-- 
   apach -xalan-xalan2.7.2 -download-lastest(xalan-j distrbution directory) -bainary-zip-
      기상청 날씨 누리 -생활과 산업 -서비스-인터넷-rss
    -->
    <table border="1">
    <col width="100px">
    <col width="150px">
    <col width="150px">
    <col width="150px">
    	<tr>
    		<td colspan="4" bgcolor="#F56A6A"><b>지      역</b></td>
    	</tr>
    	<tr>
    		<td colspan="4">주소를 선택하세요
    			<select id="address"> 
    				<option value="1168064000">서울시 강남구 역삼1동</option>
    				<option value="1135064000">서울시 노원구 상계2동</option>
    				<option value="4221056000">강원도 속초시 교동</option>
    				<option value=""> </option>
    			</select><br/>
    	     	<input type="button" id="weaview" value="날씨보기">
    	     </td>
    	</tr>
    	<tr>
    		<td colspan="4" bgcolor="#F56A6A"><b>현재날씨</b></td>
    	</tr>
    	<tr>
    		<td>기준시간</td>
    		<td colspan="3" >
    			<input type="text" id="pubDate"  readonly="readonly">
    		</td>
    		
    	</tr>
    	<tr>
    		<td>날씨</td>
    		<td colspan="3">
    			<input type="text" id="wfKor" readonly="readonly">
    		</td>
    	</tr>
    	<tr>
    		<td>기온</td>
    		<td colspan="3">
    			<input type="text" id="temp" readonly="readonly">
    		</td>
    	</tr>
    	<tr>
    		<td>습도</td>
    		<td colspan="3">
    			<input type="text" id="reh" readonly="readonly">
    		</td>
    	</tr>
    	<tr>
    		<td>강수확률</td>
    		<td colspan="3">
    			<input type="text" id="pop" readonly="readonly">
    		</td>
    	</tr>
    </table>

			</section>



			<!-- Footer -->
			<footer id="footer">
				<p class="copyright">
					&copy; Untitled. All rights reserved. Demo Images: <a
						href="https://unsplash.com">Unsplash</a>. Design: <a
						href="https://html5up.net">HTML5 UP</a>.
				</p>
			</footer>

		</div>
	</div>
</body>
</html>
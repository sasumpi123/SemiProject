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
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
   if($('#td1').text()=='null'){
      $('#td1').html(' ');
   }
   if($('#td2').text()=='null'){
      $('#td2').html(' ');
   }
   if($('#td3').text()=='null'){
      $('#td3').html(' ');
   }
});



   
</script>

<script type="text/javascript">

function volunteerApply(volunteer_seq){
   open("member.do?command=applyVolunteer&volunteer_seq="+volunteer_seq,"","width=600,height=500");
}

</script>

</head>
<body class="is-preload">
<jsp:useBean id="planDto" class="com.plan.dto.planDto" scope="request"></jsp:useBean>
	<jsp:useBean id="memberDto" class="com.member.dto.MemberDto"
		scope="session"></jsp:useBean>
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

						<h2>내 정보</h2>
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
							<tr>
								<th>아이디</th>
								<td><jsp:getProperty property="member_id" name="memberDto" /></td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td><jsp:getProperty property="member_nickname"
										name="memberDto" /></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><jsp:getProperty property="member_name"
										name="memberDto" /></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><jsp:getProperty property="member_birth"
										name="memberDto" /></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><jsp:getProperty property="member_email"
										name="memberDto" /></td>
							</tr>
							<tr>
								<th>핸드폰</th>
								<td><jsp:getProperty property="member_phone"
										name="memberDto" /></td>
							</tr>
							<tr>
								<th>주소</th>
								<td><jsp:getProperty property="member_address"
										name="memberDto" /></td>
							</tr>
							<tr>
								<td><input type="button" value="수정"
									onclick="location.href='/MyAnimals/member.do?command=updateuserform'">
									<input type="button" value="계정삭제"
									onclick="location.href='/MyAnimals/member.do?command=userdeleteres&id=${memberDto.member_id}'">
									<input type="button" value="메인"
									onclick="location.href='/MyAnimals/main.jsp'">
									<c:if test="${memberDto.member_role eq 'CENTER' }">
										<input type="button" value="센터등록" onclick="location.href='/MyAnimals/member.do?command=centerInsert'"/>
									</c:if>
								</td>
							</tr>
						</table>
					</div>
				</section>

				<!-- Section -->
				<section>
					<div class="feature">
						<br>
                  <br>
                  <c:choose>
                     <c:when test="${memberDto.member_role == 'USER' }">

                     </c:when>
                     <c:otherwise>

                           <h2>CENTER</h2>
                           <table>
                                 <tr>
                                    <th>CENTER 이름</th>
                                    <td id="td1"><jsp:getProperty property="center_name"
                                          name="planDto" /></td>
                                    <th>CENTER 주소</th>
                                    <td id="td2"><jsp:getProperty property="center_addr"
                                          name="planDto" /></td>
                                    <th>CENTER 번호</th>
                                    <td id="td3"><jsp:getProperty property="center_phone"
                                          name="planDto" /></td>
                                 </tr>
                              </table>

                           <h2>봉사 등록 정보</h2>
                           <table border="1">
                              <tr>
                                 <th>봉사이름</th>
                                 <th>봉사날짜</th>
                                 <th>신청자 보기<th>
                              </tr>
                              <c:choose>
                                 <c:when test="${empty volunteerList }">
                                    <tr>
                                       <td colspan="2">----------신청자 정보가 없습니다----------</td>
                                    </tr>
                                 </c:when>
                                 <c:otherwise>
                                    <c:forEach items="${volunteerList }" var="VolunteerDto">
                                       <tr>
                                          <td>${VolunteerDto.volunteer_title }</td>
                                          <td>${VolunteerDto.volunteer_date }</td>
                                          <td><button onclick="volunteerApply(${VolunteerDto.volunteer_seq });">보기</button></td>
                                       </tr>
                                    </c:forEach>
                                 </c:otherwise>
                              </c:choose>
                           </table>
                        </c:otherwise>
                  </c:choose>
					</div>
				</section>


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
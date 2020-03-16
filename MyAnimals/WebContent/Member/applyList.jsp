<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />
<title>Insert title here</title>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
	<section id="banner">
		<div class="content">
		
    
<h2>신청자 현황</h2>
<table border="1">
   <tr>
      <th>신청자 성함</th>
      <th>연락처</th>
      <th>E-MAIL</th>
   </tr>                     
<c:choose>
   <c:when test="${empty applyList }">
         <tr>
            <td colspan="2" align="center">----------신청 정보가 없습니다----------</td>
         </tr>
   </c:when>
   <c:otherwise>
      <c:forEach items="${applyList }" var="applyDto">
         <tr>
            <td>${applyDto.apply_name }</td>
            <td>${applyDto.apply_phone }</td>
            <td>${applyDto.apply_email }</td>
         </tr>
      </c:forEach>
   </c:otherwise>
</c:choose>
</table>

		</div>
	</section>
	</div>
	</div>
	</div>

</body>
</html>
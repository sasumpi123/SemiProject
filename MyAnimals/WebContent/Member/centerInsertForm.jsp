<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://localhost:8787/MyAnimals/assets/css/main.css" />
<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />

</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
<%@ include file="/form/header.jsp"%>
	<section id="banner">
		<div class="content">
			  <h1>센터 등록</h1>
   <form action="/MyAnimals/member.do" method="post">
      <input type="hidden" name="command" value="centerInsertForm">
      <input type="hidden" name="Member_id" value="${memberDto.member_id }">
      <table>
            <tr>
               <th>센터 이름</th>
               <td><input type="text" name="center_name"></td>
            </tr>
            <tr>
               <th>센터 주소</th>
               <td><input type="text" name="center_addr"></td>
            </tr>
            <tr>
               <th>센터 전화번호</th>
               <td><input type="text" name="center_phone"></td>
            </tr>   
            <tr>
               <td colspan="2">
                  <input type="submit" value="센터 등록">
                  <input type="button" value="취소" onclick="self.close();">
               </td>
            </tr>
      </table>
   </form>
			
		</div>
	</section>
</div></div>
<%@ include file="/form/footer.jsp"%>
</div>
<!-- Scripts -->
	<script src="/MyAnimals/assets/js/jquery.min.js"></script>
	<script src="/MyAnimals/assets/js/browser.min.js"></script>
	<script src="/MyAnimals/assets/js/breakpoints.min.js"></script>
	<script src="/MyAnimals/assets/js/util.js"></script>
	<script src="/MyAnimals/assets/js/main.js"></script>
</body>
</html>
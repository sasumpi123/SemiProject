<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		*{
			padding: 0px;
			margin: 0px;
		}

		section{
			height: 400px;
		}
		#left{
			width: 48%;
			height: 90%;
			float: left;
		}
		#right{
			width: 48%;
			height: 90%;
			float: right;
		}
	
	
	</style>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
<%@include file="/form/header.jsp" %>
   <fieldset style="margin-right: auto; margin-left: auto;">
      <legend>둘중에 하나~ 골라 골라~</legend>

	<section class="html5">
		<article class="html5" id="left">
			<h2>봉사자</h2>
			<img alt="봉사자 회원가입 폼" src="/MyAnimals/image/minions.jpg" width="100%" height="100%" 
			onclick="location.href='/MyAnimals/member.do?command=registuser&name=${name}&email=${email }'">
		</article>
		<article class="html5" id="right">
			<h2>센터</h2>
			<img alt="센터 회원가입 폼" src="/MyAnimals/image/arrow.jpg" width="100%" height="100%" 
			onclick="location.href='/MyAnimals/member.do?command=registcenter&name=${name}&email=${email }'">
		</article>
	</section>
   </fieldset>
   </div>
   </div>
<%@include file="/form/footer.jsp" %>
   </div>

	<!-- Scripts -->
	<script src="/MyAnimals/assets/js/jquery.min.js"></script>
	<script src="/MyAnimals/assets/js/browser.min.js"></script>
	<script src="/MyAnimals/assets/js/breakpoints.min.js"></script>
	<script src="/MyAnimals/assets/js/util.js"></script>
	<script src="/MyAnimals/assets/js/main.js"></script>
</body>
</html>
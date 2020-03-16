<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<title>Editorial by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<style type="text/css">
table a {
	text-decoration: none;
}

table a:visited {
	color: black;
	text-decoration: none;
}

table a:hover {
	color: red;
}

table{
	display: block;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		var reads = document.getElementsByName("read");
		var readChks = document.getElementsByName("readChk");
		console.log(reads);
		console.log(readChks);
		for (var i = 0; i < reads.length; i++) {
			console.log(reads[i].value);
			console.log(readChks[i]);
			if (reads[i].value == 'N') {
				readChks[i].style.fontWeight = "bold";
				readChks[i].style.color = "#f66a78";
			}
		}
	};

	function allChk(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}

	function letter_open() {
		var seq = $("#seq").title();
		var id = "ADMIN" //${USER.id}
		console.log(seq);
		console.log(id);
		open("/MyAnimals/letter.do?command=detail&seq=" + seq + "&id=" + id,
				"", "width=900px, height=620px ");
	}

	function letter_writer() {
		open("/MyAnimals/letter.do?command=write", "",
				"width=900px, height=620px");
	}
</script>
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

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<input type="button" value="받은쪽지함"
							onclick="location.href='/MyAnimals/letter.do?command=receiveList&id=${memberDto.member_id}'" />
						<input type="button" value="보낸쪽지함"
							onclick="location.href='/MyAnimals/letter.do?command=sendList&id=${memberDto.member_id}'" />
					
					<form action="/MyAnimals/letter.do" method="post">
						<input type="hidden" name="command" value="multidelete" /> <input
							type="hidden" name="id" value="ADMIN" />
						<table border="1" style="margin-left: auto; margin-right: auto;" >
							<col width="75px">
							<col width="100px">
							<col width="150px">
							<col width="250px">
							<col width="200px">
							<tr>
								<th><input type="checkbox" name="all"
									onclick="allChk(this.checked)" /></th>
								<th>번호</th>
								<th>보낸사람</th>
								<th>제목</th>
								<th>작성일</th>
							</tr>
							<c:choose>
								<c:when test="${empty letterList }">
									<tr>
										<td colspan="5" align="center">- - - - - - - - - - 작성된
											게시글이 없습니다. - - - - - - - - - -</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${letterList }" var="dto" >
										<input type="hidden" name="read" value="${dto.letter_read }" />
										<tr name="readChk">
											<td align="center"><input type="checkbox" name="chk"
												value="${dto.letter_seq }" /></td>
											<td align="center">${dto.letter_seq }</td>
											<td align="center">${dto.member_from }</td>
											<td><a
												href="/MyAnimals/letter.do?command=detail&id=${dto.member_to }&seq=${dto.letter_seq }"
												onclick="window.open(this.href, '','width=900px, height=6200px');return false;"
												target="_blank">${dto.letter_title }</a></td>
											<td align="center"><fmt:formatDate value="${dto.letter_regdate }" pattern="YYYY/MM/dd" type="date"/></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<tr>
								<td colspan="5" align="right">
									<input type="submit" value="선택 삭제" /> 
									<input type="button" value="쪽지 보내기" onclick="letter_writer()" />
								</td>
							</tr>

						</table>
					</form>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	/* onsubmit=function(){
		opener.location.reload();
		opener.close();
		self.close();
	} */ 

</script>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

	<form action="/MyAnimals/letter.do" method="post">
	<input type="hidden" name="command" value="insert"/>
		<table border="1">
			<tr>
				<th>받는사람</th>
				<td><input type="text" name="to"/></td>
			</tr>
			<tr>
				<th>보내는사람</th>
				<td><input type="text" id="from" name="from" value="${memberDto.member_id}" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="summernote"></textarea> <script>
		$('#summernote').summernote({
			placeholder : '글을 작성해봐라',
			tabsize : 2,
			height : 200, // 에디터 높이
			witdh : 200, // 에디터 넓이
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR" // 한글 설정
		});
		// @param {String} HTML string
		/* var HTMLstring = $("<p>").text();
		console.log(HTMLstring); */
	</script></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="쪽지 보내기"/>
					<input type="button" value="취소" onclick="self.close()"/> 
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	</div>

</body>
</html>
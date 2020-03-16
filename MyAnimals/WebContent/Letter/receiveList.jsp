<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	a{
		text-decoration: none;
	}
	a:visited{
		color: black;
		text-decoration: none;
	}
	a:hover{
		color: red;
	}
	
</style>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">


	window.onload=function(){
		var reads = document.getElementsByName("read");
		var readChks = document.getElementsByName("readChk");
		console.log(reads);
		console.log(readChks);
		for(var i = 0; i < reads.length; i++){
			console.log(reads[i].value);
			console.log(readChks[i]);
			if(reads[i].value == 'N'){
				readChks[i].style.fontWeight = "bold";
				readChks[i].style.color = "#f66a78";
			}
		}
	};
		
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i = 0; i < chks.length; i++){
			chks[i].checked = bool;
		}
	}

	function letter_open(){
		var seq = $("#seq").title();
		var id = "ADMIN" //${USER.id}
		console.log(seq);
		console.log(id);
		open("/MyAnimals/letter.do?command=detail&seq="+seq+"&id="+id, "", "width=280px, height=460px, left=650px top=100px ");
	}
	
	function letter_writer(){
		open("/MyAnimals/letter.do?command=write","","width=280px, height=460px, left=650px, top=100px ");
	}


</script>
</head>
<body>

	<form action="/MyAnimals/letter.do" method="post">
	<input type="hidden" name="command" value="multidelete"/>
	<input type="hidden" name="id" value="ADMIN"/>
		<table border="1" style="margin-left: auto; margin-right: auto;">
			<col width="50px">
			<col width="75px">
			<col width="150px">
			<col width="300px">
			<col width="250px">
			<tr>
				<th>
					<input type="checkbox" name="all" onclick="allChk(this.checked)"/>
				</th>
				<th>번호</th>
				<th>보낸사람</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty letterList }">
					<tr >
						<td colspan="5" align="center">- - - - - - - - - - 작성된 게시글이 없습니다. - - - - - - - - - -</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${letterList }" var="dto">
					<input type="hidden" name="read" value="${dto.letter_read }"/>
						<tr name="readChk">
							<td align="center">
								<input type="checkbox" name="chk" value="${dto.letter_seq }"/>
							</td>
							<td align="center">${dto.letter_seq }</td>
							<td align="center">${dto.member_from }</td>
							<td><a href="/MyAnimals/letter.do?command=detail&id=${dto.member_to }&seq=${dto.letter_seq }"  onclick="window.open(this.href, '','width=280px, height=480px, left=650px, top=100px ');return false;" target="_blank">${dto.letter_title }</a></td>
							<td align="center"><fmt:formatDate value="${dto.letter_regdate }" pattern="YYYY/MM/dd" type="date"/></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="선택 삭제"/>
					<input type="button" value="쪽지 보내기" onclick="letter_writer()"/>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>
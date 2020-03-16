<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>보낸 사람</th>
			<td>${letterDto.member_from }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${letterDto.letter_title} </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="20" rows="20" readonly="readonly">${letterDto.letter_content }</textarea></td>
		</tr>
		<tr>
			<th>보낸시간</th>
			<td>${letterDto.letter_regdate }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="답장" onclick="window.open('/MyAnimals/letter.do?command=write', '','width=280px, height=460px, left=350px, top=100px ');return false;" target="_blank"/>
				<input type="button" value="삭제" onclick="location.href='/MyAnimals/letter.do?command=multidelete&id=${letterDto.member_to }&chk=${letterDto.letter_seq}'"/>
				<input type="button" value="닫기" onclick="self.close()"/>
			</td>
		</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="area">
		<select name="sido" id="sido">
			<option>전국</option>
			<option>서울특별시</option>
			<option>인천광역시</option>
			<option>대전광역시</option>
			<option>광주광역시</option>
			<option>대구광역시</option>
			<option>울산광역시</option>
			<option>부산광역시</option>
			<option>경기도</option>
			<option>강원도</option>
			<option>충청북도</option>
			<option>충청남도</option>
			<option>전라북도</option>
			<option>전라남도</option>
			<option>경상북도</option>
			<option>경상남도</option>
			<option>제주도</option>
		</select>
		<input type="button" value="검색" id="selectlocation" onclick="getData('location')">
	</div>
	<div id="animalKind" style="display: none;">
		<select name="kind" id="kind">
			<option>전체</option>
			<option>개</option>
			<option>고양이</option>
			<option>기타</option>
		</select>
		<input type="button" value="검색" id="selectkind" onclick="getData('kind')">
	</div>
</body>
</html>
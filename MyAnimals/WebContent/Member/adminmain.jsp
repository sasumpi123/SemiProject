<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>관리자 페이지</h1>

	<form action="/MyAnimals/member.do" method="post">
	<input type="hidden" name="command" value="adminmainform">
	   <table border="1">
	      <tr>
	         <th>회원전체정보</th>
	         <td><input type="button" value=" " onclick="location.href='/MyAnimals/member.do?command=selectall'"></td>
	      </tr>
	      <tr>
	         <th>봉사자정보</th>
	         <td><input type="button" value=" " onclick="location.href='/MyAnimals/member.do?command=volunteer'"></td>
	      </tr>
	      <tr>
	         <th>센터정보</th>
	         <td><input type="button" value=" " onclick="location.href='/MyAnimals/member.do?command=centerallinfo'"></td>
	      </tr>
	      <tr>
	         <th>회원등급조정</th>
	         <td><input type="button" value=" " onclick="location.href='/MyAnimals/member.do?command=updateroleform'"></td>
	         
	         
	      </tr>
	   </table>
	</form>
</body>
</html>
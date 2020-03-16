<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
   
   <c:choose>
      <c:when test="${empty memberDto }" >
	   	<tr>
	      <td>
	       	<input type="button" value="로그인" onclick="location.href='/MyAnimals/member.do?command=loginform'">
	       	<input type="button" value="회원가입" onclick="location.href='/MyAnimals/member.do?command=registselectres'">
	      </td>
	   </tr>
      </c:when>
      <c:otherwise>
       <tr>
         <td>
            <input type="button" value="내정보" onclick="location.href='/MyAnimals/member.do?command=myinfo'">
            <input type="button" value="로그아웃" onclick="location.href='/MyAnimals/member.do?command=logout'">
         </td>
      </tr>  
      </c:otherwise>
   </c:choose>

</table>
</body>
</html>
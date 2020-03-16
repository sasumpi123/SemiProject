<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/MyAnimals/emailchk.do" method="post">
   
   <jsp:useBean id="memberDto" class="com.member.dto.MemberDto" scope="request" ></jsp:useBean>   
   <table>
   
   	  <tr>
   	     <th>아이디는 :<jsp:getProperty property="member_id" name="memberDto"/> 입니다.</th>
   	  </tr>
      <tr>
         <td>
            <input type="submit">
         </td>
      </tr>
   </table>
</form>
</body>
</html>
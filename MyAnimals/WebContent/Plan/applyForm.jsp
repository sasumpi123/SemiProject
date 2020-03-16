<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <meta charset="utf-8" />
   <link rel="stylesheet" href="http://localhost:8787/MyAnimals/assets/css/main.css" />
   <link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />

</head>
<body>



   <h1>봉사 신청</h1>
   
   <form action="calendar.do" method="post">
      <input type="hidden" name="command" value="applyInserForm">
      <input type="hidden" name="Member_id" value="${memberDto.member_id }">
      <input type="hidden" name="volunteer_seq" value="<%=request.getParameter("volunteer_seq")%>">
      <table>
         <tr>
            <th>신청자 이름</th>
            <td><input type="text" name="apply_name"></td>
         </tr>
         <tr>
            <th>연락처</th>
            <td><input type="text" name="apply_phone"></td>
         </tr>
         <tr>
            <th>이메일</th>
         <td><input type="text" name="apply_email">
               <select name="select_apply_email">
                        <option>@naver.com</option>
                     <option>@gmail.com</option>
                     <option>@daum.net</option>
                  </select>
         </td>
         </tr>
         <tr>
            <td colspan="2">
            	<c:choose>
            	</c:choose>
               <input type="submit" value="신청">
               <input type="button" value="뒤로" onclick="self.close();">
            </td>
         </tr>
      </table>
      
   </form>
   

</body>
</html>
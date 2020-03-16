<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
   <link rel="stylesheet" href="http://localhost:8787/MyAnimals/assets/css/main.css" />
   <link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />


</head>

<script type="text/javascript">

function apply(){
   open("/MyAnimals/calendar.do?command=applyInsert&volunteer_seq=${volunteerDto.volunteer_seq}","","width=400,height=400");
}

</script>

<body>

   <table border="1">
      <tr>
         <th>제목</th>
         <td>${volunteerDto.volunteer_title }</td>
      </tr>   
      <tr>
         <th>내용</th>
         <td><textarea rows="6" cols="15" readonly="readonly">${volunteerDto.volunteer_content }</textarea></td>
      </tr>
      <tr>
         <th>인원수</th>
         <td>${volunteerDto.volunteer_nowvolunteer}/${volunteerDto.volunteer_maxvolunteer }</td>
      </tr>
      <tr>
         <th>날짜</th>
         <td>${volunteerDto.volunteer_date }</td>
      <tr>
      <tr>
         <td colspan="4">
         	<c:choose>
         		<c:when test="${memberDto.member_role eq 'CENTER' }">
         		 	 <c:if test="${volunteerDto.member_id eq memberDto.member_id}">
       				    <button onclick="location.href='calendar.do?command=volunteerDelete&volunteer_seq=${volunteerDto.volunteer_seq}&center_seq=${volunteerDto.center_seq}'">일정삭제</button>
   					 </c:if> 
   					 <button onclick="history.back();">취소</button>
         		</c:when>
         		<c:otherwise>
         			<button onclick="apply();">봉사 신청</button>
          		    <button onclick="history.back();">취소</button>
         		</c:otherwise>
         	</c:choose>
            
   
         </td>
      </tr>
   
   </table>

</body>
</html>
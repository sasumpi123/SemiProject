<%@page import="com.member.dto.MemberDto"%>
<%@page import="com.calendar.dto.VolunteerDto"%>
<%@page import="com.calendar.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.calendar.dao.calendarDaoImpl"%>
<%@page import="com.calendar.dao.calendarDao"%>
<%@page import="com.calendar.dao.Util"%>
<%@page import="com.plan.dto.planDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">

#map{
   margin-left: auto;
   margin-right: auto;
}

#calendar{
   margin-left: auto;
   margin-right: auto;
}

#table{
   text-align: center;
   
}


</style>

</head>
<body class="is-preload">
   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Main -->
      <div id="main">
         <div class="inner">
<%@include file="/form/header.jsp" %>

   <h1>보호소</h1>
   <div id="map" style="width:500px;height:400px;"></div>
   <br>
   <br>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d88d544f75c4ee7cfb6abfeda2856aa6"></script>
<script>

var planDto = '<% planDto planDto = (planDto)session.getAttribute("planDto"); %>';

var memberDto = '<% MemberDto memberDto = (MemberDto)session.getAttribute("memberDto"); %>'


var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng('<%=planDto.getCenter_latitude()%>', '<%=planDto.getCneter_longitude()%>'), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng('<%=planDto.getCenter_latitude()%>', '<%=planDto.getCneter_longitude()%>'); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

var iwContent = '<div style="padding:5px;"><%=planDto.getCenter_name() %> <br><a href="https://map.kakao.com/link/map/<%=planDto.getCenter_name() %>,<%=planDto.getCenter_latitude()%>,<%=planDto.getCneter_longitude()%>" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/<%=planDto.getCenter_name() %>,<%=planDto.getCenter_latitude()%>,<%=planDto.getCneter_longitude()%>" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

//인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
position : iwPosition, 
content : iwContent 
});

//마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>

   
   <table border="1" id="cneter_info">
      <tr>
         <th>보호소 명: </th>
         <td><%=planDto.getCenter_name() %></td>
      </tr>
      <tr>
         <th>주소 : </th>
         <td><%=planDto.getCenter_addr()%></td>
      </tr>
      <tr>
         <th>연락처 : </th>
         <td><%=planDto.getCenter_phone() %></td>
      </tr>
   </table>
   
   
   <script type="text/javascript">

function addCalendar(){
   var Member_id ='<%=memberDto.getMember_id() %>'
   open("calendar.do?command=insertCalendar&Member_id="+Member_id+"&Center_seq="+<%=planDto.getCenter_seq()%>,"","width=600,height=500");
}

</script>   
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

   <c:if test="${memberDto.member_role eq 'CENTER' && planDto.member_id eq memberDto.member_id}">
      <div id="button">
         <button onclick="addCalendar();">일정등록</button>
      </div>   
    </c:if> 
    <br>
    <br>
    <iframe id="calendar" src="Plan/calendar.jsp" width="600" height="600" style="border:none">
    </iframe>

   
   </div>
   </div>
<%@include file="/form/footer.jsp" %>
</div>
<!-- Scripts -->
   <script src="/MyAnimals/assets/js/jquery.min.js"></script>
   <script src="/MyAnimals/assets/js/browser.min.js"></script>
   <script src="/MyAnimals/assets/js/breakpoints.min.js"></script>
   <script src="/MyAnimals/assets/js/util.js"></script>
   <script src="/MyAnimals/assets/js/main.js"></script>
</body>
</html>
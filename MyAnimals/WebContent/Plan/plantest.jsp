<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="is-preload">
   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Main -->
      <div id="main">
         <div class="inner">
<%@include file="/form/header.jsp" %>


	<%@ includefile="selectlocal.jsp"%>
	
	<script type="text/javascript">
	$('#getList').click(function(){
		$('#table').empty();
		var head = "<tr>";
			head += "<td>번호</td>";
			head += "<td>이름</td>";
			head += "<td>주소</td>";
			head += "<td>전화번호</td>";
			head += "</tr>";
		$('#table').append(head);
		var i = 1;
		$.ajax({
			url : "/MyAnimals/planServlet",
			type : "POST",
			dataType: "json",
			data : {
				'command' : 'showxml',
				'sido' : $('#sido').val(),
				'gugun' : $('#gugun').val()
			},
			async:false,
			success : function(data, textStatus, xhr) {
				 console.log(data);
				 if(data.length == 0){
					 var rowItem = "<tr>";
					 	 rowItem += "<td colspan='4' align='center'>";
					 	 rowItem += "- - - - - 검색된 정보가 없습니다 - - - - -";
					 	 rowItem += "</td>";
					 	 $('#table').append(rowItem);
				 }else {
					 
				  $.each(data, function(key, val){ 
					  var rowItem = "<tr>";
						  rowItem += "<td>"+i+"</td>";
						  rowItem += "<td><a href='/MyAnimals/planServlet?command=detail&seq="+val['center_seq']+"'>"+val['center_name']+"</a></td>";
						  rowItem += "<td>"+val['center_addr']+"</td>";
						  rowItem += "<td>"+val['center_phone']+"</td>";
						  rowItem += "</tr>";
						  $('#table').append(rowItem);
						  i++;
				  })
				 }
			},
			error : function(request,status,error) {
			
				console.log(error);
				
			}
		});
	})

		
	</script>

	<table border="1" id="table">
		
	</table>


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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 인증 확인</title>
<%
	String emailChkText = (String)request.getAttribute("emailChkText");
	System.out.println("jsp안에서"+emailChkText);
%>
<script type="text/javascript">
function emailChkRes(){
	var inputEmailChkText = document.getElementsByName("inputEmailChkText")[0].value;
	var emailChkText = document.getElementsByName("emailChkText")[0].value;
	if(inputEmailChkText===emailChkText){
		alert('인증되었습니다');
		opener.document.getElementsByName("regist")[0].style.display="";
		self.close();
	}else{
		alert('인증문자를 확인해주세요');
	}
}
</script>
</head>
<body>

	<h3>인증번호를 입력해주세요</h3>

	<input type="hidden" name="emailChkText" value="<%=emailChkText%>">
		<input type="text" name="inputEmailChkText" value="">
		
		<input type="button" value="확인" onclick="emailChkRes()">

</body>
</html>


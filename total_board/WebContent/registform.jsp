<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html, charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function idChk(){
	var doc = document.getElementsByName("mbid")[0];
	
	if(doc.value.trim()==""||doc.value==null){
		alert("아이디를 입력해 주세요");
	}else{
		open("member.do?command=idchk&mbid="+doc.value,"","width=200,height=200");
	}
}

function idChkConfirm(){
	var chk = document.getElementsByName("mbid")[0].title;
	if(chk=='n'){
		alert("id 중복체크를 먼저 해주세요");
		document.getElementsByName("mbid")[0].focus();
	}
}
function emailChk(){
	var doc = document.getElementsByName("mbemail")[0];
	if(doc.value.trim()==""||doc.value==null){
		alert("이메일주소를 입력해 주세요");
	}else{
		open("emailchk.do?command=emailchk&mbemail="+doc.value,"","width=600,height=400");
	}
}
</script>

</head>
<body>
	<h1>회원가입</h1>
	<form action="member.do?" method="post">
		<input type="hidden" name="command" value="registres">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
				<input type="text" name="mbid" title="n" required="required"> 
				<input type="button" value="중복체크" onclick="idChk()">
					</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="mbpw" title="n" required="required" onclick="idChkConfirm()">
					</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mbname" title="n" required="required" onclick="idChkConfirm()"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="mbaddr" title="n" required="required" onclick="idChkConfirm()"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mbphone" title="n" required="required" onclick="idChkConfirm()"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="mbemail" title="n" required="required" onclick="idChkConfirm()">
					<input type="button" value="인증" onclick="emailChk()">
				</td>				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="regis" style="display: none" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>
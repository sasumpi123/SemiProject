<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/MyAnimals/js/jquery-3.4.1.js"></script>
<script type="text/javascript">


	function idChkConfirm(){
	   var chk = document.getElementsByName("id")[0].title;
	   if(chk=="n"){
		   alert("ID 중복체크를 먼저 해주세요");
		   document.getElementsByName("id")[0].focus();
	   }
	 };
	 
	 $(function(){
			$(".chkList").hide();
			
			$("#pwchk").keyup(function(){
				var pw = document.getElementById("pw").value;
				var pwchk = document.getElementById("pwchk").value;
				if(pw == pwchk){
					$("#success").show();
					$("#fail").hide();
				} else {
					$("#success").hide();				
					$("#fail").show();
				}
			});
			
			$("#id").keyup(function(){
				$.ajax({
					url:"/MyAnimals/member.do?command=idChk&id="+$("#id").val(),
					dataType:"json",
					success:function(res){
						if(res.idchk == "true"){
							$("#usedid").show();
							$("#notusedid").hide();
						} else {
							if($("#id").val() == null || $("#id").val() == "" ){
								$("#usedid").hide();
								$("#notusedid").hide();
							} else {							
							$("#usedid").hide();
							$("#notusedid").show();
							}
						}
					},
					error:function(){
						alert("통신 실패");
					}
				});
			});
			
			$("#nickname").keyup(function(){
				$.ajax({
					url:"/MyAnimals/member.do?command=nicknameChk&nickname="+$("#nickname").val(),
					dataType:"json",
					success:function(res){
						if(res.nickchk == "true"){
							$("#usednick").show();
							$("#notusednic").hide();
						} else {
							if($("#nickname").val() == null || $("#nickname").val() == "" ){
								$("#usednick").hide();
								$("#notusednick").hide();
							} else {							
							$("#usednick").hide();
							$("#notusednick").show();
							}
						}
					},
					error:function(){
						alert("통신 실패");
					}
				});
			});
			
			$("#email").keyup(function(){
				$.ajax({
					url:"/MyAnimals/member.do?command=emailChk&email="+$("#email").val(),
					dataType:"json",
					success:function(res){
						if(res.emailchk == "true"){
							$("#usedemail").show();
							$("#notusedemail").hide();
						} else {
							if($("#email").val() == null || $("#email").val() == "" ){
								$("#usedemail").hide();
								$("#notusedemail").hide();
							} else {							
							$("#usedemail").hide();
							$("#notusedemail").show();
							}
						}
					},
					error:function(){
						alert("통신 실패");
					}
				});
			});
			
		});

	 
	function emailChk(){
		var doc = document.getElementsByName("email")[0];
		if(doc.value.trim()==""||doc.value==null){
			alert("이메일주소를 입력해 주세요");
		}else{
			open("/MyAnimals/emailchk.do?command=emailchk&email="+doc.value,"","width=600,height=400");
		}
	};



function emailChk(){
	var doc = document.getElementsByName("email")[0];
	if(doc.value.trim()==""||doc.value==null){
		alert("이메일주소를 입력해 주세요");
	}else{
		open("/MyAnimals/emailchk.do?command=emailchk&email="+doc.value,"","width=600,height=400");
	}
}



</script>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
<%@include file="/form/header.jsp" %>
   <form action="/MyAnimals/member.do" method="post">
      <input type="hidden" name="command" value="registcenterres">
      <table border="1">
         <tr>
            <th>아이디</th>
            <td>
               <input type="text" id="id" name="id" title="y" required="required" >
            </td>
         </tr>
         <tr>
         	<td colspan="2">
         		<div class="chkList" id=usedid style="color: red">이미 사용중인 아이디 입니다.</div>
         		<div class="chkList" id=notusedid style="color: blue">사용할 수 있는 아이디 입니다.</div>
         	</td>
         </tr>
         <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw" id="pw" required="required" onclick="idChkConfirm()"></td>
         </tr>
         <tr>
            <th>비밀번호 확인</th>
            <td><input type="password" name="pwchk" id="pwchk" required="required" onclick="idChkConfirm()"></td>
         </tr>
         <tr>
         	<td colspan="2">
         		<div class="chkList" id="success" style="color: blue">비밀번호가 일치합니다.</div>
         		<div class="chkList" id="fail" style="color: red">비밀번호가 일치하지 않습니다.</div>
         	</td>
         </tr>
         <tr>
            <th>닉네임</th>
            <td>
               <input type="text" name="nickname" id="nickname" required="required" onclick="idChkConfirm()">
            </td>
         </tr>
         <tr>
         	<td colspan="2">
         		<div class="chkList"  id="usednick" style="color: red;">이미 사용중인 닉네임 입니다.</div>
         		<div class="chkList"  id="notusednick" style="color: blue;">사용할 수 있는 닉네임 입니다.</div>
         	</td>
         </tr>
         <tr>
            <th>이름</th>
            <td><input type="text" name="name" required="required" onclick="idChkConfirm()" value="${name }"></td>
         </tr>
         <tr>
            <th>성별</th>
            <td>
            	<select name="gender">
              		<option value="M">남자</option>
              		<option value="F">여자</option>
              	</select>
            </td>
         </tr>
         <tr>
            <th>생년월일</th>
            <td><input type="text" name="birth" required="required" onclick="idChkConfirm()"></td>
         </tr>
         <tr>
            <th>이메일</th>
            <td>
               <input type="text" name="email" id="email" required="required" onclick="idChkConfirm()" value="${email }">
               <input type="button" value="이메일인증" required="required" onclick="emailChk()">  
            </td>
         </tr>
         <tr>
         	<td colspan="2">
         		<div class="chkList"  id="usedemail" style="color: red;">이미 사용중인 이메일 입니다.</div>
         		<div class="chkList"  id="notusedemail" style="color: blue;">사용할 수 있는 이메일 입니다.</div>
         	</td>
         </tr>
         <tr>
            <th>핸드폰</th>
            <td><input type="text" name="phone" required="required" onclick="idChkConfirm()"></td>
         </tr>
         <tr>
            <th>주소</th>
            <td><input type="text" name="address" required="required" onclick="idChkConfirm()"></td>
         </tr>
         <tr>
            <td colspan="2" align="right">
               <input type="submit" name="regist" value="회원가입" >
               <input type="button" value="취소" onclick="location.href='loginmain.jsp'">
            </td>
         </tr>
         
      </table>
   </form>
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
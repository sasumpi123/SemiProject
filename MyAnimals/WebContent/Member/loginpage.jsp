<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
    
<%
	// 브라우저가 캐시에 화면(응답된 도큐먼트) 저장하지 않도록 설정
	response.setHeader("Pragma", "no-cache");				// http 1.0
	response.setHeader("Cache-control", "no-store");		// http 1.1
	response.setHeader("Expires", "0");						// proxy server
	// 회원명단에서 command=login으로 갈 때 세션이 캐시 영역에 자동으로 저장해두기 때문에 에러가 나지않고 이동할 수 있다.
	// 하지만 우리는 그렇게 이동하지 않게 하기 위해 캐시를 지워주고 바로 adminmain.jsp로 이동시켰다.

    String clientId = "YCcGSt6BfvkHKq2CsQHK";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8787/MyAnimals/naver.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="955044676304-9g5lqe9k6picqmct6qai7eq5es3lg87o.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <link rel="stylesheet" href="http://localhost:8787/MyAnimals/assets/css/main.css" />
	<link rel="stylesheet" href="/MyAnimals/assets/css/main.css" />
<title>Insert title here</title>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
function forgot(){
	open("/MyAnimals/emailchk.do?command=forgotinfo","","width=300,height=300");
}
</script>
</head>
<body>
   

</body>

<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
			<header id="header">
				<h2>MyAnimals</h2>
			</header>

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<form action="/MyAnimals/member.do" method="post">
   <input type="hidden" name="command" value="login">
         <table border="1">
           <col width="200">
	       <col width="200">
            <tr>
               <th>아이디</th>
               <td><input type="text" name="id"></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" name="pw"></td>
            </tr>
            <tr>
               <td colspan="4" align="center">
                  <input type="submit" value="로그인">
                  <input type="button" value="회원가입" onclick="location.href='/MyAnimals/member.do?command=registselectres'">
                  <input type="button" value="아이디·비밀번호찾기" onclick="forgot()">

               </td>
            </tr>
            <tr>
            	<td colspan="4" align="center">
            		<a id="kakao-login-btn"></a>
            		<a href="<%=apiURL%>"><img height="50" src="/MyAnimals/image/naver.PNG"/></a>
            		<a class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></a>
            	</td>
            </tr>
         </table>
   </form>
   
   
    <script>
        function onSignIn(googleUser) {
            // Useful data for your client-side scripts:
            var profile = googleUser.getBasicProfile();
            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
            console.log('Full Name: ' + profile.getName());
            console.log('Given Name: ' + profile.getGivenName());
            console.log('Family Name: ' + profile.getFamilyName());
            console.log("Image URL: " + profile.getImageUrl());
            console.log("Email: " + profile.getEmail());
            
            var name = profile.getName();
            var email = profile.getEmail();
            
            location.href="/MyAnimals/member.do?command=registuser&name="+name+"&email="+email;

            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
        };
    </script>


<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('8700b83b51bde744ad5aebd0c5ebe1f1');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        // 로그인 성공시, API를 호출합니다.
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
        	var data = JSON.stringify(res);
            alert(data);
            console.log(data);
            console.log(JSON.stringify(res.id));
            console.log(JSON.stringify(res.properties.nickname));
            console.log(JSON.stringify(res.kakao_account.email));
            console.log(JSON.stringify(res.kakao_account.birthday))
            
            var name = "&name="+res.properties.nickname;
            var email = "&email="+res.kakao_account.email;
            
            location.href='/MyAnimals/member.do?command=registkakao'+name+email;

          },
          fail: function(error) {
            alert(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
  
</script>

<!-- <input type="button" value="카카오톡 로그아웃" onclick="logout();"/>
<script type="text/javascript">

	function logout(){
		Kakao.Auth.logout(function(){
			setTimeout(function(){
				alert("로그아웃");
			},1000);
		});
	};

</script> -->
					</div>
					
				</section>

				<!-- Section -->
				<!-- <section>
					<div class="features">
						테이블 시작
						
					
						
							<form action="answer.do" method="post">
								<input type="hidden" name="command" value="writeres"/>
								<table border="1">
									<tr>
										<th>작성자</th>
										<td><input type="text" name="nickname"/></td>
									</tr>
									<tr>
										<th>제목</th>
										<td><input type="text" name="title" /></td>
									</tr>
									<tr>
										<th>내용</th>
										<td><textarea rows="10" cols="60" name="content"></textarea></td>
									</tr>
									<tr>
										<td colspan="2" align="right">
											<input type="submit" value="write" id="write"/>
											<input type="button" value="cancle" onclick="location.href='answer.do?command=list'" id="cancle"/>
										</td>
									</tr>
								</table>
							</form>
					</div>
				</section>

													<ul class="pagination" style="float: left; width: 100%; text-align: center;">
														<li><span class="button">Prev</span></li>
														<li><a href="#" class="page active">1</a></li>
														<li><a href="#" class="page">2</a></li>
														<li><a href="#" class="page">3</a></li>
														<li><span>…</span></li>
														<li><a href="#" class="page">8</a></li>
														<li><a href="#" class="page">9</a></li>
														<li><a href="#" class="page">10</a></li>
														<li><a href="#" class="button">Next</a></li>
		   								 			</ul> -->

			</div>
		</div>

<!-- 사이드바 시작  -->
<%@ include file="/form/footer.jsp" %>
	
<!-- 사이드바 끝 -->
	</div>

	<!-- Scripts -->
	<script src="/MyAnimals/assets/js/jquery.min.js"></script>
	<script src="/MyAnimals/assets/js/browser.min.js"></script>
	<script src="/MyAnimals/assets/js/breakpoints.min.js"></script>
	<script src="/MyAnimals/assets/js/util.js"></script>
	<script src="/MyAnimals/assets/js/main.js"></script>

</body>
</html>
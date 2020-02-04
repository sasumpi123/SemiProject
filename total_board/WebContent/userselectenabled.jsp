<%@page import="com.dto.MemberDto"%>
<%@page import="java.util.List"%>
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
</head>
<%
	List<MemberDto> list = (List<MemberDto>) request.getAttribute("list");
%>

<script type="text/javascript">
function updateRole(mbno){
	location.href="member.do?command=updateroleform&mbno="+mbno;
}
</script>
<body>

	<h1>회원정보 조회(Enabled)</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입여부</th>
			<th>등급</th>
			<th>등급변경</th>
		</tr>

		<%
			for (MemberDto dto : list) {
		%>
		<tr>
			<td><%=dto.getMbno()%></td>
			<td><%=dto.getMbid()%></td>
			<td><%=dto.getMbpw()%></td>
			<td><%=dto.getMbname()%></td>
			<td><%=dto.getMbaddr()%></td>
			<td><%=dto.getMbphone()%></td>
			<td><%=dto.getMbemail()%></td>
			<td><%=dto.getMbenabled()%></td>
			<td><%=dto.getMbrole()%></td>
			<td><button onclick="updateRole(<%=dto.getMbno()%>)">변경</button>
			</td>
		</tr>
		<%
			}
		%>

		<tr>
			<td colspan="10">
				<button onclick="location.href='adminmain.jsp'">메인으로</button>
			</td>
		</tr>

	</table>

</body>
</html>
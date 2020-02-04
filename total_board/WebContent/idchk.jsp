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
	onload = function() {
		var id = opener.document.getElementsByName("mbid")[0].value;
		document.getElementsByName("id")[0].value = id;
	}
	function myconfirm(bool) {
		if (bool == 'true') {
			opener.document.getElementsByName("mbid")[0].focus();
		} else {
			opener.document.getElementsByName("mbpw")[0].focus();
			opener.document.getElementsByName("mbid")[0].title = 'y';
		}
		self.close();
	}
</script>

<%
	String idnotused = request.getParameter("idnotused");
%>
</head>
<body>

	<table border="1">
		<tr>
			<td><input type="text" name="id" title=""></td>
		</tr>
		<tr>
			<td><%=idnotused.equals("false") ? "아이디 생성 가능" : "중복된 아이디 존재"%></td>
		</tr>
		<tr>
			<td><input type="button" value="확인"
				onclick="myconfirm('<%=idnotused%>')"></td>
		</tr>
	</table>

</body>
</html>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.reply.dto.ReplyDto"%>
<%@page import="com.member.dto.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>

<head>
<style type="text/css">
   th{text-align: center !important}
   
   table{margin: auto;width: 100%;}
   
   #update{
background-color: #f56a6a !important;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
#delete{
background-color: #f56a6a !important;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
#list{
background-color: #f56a6a !important;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
#answer{
background-color: #f56a6a !important;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
#insert{
background-color: #f56a6a !important;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">


function cmUpdateOpen(reply_seq){
	
    window.name = "parentForm";
    window.open("reply.do?command=rupdateform&replyno="+reply_seq,
                "updateForm", "width=570, height=350, resizable = no, scrollbars = no");
}






</script>
	<title>Editorial by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="/assets/css/main.css" />

</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
<%@ include file="/form/header.jsp" %>
	

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
							<h1>글 상세보기</h1>
						</header>
						
						
					</div>
					
				</section>

				<!-- Section -->
				<section>
					<div class="features">
						<!-- 테이블 시작 -->
						
						<table border="1">
							<tr>
								<th>작성자</th>
								<td>${boardDto.member_nickname }</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${boardDto.board_title }</td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea rows="10" cols="60" readonly="readonly">${boardDto.board_content }</textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<input type="button" value="update" class="button primary small" onclick="location.href='answer.do?command=updateform&boardno=${boardDto.board_seq}'" id="update"/>
									<input type="button" value="delete" class="button primary small" onclick="location.href='answer.do?command=delete&boardno=${boardDto.board_seq}'" id="delete"/>
									<input type="button" value="list"   class="button primary small" onclick="location.href='answer.do?command=list&page=1'" id="list"/>
									<input type="button" value="answer" class="button primary small" onclick="location.href='answer.do?command=answer&boardno=${boardDto.board_seq}'" id="answer"/>
								</td>
							</tr>
						</table>
	<hr>
	
	<div class="container">
    <form action="answer.do"  method="post" >
    <input type="hidden" name="command" value="commentres">
    <input type="hidden" name="boardseq" value="${boardDto.board_seq }">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> 
            </div>
            <div>
                <table class="table" style=" margin: auto; width: 100%">                    
                    <tr>
                        <td>
                            <textarea placeholder="댓글을 입력하세요" name="rcontent"></textarea>
                            <br>
                            <div align="right">
                                <input type="submit"  value="insert" id="insert" class="button primary small">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
        
        
	<!-- 댓글 리스트 -->
	<h2>CommentList</h2>
	<table border="1" style="margin: auto;width: 100%">
	
		<col width="100">
		<col width="100">
		<col width="200">
		<col width="100">
		<col width="100">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>내용</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<c:choose>
			<c:when test="${empty replyList}">
			<tr>
				<td colspan="4">----------작성된 글이 존재하지 않습니다.----------</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${replyList }" var="replyDto">
					
						
							<tr>
								<td>${replyDto.reply_seq }</td>
								<td>${replyDto.member_id }</td>
								<td>${replyDto.reply_content }</td>
								<td>
								<fmt:formatDate value="${replyDto.reply_regdate }" pattern="YYYY/MM/dd" type="date"/>
								</td>
								<td>
									<c:if test="${memberDto.member_id eq replyDto.member_id}">
									    <input type="button" class="button small" value="update" onclick="cmUpdateOpen(${replyDto.reply_seq})">
										<%-- <input type="button" class="button small" value="update" onclick="location.href='reply.do?command=update&replyno=${replyDto.reply_seq}&boardno=${boardDto.board_seq}'"> --%>
									    <input type="button" class="button small" value="delete" onclick="location.href='reply.do?command=delete&replyno=${replyDto.reply_seq}&boardno=${boardDto.board_seq}'">
									</c:if>								    
								</td>
							</tr>
						
					
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
    
</div>
					
						
							
					</div>
				</section>

			

			</div>
		</div>

<!-- 사이드바 시작  -->
<%@ include file="/form/footer.jsp" %>
	
<!-- 사이드바 끝 -->
	</div>

	<!-- Scripts -->
	<script src="/assets/js/jquery.min.js"></script>
	<script src="/assets/js/browser.min.js"></script>
	<script src="/assets/js/breakpoints.min.js"></script>
	<script src="/assets/js/util.js"></script>
	<script src="/assets/js/main.js"></script>

</body>

</html>
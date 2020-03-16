<%@page import="com.board.dto.PagingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
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

.col{text-align: center !important}

a{border-bottom: none !important;text-decoration: none !important;}
#write{
align:right;
background-color: #f56a6a;
color: #ffffff !important;
font-family: "Roboto Slab", serif;
font-size: 0.8em;
font-weight: 700;
height: 3.5em;

}
li{list-style:none;}


 
 .pagination{
display: block;
text-align: center;
justify-content: center;
}

.pagination>li>a{

float:none;
}
 
</style>
	<title>Editorial by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
<script type="text/javascript">



</script>
</head>
<%
PagingDto pdto = (PagingDto)request.getAttribute("boardPdto");

int pagegroup = (int)Math.ceil((double)pdto.getPage()/pdto.getPagescale());
int startpage = pdto.getPagescale()*(pagegroup-1)+1;
int endpage=pdto.getPagescale()*pagegroup;
int totalpage = pdto.getTotalpage();

%>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
<%@ include file="../form/header.jsp" %>
	

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
							<h1>커뮤니티 게시판</h1>
						</header>
						
						
					</div>
					
				</section>

				<!-- Section -->
				<section>
					<div class="features">
						<!-- 테이블 시작 -->
						<table border="1">
					
								<col width="10%"/>
								<col width="60%"/>
								<col width="10%"/>
								<col width="12%"/>
								<col width="8%"/>
						
								<tr>
									<th>글번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
								<c:choose>
									<c:when test="${empty boardList }">
										<tr>
											<td colspan="5" align="center">-----작성된 글이 존재하지 않습니다------</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${boardList }" var="boardDto">
											<c:choose>
												<c:when test="">
														<tr>
															<td  class="col">${boardDto.board_seq }</td>
															<td  class="col">${boardDto.member_nickname }</td>
															<td  class="col">${boardDto.board_regdate }</td>
														</tr>
												</c:when>
												<c:otherwise>
														<tr>
															<td  class="col">${boardDto.board_seq }</td>
															<c:choose>
																<c:when test="${boardDto.board_delflag eq 'Y' }">
																	<td ><!-- col -->
																		<c:forEach begin="1" end="${boardDto.board_titletab }">
																			&nbsp;&nbsp;
																		</c:forEach>
																		<c:out value="삭제된 글입니다."></c:out>
																	</td>
																</c:when>									
																<c:otherwise>
																	<td> <!-- col -->
																		<c:forEach begin="1" end="${boardDto.board_titletab }">
																			&nbsp;&nbsp;
																		</c:forEach>
																		<a href="/MyAnimals/answer.do?command=detail&boardno=${boardDto.board_seq }" id="title">${boardDto.board_title }</a>
																	</td>
																</c:otherwise>
															</c:choose>
															<td  class="col">${boardDto.member_nickname }</td>
															<td>
																<fmt:formatDate value="${boardDto.board_regdate }" pattern="YYYY/MM/dd" type="date"/>
															</td>
														    <td  class="col">${boardDto.board_views }</td>
														</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								
								<tr>
									<td colspan="5" align="right">
										<input type="button" value="write" onclick="location.href='answer.do?command=writeform'" id="write"/>
									</td>
								</tr>
							</table>
							
						<div style="float: left; width: 100%; text-align: center;">
						
						    <ul class="pagination">
						    <li>
							<%
							if(pagegroup>1){
							%>
							<a href="answer.do?command=list&page=<%=startpage-1%>"><span class="button">prev</span></a>
							<%} %>
						
							</li>
							<li>
							<%
							for(int pagenum=startpage;pagenum<=((endpage<totalpage)?endpage:totalpage);pagenum++){
							%>
							<a href="answer.do?command=list&page=<%=pagenum%>" class="page"><%=pagenum %></a>
							<%} %>
							
							<%
							if(endpage<pdto.getTotalpage()){ 
							%>
							<a href="answer.do?command=list&page=<%=endpage+1%>" class="button">next</a>
							<%} %>
							</ul>	
	
					</div>   
						    
					</div>
				</section>

			

			</div>
		</div>

<!-- 사이드바 시작  -->
<%@ include file="../form/footer.jsp" %>
	
<!-- 사이드바 끝 -->
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>

</html>

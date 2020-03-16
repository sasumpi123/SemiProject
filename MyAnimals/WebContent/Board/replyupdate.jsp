
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 댓글 답변 </title>
    
    <style type="text/css">
        #wrap {
            width: 550px;
            margin: 0 auto 0 auto;
            text-align :center;
        }
    
        #commentUpdateForm{
            text-align :center;
        }
    </style>
    
    
</head>
<body>
<div id="wrap">
    <br>
    <b><font size="5" color="gray">댓글수정</font></b>
    <hr size="1" width="550">
    <br>
 
    <div id="commentUpdateForm">
            <form action="reply.do"  method="post">
            <input type="hidden" name="command" value="rupdateres">
            <input type="hidden" name="replyno" value="${replyDto.reply_seq }">
            <input type="hidden" name="boardno" value="${replyDto.board_seq }">
            <textarea rows="7" cols="70" name="content">${replyDto.reply_content }</textarea>
            <br><br>
            <input type="submit" value="등록">
            <input type="button" value="창닫기" onclick="window.close()">
            </form>
    </div>
</div>    
</body>
</html>



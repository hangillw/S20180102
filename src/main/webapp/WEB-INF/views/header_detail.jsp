<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src = "js/jquery.js"></script> -->
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">

/* 레이아웃 css */
body {
	margin: 0px;
}

.header{
	display: inline-block;
	width:100%;
	height:70px;
	background-color: lightgray;
}

li {
	list-style: none;
}

.list_left {
	float:left;
}
</style>
</head>
<body>
<div class="header">
			<div class="left">
				<ul>
					<li class="list_left">
						<img src="" alt="logo이미지"
							 onclick='location.href="main.do"'>	
					</li>
					<li class="list_left">
						<c:if test="${chkPage !=null }">
							${chkPage }
						</c:if>
					</li>
				</ul>
			</div>
</div>
</body>
</html>
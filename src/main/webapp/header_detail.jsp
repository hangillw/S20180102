<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "js/jquery.js"></script>
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
						{회원관리/가이드관리/관리자관리}
					</li>
				</ul>
			</div>
</div>
</body>
</html>
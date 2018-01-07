<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "js/jquery.js"></script>
<link rel="stylesheet" href="bar.css">
<script type="text/javascript">
function funLoad(){
    var Cheight = $(window).height();
    $('.bar').css({'height':Cheight+'px'});
}
window.onload = funLoad;
window.onresize = funLoad;
</script>
</head>
<body>
<div class="bar">
	<ul >
		<li><a href="mb_mananger.do" class="tap1">회원관리</a></li>
		<li><a href="gd_manager.do" class="tap1">가이드관리</a></li>
		<li><a href="service_manager.do" class="tap1">상품 관리</a></li>
		<li><a href="review_manager.do" class="tap1">후기 관리</a></li>			
		<li><a href="notice_manager.do" class="tap1">공지사항 관리</a></li>
		<li><a href="QA_manager.do" class="tap1">문의사항</a></li>
	</ul>
</div>
</body>
</html>
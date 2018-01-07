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
		<li><a href="profile_member.do" class="tap1">프로필관리</a></li>
		<li><a href="wishList.do" class="tap1">위시리스트</a></li>
		<li><a href="reservation_member.do" class="tap1">나의여행</a><ol>
			<li><a href="reservation_member.do" class="tap1">예약 현황</a></li>
			<li><a href="pay_member.do" class="tap1">결제내역</a></li>
			<li><a href="review_member.do" class="tap1">후기관리</a></li></ol></li>
		<li><a href="QA_member.do" class="tap1">문의사항</a></li>
	</ul>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.inner {
		clear: both;
	}
	
	.mainPage {
		margin-left: 300px;
		margin-right: 300px;
	}
</style>
</head>
<body>
<div class="mainPage">
	<img class="mainImage" src="" alt="여행이미지">

<div>
	<dl class="inner">
		<dt>
			<h3>오늘의
			<br>
			 추천 여행지!</h3>
			 <div class="more_tour">
			 	<a class="" href="">더보기</a>
			 </div>
		</dt>
		<dd>
			<ol class="lst_tour">
				<li class="left">
					<a class="" href="">
						<img src="" alt="상품 이미지">
					</a>
					<span class="author">
						<a href="author_detail.do">
							<img alt="프로필사진" src="">
						</a><br>
						<strong>
							<a href="">닉네임</a>
						</strong>
					</span>
					<p>
						<strong><a class="call_tour" href="">상품제목</a></strong><br>
						카테고리분류명
					</p>
					<div class="option">
						<div class="time left"><a href="">소요시간</a></div>
						<div class="like left">좋아요수</div>
						<div class="remainMember left">남은 인원</div>
					</div>
				</li>
				
				<li class="left">
					<a class="" href="">
						<img src="" alt="상품 이미지">
					</a>
					<span class="authour">
						<a href="">
							<img alt="프로필사진" src="">
						</a><br>
						<strong>
							<a href="">닉네임</a>
						</strong>
					</span>
					<p>
						<strong><a class="call_tour" href="">상품제목</a></strong><br>
						카테고리분류명
					</p>
					<div class="option">
						<div class="time left"><a href="">소요시간</a></div>
						<div class="like left">좋아요수</div>
						<div class="remainMember left">남은 인원</div>
					</div>
				</li>
				
				<li class="left">
					<a class="" href="">
						<img src="" alt="상품 이미지">
					</a>
					<span class="authour">
						<a href="">
							<img alt="프로필사진" src="">
						</a><br>
						<strong>
							<a href="">닉네임</a>
						</strong>
					</span>
					<p>
						<strong><a class="call_tour" href="">상품제목</a></strong><br>
						카테고리분류명
					</p>
					<div class="option">
						<div class="time left"><a href="">소요시간</a></div>
						<div class="like left">좋아요수</div>
						<div class="remainMember left">남은 인원</div>
					</div>
				</li>
					<li class="left">
					<a class="" href="">
						<img src="" alt="상품 이미지">
					</a>
					<span class="authour">
						<a href="">
							<img alt="프로필사진" src="">
						</a><br>
						<strong>
							<a href="">닉네임</a>
						</strong>
					</span>
					<p>
						<strong><a class="call_tour" href="">상품제목</a></strong><br>
						카테고리분류명
					</p>
					<div class="option">
						<div class="time left"><a href="">소요시간</a></div>
						<div class="like left">좋아요수</div>
						<div class="remainMember left">남은 인원</div>
					</div>
				</li>
				
			</ol>
		</dd>
	</dl>
</div>






<div style="clear: both">
<br>
<br>
<br>
</div>

</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

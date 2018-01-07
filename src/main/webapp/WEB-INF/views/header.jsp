<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

.header_top {
	width: 100%;
	height: 50px;
	background-color: #3DB7CC;
}

.header_bottom {
	width: 100%;
	height: 50px;
	background-color: #FFBB00;
}

.left{
	float:left;
}

.right{
	float:right;
}

.category {
	margin-left: 50px;
}

.categoryList{
	width:100%;
	height: 400px;
	background-color : #ffffff; 
	opacity : 0.9;
	position: absolute;
	top:100px; 
	left:0px;
	border-bottom: 1px solid gray;
	display: none; 
}

/* list 관련 css */

.list_left {
	float:left;
}
.list_right {
	float:right;
}
/* 검색 관련 css */
.search {
	border-radius: 3px;
	width: 200px;
	height: 30px;
	padding: 0px 50px 0px 20px;
	outline: none;
	border: none;
}

li {
	list-style: none;
}

</style>

<script type="text/javascript">
	function openCategory() {
		$('.categoryList').toggle();
		if($('.category1').css("color")=="rgb(159, 34, 34)"){
			$('.category1').css("color","#FFA7A7");
		} else {
			$('.category1').css("color","#9F2222");
		}
	};
	
	
	function closeCategory(){
	   $('.categoryList').hide();
	};
</script>

</head>
<body>
	<div class="header_top">

			<div class="left">
				<img src="" alt="logo이미지"
					 onclick='location.href="main.do"'>	 
			</div>


			<div class="right">
				<ul>
					<li class="list_right">
						<a href="login.do" title="로그인"> 
						<img class="icon-50 user" src="images/user.png" alt="로그인 logo"
							 onmouseover="this.src='images/user_hover.png'"
						 	 onmouseout="this.src='images/user.png'">
						</a>
					</li>
					<li class="list_right">
				<form action="search.do">
					<input type="text" class="search" placeholder="검색하세용"></input> 
					<input type="submit" value="검색"></input> 

				</form>	
					 </li>				
				</ul>
			</div>
	</div>
	
	
	<div class="header_bottom">
		<div class="left" id ="category">
			<ul>
				<li class="category1 left" onclick="openCategory()">category</li>
				<li class="category left" onclick="location.href='notice.do'">공지사항</li>
				<li class="category left" onclick="location.href='QA.do'">Q&A</li>
				<li class="category left" onclick="location.href='aboutUs.do'">About us</li>
			</ul>		
		</div>
		
		
		<div class="right" >
			<ul>
				<li>인기검색어<input type="text" value="1.제주도" disabled></li>
			</ul>
		</div>
	</div>
	<form action="">
		<div class="categoryList">
			<div class ="list">
				<div class = "left">
					<ul><span>지역</span>
						<li><input type = "checkbox" name = "filter">서울</li>
						<li><input type = "checkbox" name = "filter">경기</li>
						<li><input type = "checkbox" name = "filter">인천</li>
						<li><input type = "checkbox" name = "filter">천안</li>
						<li><input type = "checkbox" name = "filter">청주</li>
					</ul>
				</div>
				<div class = "left">
					<ul><br>
						<li><input type = "checkbox" name = "filter">충청남도</li>
						<li><input type = "checkbox" name = "filter">충청북도</li>
						<li><input type = "checkbox" name = "filter">전라남도</li>
						<li><input type = "checkbox" name = "filter">전라북도</li>
					</ul>
				</div>
				<div class = "left">
					<ul><span>테마별</span>
						<li><input type = "checkbox" name = "filter"> 명소</li>
						<li><input type = "checkbox" name = "filter"> 푸드</li>
						<li><input type = "checkbox" name = "filter"> 이색투어</li>
						<li><input type = "checkbox" name = "filter"> 예술관/박물관</li>
						<li><input type = "checkbox" name = "filter"> 야경</li>
						<li><input type = "checkbox" name = "filter"> 자연</li>
						<li><input type = "checkbox" name = "filter"> 스포츠/액티비티</li>
					</ul>
				</div>
				<div class = "left">
					<ul>
						<span>인원수</span>						
						<li><input type = "checkbox" name = "filter"> 1~2인</li>
						<li><input type = "checkbox" name = "filter"> 3~5인</li>
						<li><input type = "checkbox" name = "filter"> 6인 이상</li>
					</ul>
				</div>
				<div class = "left">
					<ul><span>소요시간</span>
						<li><input type = "checkbox" name = "filter"> 여기는 스트롤바자리</li>
					</ul>
				</div>
			</div>
		<div style="clear: both; text-align: center" >
			<input type ="submit" value="검색하기">
			<input type ="button" onclick="closeCategory()" value="닫기">
		</div>
		</div>
	</form>
</body>
</html>
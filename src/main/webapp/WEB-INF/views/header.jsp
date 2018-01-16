<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Follow Me:나의 즐거운 여행 파트너</title>
<script type="text/javascript" src = "../../js/jquery.js"></script>

<style type="text/css">

/* 레이아웃 css */
body {
	margin: 0;
	padding: 0px;
}

.header_top {
	width: 100%;
	height: 50px;
	position:fixed;
	background-color: #FFFFFF;
	z-index: 1;
}

.header_bottom {
	width: 100%;
	height: 50px;
	position: absolute;
	margin-top: 50px;
	background-color: rgb(61,183,204);
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
	margin: 0px;
	width:1903px;
	height: 400px;
	background-color : #ffffff; 
	opacity : 0.9;
	position: absolute;
	top:100px; 
	left:0px;
	border-bottom: 1px solid gray;
	display: none; 
}

#user_bar {
	display:none;
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

.hearderFrm {
	margin:0px;
}

#logo {
	width: 150px;
	height: 30px;
}

div {
	display: block;
}

#loginLogo {
	width: 45px;
	height: 45px;
}
ul, p {
	margin: 0;
}

</style>

<script type="text/javascript">
	function toggleUser() {
		$('#user_bar').toggle();
	};

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
	
	function patterChk() {
		var pattern = /([^가-힣\x20])/i; 
		//var fld = "가나다라마사"; 
		var fld = $('input[name=keyword]').val();
		if (pattern.test(fld)) { 
		    alert("한글이 아닙니다. (자음, 모음만 있는 한글은 처리하지 않습니다.)"); 
		    return false;
		} 
	}
</script>

</head>
<body>
	<div class="header_top">

			<div class="left">
				<img id="logo" src="${pageContext.request.contextPath}/items/logo2.JPG" alt="logo이미지"
					 onclick='location.href="main.do"'>	 
			</div>

			
			<div class="right absolute">
				<ul>
				
					<li class="list_right">
						<!-- 로그아웃 상태 -->
						<c:if test="${loginChk == null || loginChk == 0}">						
							<a href="login.do" title="로그인"> 
							<img class="icon-50 user" src="images/user.png" alt="로그인 logo"
								 onmouseover="this.src='images/user_hover.png'"
							 	 onmouseout="this.src='images/user.png'">
							</a>
						</c:if>
						
						<!-- 로그인 상태 -->
						<c:if test="${loginChk == 1 }">
							<p class= "right" id="user" style="padding-right: 400px;" onclick="toggleUser()">
								${mbDto.nickName }<br>
							<c:if test="${manageChk ==1 }">
								관리자
							</c:if>
							<c:if test="${guideChk ==1 }">
								가이드
							</c:if>
							<c:if test="${managerChk!=1 && guideChk!=1 }">
								회원
							</c:if>
							</p>	 
							<img class= "right" onclick="toggleUser()" id= "loginLogo" src="${pageContext.request.contextPath}/userImg/${mbDto.mImg}" onerror="this.src='${pageContext.request.contextPath}/items/login.png'">
							<!-- 관리자 아님 -->
							<c:if test="${managerChk!=1}">
									<ul id="user_bar">
										<li><a href="user_info.do">프로필 관리[회원]</a></li>
										<li><a href="wishList.do">위시리스트</a></li>
										<li><a href="reservation_member.do">나의 여행</a></li>
										<li>P : ${mbDto.mPoint }</li>
										
										<!-- 가이드가 아닐 때 -->
										<c:if test="${guideChk == null || guideChk == 0 }">
											<li>가이드 등록하기</li>
										</c:if>
										
										<!-- 가이드 일 때 -->
										<c:if test="${guideChk == 1 }">
											<li><a href="profile_guide.do?gNo=${gDto.gNo }">프로필 관리[가이드]</a></li>							
											<li><a href="inGServForm.do?gNo=${gDto.gNo }">가이딩 : 상품 등록</a></li>							
											<li><a href="service_guide.do?gNo=${gDto.gNo }">나의 가이딩</a></li>							
										</c:if>
										<li><a>로그아웃</a></li>
									</ul>
							</c:if>
							<!-- 관리자 계정임 -->
							<c:if test="${manageChk==1 }">
								<ul id="user_bar">
										<li><a href="mb_List.do">회원 관리</a></li>
										<li><a href="gd_manager.do">가이드 관리</a></li>
										<li><a href="service_manager.do">상품 관리</a></li>
										<li><a href="review_manager.do">후기 관리</a></li>
										<li><a href="notice_manager.do">공지사항 관리</a></li>
										<li><a href="QA_manager.do">문의사항 관리</a></li>
								</ul>
							</c:if>
						</c:if>
					</li>
					<li class="list_right">
				<form action="search_Keyword.do" onsubmit="return patterChk()">
					<input type="text" class="search" name="keyword" placeholder="검색하세용"></input> 
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
	<form action="search_filter.do" class="hearderFrm">
		<div class="categoryList">
			<div class ="list">
				<div class = "left">
					<ul><span>지역</span>
						<li><input type = "radio" name = "areaCode" value ="01">서울</li>
						<li><input type = "radio" name = "areaCode" value ="02">부산</li>
						<li><input type = "radio" name = "areaCode" value ="03">인천</li>
						<li><input type = "radio" name = "areaCode" value ="04">대구</li>
						<li><input type = "radio" name = "areaCode" value ="05">대전</li>
						<li><input type = "radio" name = "areaCode" value ="06">광주</li>
						<li><input type = "radio" name = "areaCode" value ="07">울산</li>
						<li><input type = "radio" name = "areaCode" value ="15">제주도</li>
					</ul>
				</div>
				<div class = "left">
					<ul><br>
						<li><input type = "radio" name = "areaCode" value ="08">강원도</li>
						<li><input type = "radio" name = "areaCode" value ="09">경기도</li>
						<li><input type = "radio" name = "areaCode" value ="10">충청남도</li>
						<li><input type = "radio" name = "areaCode" value ="16">충청북도</li>
						<li><input type = "radio" name = "areaCode" value ="12">경상남도</li>
						<li><input type = "radio" name = "areaCode" value ="11">경상북도</li>
						<li><input type = "radio" name = "areaCode" value ="14">전라남도</li>
						<li><input type = "radio" name = "areaCode" value ="13">전라북도</li>
					</ul>
				</div>
				<div class = "left">
					<ul><span>테마별</span>
						<li><input type = "checkbox" name = "gServSub" value="명소"> 명소</li>
						<li><input type = "checkbox" name = "gServSub" value="음식"> 음식</li>
						<li><input type = "checkbox" name = "gServSub" value="이색"> 이색투어</li>
						<li><input type = "checkbox" name = "gServSub" value="문화"> 문화</li>
						<li><input type = "checkbox" name = "gServSub" value="자연"> 자연</li>
						<li><input type = "checkbox" name = "gServSub" value="액티비티"> 스포츠/액티비티</li>
						<li><input type = "checkbox" name = "gServSub" value="야경"> 야경</li>
						<li><input type = "checkbox" name = "gServSub" value="쇼핑"> 쇼핑</li>
						<li><input type = "checkbox" name = "gServSub" value="힐링"> 힐링</li>
					</ul>
				</div>
				<div class = "left">
					<ul><br>
						<li><input type = "checkbox" name = "gServSub" value="체험"> 체험</li>
						<li><input type = "checkbox" name = "gServSub" value="축제"> 축제</li>
						<li><input type = "checkbox" name = "gServSub" value="가족"> 가족여행</li>
						<li><input type = "checkbox" name = "gServSub" value="단체"> 단체여행</li>
						<li><input type = "checkbox" name = "gServSub" value="바다"> 바다</li>
						<li><input type = "checkbox" name = "gServSub" value="산"> 산</li>
						<li><input type = "checkbox" name = "gServSub" value="기차"> 기차</li>
					</ul>
				</div>
				<div class = "left">
					<ul>
						<span>요일별</span>						
						<li><input type = "checkbox" name = "gServDay" value="D1">월</li>
						<li><input type = "checkbox" name = "gServDay" value="D2">화</li>
						<li><input type = "checkbox" name = "gServDay" value="D3">수</li>
						<li><input type = "checkbox" name = "gServDay" value="D4">목</li>
						<li><input type = "checkbox" name = "gServDay" value="D5">금</li>
						<li><input type = "checkbox" name = "gServDay" value="D6">토</li>
						<li><input type = "checkbox" name = "gServDay" value="D7">일</li>
					</ul>
				</div>
				<div class = "left">
					<ul><span>소요시간</span>
						<li><input type = "checkbox" name = "gServLeadTime"> 여기는 스트롤바자리</li>
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
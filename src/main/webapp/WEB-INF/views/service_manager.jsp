<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="../../js/jquery.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript">
	$(function(){
		$("select").change(function(){
			var lock = $(this).val();
			$.ajax({
	            type : 'POST',
	            url  : '<%=context%>/rest/upLock.do',
				data : { lock : lock },
				success : function(data) {
					console.log(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>상품 목록</h2>
	<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
	<form action="service_manager.do">
	가이드/상품 번호<input type="search" name="searchServ" placeholder="검색" title="검색할 가이드,상품번호를 입력하세요"> 
	</form>
	<table>
		<tr>
			<th>번호</th>
			<th>상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>서비스시작일</th>
			<th>서비스종료일</th>
			<th>수정일자</th>
			<th>노출여부</th>
		</tr>
		<c:forEach var="gServ" items="${list }">
			<tr>
				<td>${num }</td>
				<td>${gServ.gServNo }<input type="hidden" id="gServNo"> </td>
				<td>${gServ.gServTitle}</td>
				<td>${gServ.gServPrice }</td>
				<td>${gServ.gServSDate }</td>
				<td>${gServ.gServEDate}</td>
				<td>${gServ.gServFixDate }</td>
				<td>
					${gServ.gServLock}
					<select name="gServLock" id="gServLock${gServ.gServNo }">
						<option id="null" value="0">변경</option>
						<option id="Y" value="${gServ.gServNo }Y">Y</option>
						<option id="N" value="${gServ.gServNo }N">N</option>
					</select>
					<!-- <script type="text/javascript">
						//$(this).closest("tr").find("input[type=hidden][value!='']").length
						//$('#gServNo').closet("tr").find("select[name='gServLock'] option[value='<c:out value="${gServ.gServNo }"/>Y']").attr("selected", "selected");
						var yn = "<c:out value="${gServ.gServLock}"/>";
						var sn = "<c:out value="${gServ.gServNo }"/>";
						var ynsn = yn+sn;
						alert($("select").val('<c:out value="${gServ.gServNo }"/>Y').text());
						if(yn == "Y" || yn == "y"){
							//$('#gServLock<c:out value="${gServ.gServNo }"/>"').val('<c:out value="${gServ.gServNo }"/>Y').attr("selected", "selected");
							//$('#gServNo').closet("tr").find("select[name='gServLock'] option[value='<c:out value="${gServ.gServNo }"/>Y']").attr("selected", "selected");
							//$("#gServLock").val('<c:out value="${gServ.gServNo }"/>Y').attr("selected", "selected");
							//$("select").val('<c:out value="${gServ.gServNo }"/>Y').attr("selected", "selected");
							//$("select[name='gServLock'] option[value="+sn+"'Y']").attr("selected", "selected");
						}else if(yn == "N" || yn == "n"){
							alert($('#gServLock<c:out value="${gServ.gServNo }"/>"').val('<c:out value="${gServ.gServNo }"/>N').text());
							$('#gServLock<c:out value="${gServ.gServNo }"/>"').val('<c:out value="${gServ.gServNo }"/>N').attr("selected", "selected");
							//$('#gServNo').closet("tr").find("select[name='gServLock'] option[value='<c:out value="${gServ.gServNo }"/>N']").attr("selected", "selected");
							//$("select").val('<c:out value="${gServ.gServNo }"/>N').prop("selected", true);
							//$("select[name='gServLock'] option[value="+sn+"'N']").attr("selected", "selected");
						}else{
							alert("오류");
						}
					</script> -->
				</td>
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</table>
	<c:if test="${pg.startPage > pg.pageBlock }">
		<a href="service_manager.do?currentPage=${pg.startPage-pg.pageBlock}&searchServ=${searchServ}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
		<a href="service_manager.do?currentPage=${i}&searchServ=${searchServ}">[${i}]</a>
	</c:forEach>
	<c:if test="${pg.endPage < pg.totalPage }">
		<a href="service_manager.do?currentPage=${pg.startPage+pg.pageBlock}&searchServ=${searchServ}">[다음]</a>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>상품 목록</h2><a href="inGServForm.do?gNo=${list[0].gNo}">등록</a>
<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<table>
	<tr><th>번호</th><th>상품번호</th><th>상품명</th><th>가격</th>
		<th>서비스시작일</th><th>서비스종료일</th><th>수정일자</th><th>노출여부</th></tr>
	<c:forEach var="gServ" items="${list }">
		<tr><td>${num }</td><td>${gServ.gServNo }</td>
		<td><a href="selGServForm.do?gServNo=${gServ.gServNo}">${gServ.gServTitle}</a></td>
			<td>${gServ.gServPrice }</td><td>${gServ.gServSDate }</td><td>${gServ.gServEDate}</td><td>${gServ.gServFixDate }</td><td>${gServ.gServLock}</td></tr>
		<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="service_guide.do?currentPage=${pg.startPage-pg.pageBlock}&gNo=${list[0].gNo}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	<a href="service_guide.do?currentPage=${i}&gNo=${list[0].gNo}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="service_guide.do?currentPage=${pg.startPage+pg.pageBlock}&gNo=${list[0].gNo}">[다음]</a>
</c:if>
</body></html>
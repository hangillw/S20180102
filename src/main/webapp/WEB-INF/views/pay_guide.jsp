<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>매출통계보기 및 조건별 매출검색</h1>
 <form action="">
 서비스 번호 검색 <input type="text" name="gServNo"><br>
 기간별 검색  시작일 : <input type="date" name="startSearch"> ~ 종료일 : <input type="date" name="endSearch">
	<input type="submit" value="검색">
</form>
<h2>기간별 매출 통계</h2>
<table>
	<tr>
	<th>매출일</th><th>총예약건수</th><th>총 결제금액</th><th>매출</th>
	</tr>
	<c:forEach var="payG" items="${payGlist }">
			<tr>
				<td>${payG.tourDate }</td>
				<td>${payG.reMemSize }</td>
				<td>${payG.reMemSize * payG.gServPrice}</td>
				<td>${payG.reMemSize * payG.gServPrice /100 * 70}</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href='//fonts.googleapis.com/css?family=Lato:100,400,700' rel='stylesheet' />
	<link href='https://fullcalendar.io/css/base.css?3.8.0-1.9.1' rel='stylesheet' />
	<link rel='stylesheet' href='https://fullcalendar.io/js/fullcalendar-3.8.0/fullcalendar.min.css' />
	<script src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js'></script>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='https://fullcalendar.io/js/fullcalendar-3.8.0/fullcalendar.min.js'></script>
	<script type="text/javascript">
		$(document).ready(function() {
	
	    $('#calendar').fullCalendar({
	    	header: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'month,agendaWeek,agendaDay,listWeek'
	          },
	          defaultDate: '2018-01-01',
	          navLinks: false, // can click day/week names to navigate views
	          editable: false,
	          eventLimit: true, // allow "more" link when too many events
	          events: [
	        	 <c:forEach var="gServ" items="${gsList }">
	        	  {
	              title: '${gServ.gServTitle}',
	              start: new Date('${gServ.tourDate}T${gServ.pickUpTime}'),
	              end: new Date('${gServ.tourDate}T${gServ.endTime}'),
	              url: 'confirmResForm.do?gServNo=${gServ.gServNo}&tourDate=${gServ.tourDate}'
	              },
	            </c:forEach>
	              {
		              title: '회식하는날',
		              start: new Date('2018-01-19'),
		         },
	            ],
		          eventClick: function(event) {
		              if (event.url) {
		            	  cw=screen.availWidth;     //화면 넓이
		            	  ch=screen.availHeight;    //화면 높이

		            	  sw=640;    /* 띄울 창의 넓이 */
		            	  sh=400;    /* 띄울 창의 높이 */
		            	  ml=(cw-sw)/2;        /* 가운데 띄우기위한 창의 x위치 */
		            	  mt=(ch-sh)/2;        /* 가운데 띄우기위한 창의 y위치 */
		                  window.open(event.url, "네이버새창", "width="+sw+", height="+sh+", left="+ml+", top="+mt+", toolbar=no, menubar=no, scrollbars=no, resizable=yes");
		                  return false;
		              }
		          }
	    });
	
	});
</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

</style>
				
</head>
<body>
	
	<div id='calendar'></div>
</body>
</html>
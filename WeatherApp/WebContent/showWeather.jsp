<%@page import="cookies.ApiCookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.weatherBean" %>
    <%@page import="cookies.ApiCookie" %>
    
    
<!DOCTYPE html>
<html lang="en" >
<head>
<meta charset="UTF-8">
<title>Show weather</title>
</head>
<body>


<p id="date" ></p>


<%

weatherBean wBean = (weatherBean)request.getAttribute("wBean");

out.print(wBean.getCityStr()+" "+ wBean.getcloudsStr()+ " " + wBean.getspeedStr());


%>

<%

Cookie cookie[] = request.getCookies();
	if (cookie.length > 1) {
	
		for(int i =0; i< cookie.length; i++) {
			String temp = cookie[i].getValue();
			
			out.print("<p>"+ ApiCookie.cleanCookie(temp) + "</p>");
		}
}

%>



<script src="weatherJS.js"></script>
</body>
</html>
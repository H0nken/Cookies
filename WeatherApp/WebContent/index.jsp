<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
<meta charset="UTF-8">

  <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
  <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
	

	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


<title>Start</title>
</head>
<body>



 <form action="OWservlet" method="get">  
    City: <input type="text" name="city"/>
    Country (Language code):<input type="text" name="country"/>
    <br>
    <br>  
    
    <input class="mdc-button mdc-button--raised" type="submit" value="Search"/>  
    </form>
    
      

<br>



 
</body>
</html>
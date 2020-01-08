<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<c:import url="./template/boot.jsp"></c:import>

</head>
<body>

<c:import url="./template/nav.jsp"></c:import>

<div class="container">
	<form action="./"> 
		<select name="lang">
			<option>ko</option>
			<option>en</option>
		</select>	
		<button>change</button>
	</form>

	<h1> I n d e x </h1>

	<h1> 


	</h1>

	<img alt="은우,,," src="./images/cha2.jpg">
	
	<h1> 你好</h1>
</div>

</body>
</html>
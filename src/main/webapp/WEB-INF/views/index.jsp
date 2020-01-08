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

	<h1> I n d e x </h1>
	<h1><spring:message code="hello"/></h1>
		<c:if test="${not empty member}">
			<h1><spring:message code="login.Message" arguments="${member.id}" /></h1>
		</c:if>

	<img alt="은우,,," src="./images/cha2.jpg">
	
	<h1> 你好</h1>
</div>

</body>
</html>
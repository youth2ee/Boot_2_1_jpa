<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My page</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container"> 
<h1>M y P a g e</h1>

<%-- <img alt="" src="../upload/${file.fname}" style="width: 200px;"> --%>
<hr>

<h1>ID : ${member.id}</h1>
<h1>NAME : ${member.name}</h1>
<h1>EMAIL : ${member.email}</h1>

<hr>

<c:forEach items="${file}" var="files">
<h1>${files.oname}</h1>
</c:forEach>


<%-- <a class="btn btn-primary" href="./memberFileDown?fnum=${file.fnum}">File Down</a> --%>
</div>


</body>
</html>
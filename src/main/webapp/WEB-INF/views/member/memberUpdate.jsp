<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>M y P a g e : U p d a t e</h1>

<hr>

<div style="float: left; margin-bottom: 20px; width: 50%;"> 
<img alt="" src="../upload/${file.fname}" style="width: 500px;">
</div>

<div style="float: left; margin-left: 30px;"> 
<form:form action="./memberUpdate" method="post" enctype="multipart/form-data" modelAttribute="membersVO">
	<div class="form-group">
      <label for="id">ID:</label>
      <form:input path="id" class="form-control" id="id" readonly="true" />
      <div style="height: 8px;"> <form:errors path="id" /> </div>
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <form:password path="pw" class="form-control" id="pw" placeholder="Enter password" />
      <div style="height: 8px;"> <form:errors path="pw" /> </div>
    </div>
    
    <div class="form-group">
      <label for="pw2">Password:</label>
       <form:password path="pw2" class="form-control" id="pw2" placeholder="Enter password" />
       <div style="height: 8px;"> <form:errors path="pw2" /> </div>
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control" id="name" />
      <div style="height: 8px;"> </div>
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
       <form:input path="email" class="form-control" id="email" />
       <div style="height: 8px;"> <form:errors path="email" /> </div>
    </div>
    
    <div class="form-group">
      <label for="files">File:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
    

</div>

<hr style="clear: both;">

   <button type="submit" class="btn btn-default">Submit</button>
</form:form>



<%-- <a class="btn btn-primary" href="./memberFileDown?fnum=${file.fnum}">File Down</a> --%>
</div>


</body>
</html>
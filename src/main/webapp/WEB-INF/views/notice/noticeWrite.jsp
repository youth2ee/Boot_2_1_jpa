<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Write</title>

<c:import url="../template/boot.jsp" />
<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

</head>
<body>

<c:import url="../template/nav.jsp" />



<div class="container">
<h1>N o t i c e</h1>
<hr>
<h2>W R I T E</h2>

	<form:form action="./noticeWrite" method="post" modelAttribute="noticeVO" enctype="multipart/form-data">
	<div class="form-group">
      <!-- path(memberVO의 변수명) = name -->
      <label for="title">title:</label>
      <form:input path="title" placeholder="Enter title" class="form-control" id="title" />
     
      <div style="height: 20px;"> <form:errors path="title" cssStyle="color:red; " /> </div>
    </div>
    
    <div class="form-group">
      <label for="writer">writer:</label>
      <form:input path="writer" class="form-control" id="writer" placeholder="Enter writer" />
       <div style="height: 20px;"> <form:errors path="writer" cssStyle="color:red; " /> </div>
    </div>
    
    <div class="form-group">
      <label for="contents">contents:</label>
      <form:textarea path="contents" class="form-control" id="contents" placeholder="Enter contents" />
       <div style="height: 20px;"> <form:errors path="contents" cssStyle="color:red; " /> </div>
    </div>
    
<!--         <div class="form-group">
      <label for="files">File:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
     -->
     		<div id="files_d">
			<div class="form-group" title="parent">
      		<label for="files">File:</label>
     		 <input type="file" class="form-control" id="files" name="files">
				<input type="button" class="btn btn-danger del" value="del">
			</div>
		</div>
    
    <input type="button" class="btn btn-success" value="ADD FILE" id="add">
    
    
	<button type="submit" class="btn btn-default">Submit</button>
	
	</form:form>



</div>

<script type="text/javascript">


$("#contents").summernote();

var files = $("#files_d").html();
var count = 1;
/* var index = 0; //인덱스번호 사용하기 */
/* $("#files_d").empty(); */

	$("#add").click(function() {
		if (count < 5) {
			$("#files_d").append(files);
			count++;
		} else {
			alert("파일추가는 최대 5개까지 가능합니다.")
		}
	});
	
	$("#files_d").on("click", ".del", function() {
			count--;
			$(this).parents(".form-group").remove();				
	});
	 





</script>




</body>
</html>
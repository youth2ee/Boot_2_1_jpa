<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />

</head>
<body>

<c:import url="../template/nav.jsp" />


<div class="container">
<h1>B o a r d : ${board} L I S T</h1>
<hr>
		<div>
			<form action="./${board}List" id="frm">
				 <input type="hidden" value="0" name="curPage" id="curPage">
			
				<select name="category">				
					<option id="title" value="title">제목</option>
					<option id="writer" value="writer">작성자</option>
					<option id="contents" value="contents">내용</option>
				</select>
			
				<input type="text" name="search" value="${search}">
				
				<button>검색</button>
			</form>
		</div>

	<table class="table table-hover"> 
	<tr>
		<td>num</td>
		<td>title</td>
		<td>writer</td>
		<td>date</td>
		<td>hit</td>
<!-- 		<td>file</td> -->
	</tr>
	
	<c:forEach items="${list}" var="lists"> 
    <tr>
    	<td>${lists.num}</td>
    	<td> <a href="./${board}Select?num=${lists.num}" class="list-group-item">${lists.title}</a></td>
    	<td>${lists.writer}</td>
    	<td>${lists.regDate}</td>
    	<td>${lists.hit}</td>
<%--     	<td>
    		<c:forEach items="${lists.noticeFilesVOs}" var="f">
    			${f.fname}
    		</c:forEach>
    	</td> --%>
    </tr>
    
   </c:forEach>

	</table>
	
	<!-- <a href="./noticeList?curPage=1">1</a> -->
	
	<ul class="pagination" style="margin: 0 auto; text-align: center;">
	
	<c:if test="${page.number gt 0}">
		<li><a href="./${board}List?curPage=${page.number-1}">이전</a></li>
	</c:if>
	
	<c:if test="${page.totalPages != 1}"> 
	<c:forEach begin="0" end="${page.totalPages-1}" varStatus="status">
		<li><a href="./${board}List?curPage=${status.index}">${status.index+1}</a></li>
	</c:forEach>
	</c:if>
	
	<c:if test="${page.number lt page.totalPages-1}">
		<li><a href="./${board}List?curPage=${page.number+1}">다음</a></li>
	</c:if>
	
	
	</ul>
	


</div>

	<script type="text/javascript">
	 	var category = '${category}';
		if (category == '') {
			category = "title";
		}
		
		$("#"+category).prop("selected", true);
	 
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%@ include file="/template/common/board.jsp" %>
<script>
$(document).ready(function(){
	$("#writeBtn").click(function() {
		$("#act").val("mvwrite");
		$("#pg").val("1");
		$("#key").val("");
		$("#word").val("");
		$("#commonform").submit();
	
	});
});
</script>

			<h3 style="padding-left: 15px; padding-bottom: 10px;">자유게시판</h3>
			<div class="container" align="center">
				<table>
				<tr>
					<td colspan="5" style="text-align: rigth;">
					새글 <strong>${navigator.newArticleCount}</strong>/전체글 <strong>${navigator.totalArticleCount}</strong>
					</td>
				</tr>
				</table>
				<table>
				<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>날짜</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${articleList}">
					<tr>
						<td>${article.seq}</td>
						<td class="alsubject">${article.subject}</td>
						<td>${article.name}</td>
						<td>${article.hit}</td>
						<td>${article.logtime}</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				<table>
				<tr>
					<td colspan="5" style="text-align: rigth;">
					현재 <strong>${navigator.pageNo}</strong>/전체글 <strong>${navigator.totalPageCount}</strong> pages
					</td>
				</tr>
				</table>
	 			<div class="input-group" style="padding-top: 15px; width: 60%">
	 	 			<select name="key" id="key" class="custom-select mb-3">
					    <option value="subject">제목</option>
					    <option value="content">내용</option>
					    <option value="name">작성자</option>
					</select>
	  				<input type="text" name="word" id="word" class="form-control" placeholder="Search">
			 		<button class="btn btn-default" type="button" id="searchBtn">
	 		  			<i class="fas fa-fw fa-search"></i>
	 		  		</button> 		  
				 	<button type="button" id="writeBtn" class="btn btn-success" style="background-color:gray; border-color: gray;	width: 80px; height: 40px; font-size: 15px;">글쓰기</button>
				</div>
	
				${navigator.navigator}
  			</div>
<%@ include file="/template/bottom.jsp" %>
	   		
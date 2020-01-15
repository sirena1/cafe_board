<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%@ include file="/template/common/logincheck.jsp" %>
<%@ include file="/template/common/board.jsp" %>

<c:if test="${article == null}">
<script>
alert("글이 삭제 되었거나 잘못된 URL 접근입니다.");
$(location).attr("href", "${root}/")
</script>
</c:if>
<script>
$(document).ready(function () {
	$("#newBtn").click(function() { //새글쓰기
		$("#act").val("mvwrite");
		$("#pg").val("1");
		$("#key").val("");
		$("#word").val("");
		$("#commonform").submit();	
	});
	
	$("#reBtn").click(function() { 
		$("#act").val("mvreply");
		$("#pg").val("1"); //1페이지로 보내기
		$("#key").val("");
		$("#word").val("");
		$("#commonform").submit();	
	});
	
	$("#firstBtn").click(function() {
		$("#act").val("list");
		$("#pg").val("1"); 
		$("#key").val("");
		$("#word").val("");
		$("#commonform").submit();	
	});
	
	$("#preBtn").click(function() { 
		$("#act").val("list");
		$("#commonform").submit(); 
	});
	
	$("#reBtn").click(function() {
		$("#act").val("mvreply");
		var input = $('<input>').attr('type', 'hidden').attr('name', 'seq').attr('value', '${article.seq}');
		$('#commonform').append(input).submit();
	});
	
	$("#mvModifyBtn").click(function() {
		$("#act").val("mvmodify");
		var input = $('<input>').attr('type', 'hidden').attr('name', 'seq').attr('value', '${article.seq}');
		$('#commonform').append(input).submit();
	});
});
</script>
    		<h3 style="padding-left: 15px; padding-bottom: 10px;">글보기</h3>
      		<div class="container" align="center" style="width: 80%;">
	  			<div class="form-group" align="left">
	  				<table>
	  					<tr>
	  						<td style="text-align: left;">
	  						<button type="button" id="newBtn" class="btn btn-secondary">새글</button>
	  						<button type="button" id="reBtn" class="btn btn-secondary">답글</button>
	  					<c:if test="${userInfo.id == article.id}">
	  						<button type="button" id="mvModifyBtn" class="btn btn-secondary btn-sm" >수정</button>
	  						<button type="button" id="deleteBtn" class="btn btn-secondary btn-sm">삭제</button>
	  					</c:if>
	  						</td>
	  						<td style="text-align: right;">
	  						<button type="button" id="firstBtn" class="btn btn-link">최신목록</button>
	  						<button type="button" id="preBtn" class="btn btn-link">이전목록</button>
	  						</td>
	  					</tr>
	  				</table>
	  				<table>
				  		<tr>
				  			<td style="text-align: left;" colspan="3"><strong>${article.seq}. ${article.subject}</strong></th>
				  		</tr>
				  		<tr>
				  			<td>${article.name}</td>
				  			<td>조회수 : ${article.hit}</td>
				  			<td>작성일 : ${article.logtime}</td>				  			
				  		</tr>
				  	</table>
				</div>
	  			<div class="form-group" align="left">
	  				<p>${article.content}</p>
	    		</div>	
	    		<br>  
	  			<div align="center">
			  		<button type="submit" class="btn btn-primary">추천!</button>
	  			</div>
	  			<div align="right">
					<div class="dropdown">
				  		<button type="button" class="btn dropdown-toggle" data-toggle="dropdown" style="font-size: 15px;">이 글을..</button>
				  		<div class="dropdown-menu">
						    <a class="dropdown-item" href="#">수정</a>
						    <a class="dropdown-item" href="#">신고</a>
						    <a class="dropdown-item" href="#">공유</a>
						    <a class="dropdown-item" href="#">복사</a>
			  			</div>
					</div>
	  			</div>
	  			<div>
		 		 	<div align="left">
		      			<input type="text" class="form-control"	placeholder="댓글입력..." name="comment" id="comment"	style="width: 90%; float: left;">
		      		</div>      			
	      			<div align="right" style="float: left; padding-left: 10px;">
						<button class="btn btn-secondary">입력</button>
					</div>
	  			</div>

		  		<div id="comment">
		  			<br>
		  			<label class="comment_bar">손흥민</label>
		  			<label class="comment">손흥민 골~</label>
		  		</div>
			</div>

<%@ include file="/template/bottom.jsp" %>
	   		
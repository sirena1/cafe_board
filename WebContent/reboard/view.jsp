<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%@ include file="/template/common/logincheck.jsp" %>

<c:if test="${article == null}">
<script>
alert("글이 삭제 되었거나 잘못된 URL 접근입니다.");
$(location).attr("href", "${root}/")
</script>
</c:if>

<%@ include file="/template/common/board.jsp" %>
<style>
.comment_bar {

	background-color: #e6e6e6;
	padding: 5px;
	border-radius: 8px;
	width: 100%; 
	font-size: 15px;
	text-align: left;
}

.comment {
	
	width: 100%;
	font-size: 15px;
	align-content: left;
	text-align: left;
	padding-left: 15px;
}
</style>
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
	
	$.ajax({
	    url: '${root}/memo',
	    type: 'GET',
	    data: {act: 'list', seq: '${article.seq}'},
	    dataType: 'json',
	    success: function(data){
	    	makeList(data);
	    }
	});
	
	$("#mwriteBtn").click(function(){
		var mcontent = $("#mcontent").val();
		$("#mcontent").val(''); //얻어오자마자 지워라
		if(mcontent != ''){
			$.ajax({
			    url: '${root}/memo',
			    type: 'POST',
			    data: {act: 'write', seq: '${article.seq}', mcontent: mcontent},
			    dataType: 'json',
			    success: function(data){
					makeList(data);
			    }
			});
		}
	});
	/* 동적으로 만들어진 component들은 처리할 수 없다... */
	$(document).on("click", ".mdeleteBtn", function() {
		$.ajax({
		    url: '${root}/memo',
		    type: 'GET',
		    data: {act: 'delete', seq: '${article.seq}', mseq: $(this).attr('data-mseq')},
		    dataType: 'json',
		    success: function(data){
		    	makeList(data);
		    }
		});
	});
	
	$(document).on("click", ".mmodifyBtn", function() {
		var mseq = $(this).attr("data-mseq");
		$("#div" + mseq).css("display", "none");
		$("#mdiv" + mseq).css("display", "");
	});
});

function makeList(data){ //data가 json이다.
	var mlist = data.memolist;
	var len = mlist.length;
	var list = '';
	for(var i=0;i<len;i++) {
    	list += '<div id="div' + mlist[i].mseq + '">';
    	list += '	<label class="comment_bar">';
    	list += mlist[i].name + ' (' + mlist[i].mtime + ')';
    	if('${userInfo.id}' == mlist[i].id){
    		list += '<a href="#" class="mmodifyBtn" data-mseq="' + mlist[i].mseq +'">수정</a>';
    		list += '<a href="#" class="mdeleteBtn" data-mseq="' + mlist[i].mseq +'">삭제</a>';
    	}
    	list += '</label>';
    	list += '	<label class="comment">' + mlist[i].mcontent + '</label>';
    	list += '</div>';
    	
    	list += '<div id="mdiv' + mlist[i].mseq + '" style="display: none">';
    	list += '<div class="input-group" align="left">';
    	list += '<textarea class="form-control" rows="3" id="mcontent' + mlist[i].mseq + '">' + mlist[i].mcontent +'</textarea>';
    	list += '<button type="button" class="btn btn-secondary modify">수정</button>';
    	list += '<button type="button"  class="btn btn-secondary cancel">취소</button>';
    	list += '</div>';
	}
	$("#comment").html(list);
}
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
		 		 	<div class="input-group" align="left">
		      			<textarea class="form-control" rows="3" id="mcontent"></textarea>
						<button type="button" id="mwriteBtn" class="btn btn-secondary">입력</button>
					</div>
	  			</div>
		  		<div id="comment"></div>
			</div>

<%@ include file="/template/bottom.jsp" %>
	   		
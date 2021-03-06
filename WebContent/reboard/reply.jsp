<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%@ include file="/template/common/logincheck.jsp" %>
<%@ include file="/template/common/board.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>
<script>
$(document).ready(function(){
	$("#writeBtn").click(function() {
		if($("#subject").val() == ''){
			alert("제목 입력!!!!");
			return;
		} else if($("#summernote").val() == ''){
			alert("내용 입력!!!!");
			return;
		} else {
			$("#writeform").attr("method", "post").attr("action", "${root}/reboard").submit();
		}
	});
	var sumcontent = '<br><br>';
	sumcontent += "<p>------------------------------------------[원글]</p>"
	sumcontent += "${article.content}";
	$('#summernote').summernote('code', sumcontent);
});
</script>
    	<h5 style="padding-left: 15px; padding-bottom: 10px;">글수정</h5>
    	<form id="writeform">
    	<input type="hidden" name="act" value="reply">
    	<input type="hidden" name="bcode" value="${param.bcode}">
    	<input type="hidden" name="pg" value="${param.pg}">
    	<input type="hidden" name="key" value="${param.key}">
    	<input type="hidden" name="word" value="${param.word}">
    	<input type="hidden" name="ref" value="${article.ref}">
    	<input type="hidden" name="lev" value="${article.lev}">
    	<input type="hidden" name="step" value="${article.step}">
    	<input type="hidden" name="pseq" value="${article.seq}"> <!-- 원글의 글번호랑 같다 -->
    	<div class="container" style="width: 80%;">
			<div class="form-group" align="left" style="margin: 0px;">
				
	   		</div>
	   		<div class="form-group" align="left">
				<input type="text" class="form-control" value=" RE : ${article.subject}" name="subject" id="subject">
	  		</div>
	  		<textarea id="summernote" name="content"></textarea>
	  		<script>
				$('#summernote').summernote({
					placeholder: '',
					tabsize: 2,
					height: 500
				});
    		</script>
	  
      		<button type="button" id="writeBtn" class="btn btn-primary">글작성</button>
	  		<button type="reset" class="btn btn-warning">초기화</button>
		</div>
		</form>

<%@ include file="/template/bottom.jsp" %>
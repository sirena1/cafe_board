<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>

    	<h3 style="padding-left: 15px; padding-bottom: 10px;">글쓰기</h3>
    	<div class="container" style="width: 80%;">
			<div class="form-group" align="left" style="margin: 0px;">
				<select name="cars" class="custom-select mb-3">
					<option selected>게시판 선택</option>
			      	<option value="fiat">자유게시판</option>
			      	<option value="audi">익명게시판</option>
				</select>
	   		</div>
	   		<div class="form-group" align="left">
				<input type="text" class="form-control" placeholder="제목 입력..." name="title" id="title">
	  		</div>
	  		<div id="summernote"></div>
	  		<script>
				$('#summernote').summernote({
					placeholder: 'Hello Bootstrap 4',
					tabsize: 2,
					height: 500
				});
    		</script>
	  
      		<button type="submit" class="btn btn-primary">글작성</button>
	  		<button type="reset" class="btn btn-warning">초기화</button>
		</div>


<%@ include file="/template/bottom.jsp" %>
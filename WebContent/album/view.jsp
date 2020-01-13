<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%@ include file="/template/common/logincheck.jsp" %>
<%@ include file="/template/common/board.jsp" %>

    		<h3 style="padding-left: 15px; padding-bottom: 10px;">글보기</h3>
      		<div class="container" align="center" style="width: 80%;">
	  			<div class="form-group" align="left">
	  				<table>
				  		<tr>
				  			<td style="text-align: left;" colspan="3"><strong>글번호. 제목인거시여</strong></th>
				  		</tr>
				  		<tr>
				  			<td>작성자</td>
				  			<td>조회수 : 0</td>
				  			<td>작성일 : 20.01.07</td>				  			
				  		</tr>
				  	</table>
				</div>
	  			<div class="form-group" align="left">
	  				<p>내용에 들어갈 내용</p>
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
	   		
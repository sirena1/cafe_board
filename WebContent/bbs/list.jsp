<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			<h3 style="padding-left: 15px; padding-bottom: 10px;">자유게시판</h3>
			<div class="container" align="center">
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
					<c:forEach varStatus="i" begin="0" end="20">
					<tr>
						<td>${i.count}</td>
						<td class="alsubject">제목입니다.</td>
						<td>작성자</td>
						<td>조회수</td>
						<td>날짜</td>
					</tr>
					</c:forEach>
				</tbody>
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
	
				<div class="pagination" style="padding-top: 10px">
					<a href="#">&laquo;</a>
					<c:forEach varStatus="i" begin="0" end="10">
						<c:choose>
							<c:when test="${i.index == 3}">
								<a href="#" class="active" >${i.count}</a>
							</c:when>
							<c:otherwise>
								<a href="#">${i.count}</a>
						  	</c:otherwise>
						</c:choose>
					</c:forEach>
					<a href="#">&raquo;</a>
				</div>
  			</div>
<%@ include file="/template/bottom.jsp" %>
	   		
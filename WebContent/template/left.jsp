<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function() {
	$("#categoryOpen").click(function() {
		$(this).parent().siblings('li').children('div.tab-content').slideDown(100); //시간
		$(this).css('display', 'none');
		$("#categoryClose").css('display', '');
	});
	
	$("#categoryClose").click(function() {
		$(this).parent().siblings('li').children('div.tab-content').slideUp(100); //시간
		$(this).css('display', 'none');
		$("#categoryOpen").css('display', '');
	});
	
	$("#board_menu a.category_name").click(function() {
		$(this).siblings('div.tab-content').slideDown(500).parent().siblings('li').children('div.tab-content').slideUp(500);
	});
	
	$(".movelist").click(function() {
		/* 컨트롤러를 가야 한다. */
		var bcode = $(this).attr('data-bcode'); 
		var control = $(this).attr('data-control'); 
		alert(bcode + "         " + control);
		var url = '${root}/' + control + '?act=mvwrite&bcode=' + bcode + "&pg=1&key=&word=";
		$(location).attr('href',url);
	});
});
</script>
      <ul id="board_menu" class="sidebar navbar-nav">
         <li>
            <a id="categoryOpen" data-toggle="pill" style="color:white; display:none;">모든 게시판 펼치기</a>   
            <a id="categoryClose" data-toggle="pill" style="color:white;">모든 게시판 접기</a>   
         </li>
         <c:set var="cflag" value="0"></c:set>
         <c:forEach var="board" varStatus="i" items="${menu}" >
         <c:if test="${cflag != board.ccode}">
         <c:set var="cflag" value="${board.ccode}"/>
         <li>
            <a href="#" class="category_name" data-toggle="pill" style="background: #5a5a5a;">${board.cname}</a>
            <div class="tab-content">
               <div id="menu">
                  <ul>
         </c:if>
                     <li style="margin-left: 2%">
                        <a href="#" class="movelist" style="font-size: 10pt" data-control="${board.control}" data-bcode="${board.bcode}">${board.bname}</a>
                     </li>
         <c:if test="${i.index < menu.size()-1}">
            <c:if test="${cflag != menu.get(i.index + 1).ccode }">
                  </ul>
               </div>
            </div>
         </li>
            </c:if>
         </c:if>
         </c:forEach>
            </div>
            </div>
         </li>
      </ul>
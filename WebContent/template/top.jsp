<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${root}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${root}/css/sb-admin.css" rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script src="${root}/vendor/jquery/jquery.min.js"></script>
<script src="${root}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${root}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${root}/js/sb-admin.min.js"></script>

<style type="text/css">
table {
  border-collapse: collapse;
  width: 100%;
  
}

th {
  text-align: center;
  padding: 8px;

}

td {
	text-align: center;
	padding: 8px;
}

td.alsubject {
	text-align: left;
	font-weight: bold;
	padding: 8px;
}

tr:nth-child(even) {background-color: #d9d9d9;}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: gray;
  color: white;
  border-radius: 5px;
}

.memberinfo {
	color: white;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="${root}">Kitri</a>
		<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
	    </button>
	    <!-- Navbar Search -->
	     <c:if test="${userInfo == null }">
    	<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<label class="memberinfo">
					<a href="${root}/user?act=mvjoin">회원가입</a>
				</label>
				<label class="memberinfo">
					<a href="${root}/user?act=mvlogin">로그인</a>
				</label>
			</div>
		</form>
	    </c:if>
	    <c:if test="${userInfo != null}">
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
         <div class="input-group">
            <label class="memberinfo">
               ${userInfo.name}님 안녕하세요
            </label>
         
         </div>
      </form>
   
       <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
         <li class="nav-item dropdown no-arrow">
         <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
           </a>
         <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="${root}/user?act=mvmodify">회원정보수정</a>
                <a class="dropdown-item" href="${root}/user?act=logout">로그아웃</a>
           </div>
            </li>
      </ul>
      </c:if>
	</nav>
	<div id="wrapper">
	
<!-- Sidebar -->
<%@ include file="/template/left.jsp" %>
		<div id="content-wrapper">
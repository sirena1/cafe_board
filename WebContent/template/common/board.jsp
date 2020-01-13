<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="bcode" value="${param.bcode}"/>
<c:set var="pg" value="${param.pg}"/>
<c:set var="key" value="${param.key}"/>
<c:set var="word" value="${param.word}"/>


<form name="commonform" id="commonform" method="get">
	<input type="hidden" name="act" id="act" value="">
	<input type="hidden" name="bcode" id="bcode" value="${bcode}">
	<input type="hidden" name="pg" id="pg" value="${pg}">
	<input type="hidden" name="key" id="key" value="${key}">
	<input type="hidden" name="word" id="word" value="${word}">
</form>
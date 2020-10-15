<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:requestEncoding value="utf-8"/>


<h1 style="font-weight: bold;">${fn:substring(caldetail.rdate,0,4)}년 ${fn:substring(caldetail.rdate,4,6)}월 ${fn:substring(caldetail.rdate,6,8)}일의 일정</h1>

<table class="list_table" style="width:85%;">

<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	

	<tr>
		<th>일정 제목</th>
		<td style="text-align: left">${caldetail.title}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td style="text-align: left">${fn:substring(caldetail.wdate,0,4)}년 ${fn:substring(caldetail.wdate,5,7)}월 ${fn:substring(caldetail.wdate,8,10)}일 </td>
	</tr>
	<tr>
		<th>내용</th>
		<td style="text-align: left"><textarea rows="10" cols="50" 
		name='content' id="_content" readonly="readonly">${caldetail.content}</textarea></td>
	</tr>
	
</tbody>
</table>

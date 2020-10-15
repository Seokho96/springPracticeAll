<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
td{
  bgcolor:#d2f6c5
}
</style>

    <div id="_youtube_">
	<iframe id="_youtube" width="640" height="360" src="http://www.youtube.com/embed/" 
		frameborder="0"	allowfullscreen>	
	</iframe>
</div>

<table class="list_table" style="width: 85%">
<colgroup>
	<col style="width:70px"><col style="width:auto"><col style="width:100px"><col style="width:30px"><col style="width:40px">
</colgroup>

<thead>
	<tr>
		<th>번호</th><th>제목</th><th>유튜브 고유번호</th><th>저장</th><th></th>
	</tr>
</thead>

<tbody>

<c:if test="${empty savelist }">
<tr>
	<td colspan="4">저장된 목록이 없습니다</td>
</tr>	
</c:if>

<c:forEach items="${savelist }" var="you" varStatus="vs">

<tr class="_hover_tr">
	<td>${vs.count }</td>
	<td style="text-align: left;">
		<div class="c_vname" vname="${you.url}">${you.title }</div>
	</td>
	<td>${you.url}</td>	 
	<td>
		<img alt="" src="image/save.png" class="ck_seq" id="${you.url}"
			loginIn='${login.id}' title="${you.title}">
	</td>
	<td>
	   <a href="#none" onclick="deleteList()" style="text-decoration: none" >삭제</a>
	   <form id="deleteFrm" method="post">
	     <input type="hidden" value="${you.seq }" name="seq">
	   </form>
	</td>
	
</tr>

</c:forEach>

</tbody>

</table>


<script>

$(document).ready(function(){
	$("#_youtube_").hide();

	$("._hover_tr").mouseover(function() {
		$(this).children().css("background-color", "#f0f5ff");
	}).mouseout(function() {
		$(this).children().css("background-color", "#ffffff");
	});	
});


$(".c_vname").click(function(){
	$("#_youtube_").show();
	$("#_youtube").attr("src", "http://www.youtube.com/embed/" + $(this).attr("vname"));	
});

function deleteList(){
	let choice = confirm("삭제하시겠습니까?");
	if(choice){
         $("#deleteFrm").attr("action","youdelete.do").submit();
		}else{

			}
}
</script>
    
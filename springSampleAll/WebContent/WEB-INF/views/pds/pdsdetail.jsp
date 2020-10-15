<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<form name="frmForm" id="_frmForm">

<input type="hidden" name="seq" value="${pdsDetail.seq}"/>

<table class="list_table" style="width:85%;">

<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	
	<tr class="id">
		<th>아이디</th>
		<td style="text-align: left">${pdsDetail.id}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td style="text-align: left">${pdsDetail.title}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td style="text-align: left">${pdsDetail.regdate}</td>
	</tr>
	<tr>
	<th>조회수</th><td style="text-align: left">${pdsDetail.readcount }</td>	
	</tr>
	<tr>
	  <th>다운로드 수</th><td style="text-align: left">${pdsDetail.downcount }</td>
	</tr>
	<tr>
	   <th>파일</th>
	   <td style="text-align: left">
	      <a href="#none" onclick="filedown('${pdsDetail.filename}', '${pdsDetail.seq}')">
	       ${pdsDetail.oldfilename }</a>
	   </td>
	</tr>
	<tr>
		<th>내용</th>
		<td style="text-align: left"><textarea rows="10" cols="50" 
		name='content' id="_content" readonly="readonly">${pdsDetail.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="height:50px; text-align:center;">
		<span>
			<c:if test="${pdsDetail.id eq login.id}">
			<a href="#none" id="_btnUpdate" title="글수정하기"><img src="image/bupdate.png" alt="수정하기" /></a>
			<a href="#none" id="_btnDel" title="삭제하기"><img src="image/del.png" alt="삭제하기" /></a>
			</c:if>
			<a href="#none" id="_answer" title="답글달기"><img src="image/breply.png" alt="답글달기" /></a>
		</span>
		</td>
	</tr>
</tbody>
</table>

</form>
    <form name="file_Down" action="fileDownload.do" method="post" >
    <input type="hidden" name="filename">
    <input type="hidden" name="seq">
</form>

<form id="_frm" method="post">   
<div id="_answerView">
<a href="#none" id="_answerClose">[답글 닫기]</a>
<br>
<table class="list_table" style="width: 85%">
       <colgroup>
          <col style="width: 70px">
          <col style="width: auto">
       </colgroup>
        <tr>
        <th>작성자</th>
        <td><input type="text" name="id" value="${login.id }"></td>
        </tr>
        <tr>
         <th>제목</th>
         <td><input type="text" id="_title" name="title"></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea rows="20" cols="90" name="content" id="_content"></textarea> </td>
        </tr>
        
    </table>
    <span class="button blue">
     <button type="button" id="_answerWrite">글작성</button>
     </span> 
     </div>
     </form>

  <script type="text/javascript">
  $(document).ready(function() {
	     $("#_answerView").hide();
	     
   if("${login.id }" != "${bbsdetail.id }"){
 	  $("#_delete").hide();
 	  $("#_update").hide();
      }

 $("#_answer").click(function() {
 	  $("#_answerView").show();
 });

 $("#_answerClose").click(function() {
 	 $("#_answerView").hide();
 });
  });
  function filedown( filename , seq ){
	  //  alert(filename);
		  let doc = document.file_Down;
		  doc.filename.value = filename;
		  doc.seq.value = seq;
		  doc.submit(); 
		  
		
	}

$("#_btnUpdate").click(function() {	
	alert('글수정하기');		
	$("#_frmForm").attr({ "target":"_self", "action":"pdsupdate.do", "method":"get" }).submit();
});
$("#_btnReply").click(function() {	
	alert('답글달기');	
	$("#_frmForm").attr({ "target":"_self", "action":"answer.do" }).submit();
});
$("#_btnDel").click(function() {			
	$("#_frmForm").attr({ "target":"_self", "action":"pdsdelete.do", "method":"post" }).submit();
});

</script>
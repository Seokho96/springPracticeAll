<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">
   
   <form name="frmForm1" id="_frmFormSearch" method="post">
      
      <table style="margin-left: auto; margin-right: auto; margin-top: 3px ; margin-bottom: 3px">
         <tr>
            <td>검색</td>
            <td style="padding-left: 5px">
              <select id="_s_category" name="s_category">
                 <option value="" <c:out value="${(empty s_category)? 'selected' : ''}"/>>선택</option>
                 <option value="all" <c:out value="${(s_category eq 'all') ? 'selected' : ''}"/>>전체 </option>
                 <option value="title" <c:out value="${(s_category eq 'title') ? 'selected' : ''}"/>>제목 </option>
                 <option value="content" <c:out value="${(s_category eq 'content') ? 'selected' : ''}"/>>내용 </option>
                 <option value="w_id" <c:out value="${(s_category eq 'w_id') ? 'selected' : ''}"/>>아이디 </option>
              </select>
            </td>
            <td style="padding-left: 5px">
               <input type="text" id="_s_keyword" name="keyword" placeholder="검색" value="${(empty keyword)?'':keyword }">
            </td>
            <td style="padding-left: 5px">
               <span class="button blue">
                   <button type="button" id="btnSearch">검색</button>
               </span>
            </td>
         </tr>
      
   
      </table>
   
   <!-- 추가 기입 -->
   <%-- <input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }"> 
   <input type="hidden" name="recordCountPerPage" id="_recordCountPerPage" value="${(empty recordCountPerPage)?0:recordCountPerPage }"> --%>
   </form>


</div>



<table class="list_table" style="width: 85%;">
 <colgroup>
   <col width="50"><col width="100"><col width="300"><col width="70">
   <col width="50"><col width="50"><col width="100"><col width="50">
    </colgroup>
   
   <thead> 
    <tr>
      <th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
      <th>조회수</th><th>다운수</th><th>작성일</th><th>삭제</th>
    </tr>
   </thead>
   
   <tbody>
     <c:forEach var="pds" items="${pdslist }" varStatus="vs">
     
     <tr>
       <td>${vs.count }</td>
       <td>${pds.id }</td>
       <td><a href="pdsdetail.do?seq=${pds.seq }">
           ${pds.title }
       </a></td>
       <td><input type="button" name="btDown" value="다운로드"
            onclick="filedown('${pds.filename}', '${pds.seq }')">
       </td>
       <td>${pds.readcount }</td>
       <td>${pds.downcount }</td>
       <td>
          <font size="1">${pds.regdate }</font>
       </td>
       <td>
         <img alt="" src="image/del.png" data_file_seq="${pds.seq }"
              class="btn_fileDelete" onclick="pdsDelete('${pds.seq}')">
       </td>
     </tr>   
    
     </c:forEach>
   </tbody>
   
</table> 

<!-- 자료 추가 -->
<div id="button.wrap">
    <span class="button blue">
       <button type="button" id="_btnAdd">자료추가</button>
    </span>
</div>

<!-- 다운로드 버튼을 클릭 -->
<form name="file_Down" action="fileDownload.do" method="post" >
    <input type="hidden" name="filename">
    <input type="hidden" name="seq">
</form>

<!-- 삭제를 클릭 -->
<form name="pdsdelete" action="pdsdelete.do" method="post">
    <input type="hidden" name="seq">
</form>


<script type="text/javascript">
$("#_btnAdd").click(function(){
	location.href = "pdswrite.do";
});

function pdsDelete( seq ){
	let doc = document.pdsdelete;
	doc.seq.value = seq;
	doc.submit();
	
}

function filedown( filename , seq ){
  //  alert(filename);
	  let doc = document.file_Down;
	  doc.filename.value = filename;
	  doc.seq.value = seq;
	  doc.submit(); 
	  
}

$("#btnSearch").click(function(){
	//alert('btnSearch');
	$("#_frmFormSearch").attr("action", "pdslist.do").submit();	
});
</script>





<%@page import="bit.com.a.util.CalendarUtil"%>
<%@page import="bit.com.a.dto.CalendarParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

    <%
        CalendarParam calp = (CalendarParam)request.getAttribute("calp"); 
    %>


    
<table class="list_table" style="width:65%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	
	<tr>
	<th>날짜</th>
	<td style="text-align: left">
	<select name="year" id="_year">
<%for(int i = calp.getYear()-5; i <= calp.getYear()+5; i++){

%>
  <option value="<%=i%>"><%=i %></option> 
<% 
if(i == calp.getYear()){%>
	<option value="<%=i%>" selected="selected"><%=i %></option> 
<%}
}%>

</select>년

<select name="month" id="_month">
<%for(int i = 1; i <= 12; i++){
	if(i < 10){
		if(i == calp.getMonth()){
	%>
	<option value="0<%=i%>" selected="selected">0<%=i %></option> 
	<%}else{ %>
	<option value="0<%=i%>">0<%=i %></option>
<%}
}else{
	if(i == calp.getMonth()){
%>
<option value="<%=i%>" selected="selected"><%=i %></option> 
<%} %>
  <option value="<%=i%>"><%=i %></option> 
<%
} 
}%>

</select>월

<select name="day" id="_day">
<%for(int i = 1; i < calp.getLastday()+1; i++){ 
   if(i < 10){
   if(i == calp.getDay()){
   %>
    <option value="0<%=i%>" selected="selected">0<%=i %></option>
   <%}else{ %>
	 <option value="0<%=i%>">0<%=i %></option>     
  <%}  
  }else{
	  if(i == calp.getDay()){
%>
    <option value="<%=i%>" selected="selected"><%=i %></option> 
<%}else{ %>
    <option value="<%=i%>"><%=i %></option>     
<%}
}
} %>
</select>
	</td>
	<tr>
	<tr>
		<th>일정 제목</th>
			<td style="text-align: left">
				<input type="text" name="title" size="60" id="_title"/>
			</td>
	</tr>
	<tr>
		<th>일정 내용</th>
		<td style="text-align: left">
			<textarea rows="10" cols="55" name='content' id="_content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="height:50px; text-align:center;">
			<span>					
	 			<a href="#none" id="_btn" title="글쓰기">		
					<img src="image/bwrite.png" alt="로그인" />
				</a>
			</span>
		</td>
	</tr>
</tbody>

</table>

<script>
   $("#_btn").click(function() {
         let cal = {
                    id:"${login.id}",
                    title:$("#_title").val(),
                    content:$("#_content").val(),
                    rdate:$("#_year").val()+$("#_month").val()+$("#_day").val()
                 };
         
	   	   $.ajax({
                   url:"writeCalendarAf.do",
                   type:"post",
                   data: cal,
                   async:true,
                   success:function( a ){
                         if(a == "yes"){
                            alert("일정이 성공적으로 등록되었습니다");
                            location.href="calendarlist.do";
                             }else{
                                 alert("일정 등록 실패!");

                                 }

                       },
                       error:function(){
                             alert(error);
                           }
		   	   
		   	   });
   });

</script>
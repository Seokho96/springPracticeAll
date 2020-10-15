﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<!-- cookie -->
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

<style type="text/css">
#login_wrap {
	margin:10px;
	/* margin-top: 200px; */
}
#login_wrap th {
	font-weight:bold;
}
#main_wrap { 
	width:800px; 
	margin-left:auto; 
	margin-right:auto; padding:0px; 
}			
#content_wrap { 
	width: 100%; 
	height: 500px; 
	background-image:url("image/zoeeseo.gif"); 
	background-repeat:no-repeat; 
	background-position:top center;  
}
			
.login_title_warp {
	width:500px; 
	color:#FFFFFF; 
	text-align:center; 
	/* background-color:#3e5fba;  */
	border:none; 
	font-weight:bold; 
	height:60px;
	margin-top: 200px;
}

/* table셋팅 */
.content_table { width:98%; /* border-bottom:1px solid #EFEFEF; border-right:1px solid #EFEFEF; border-collapse:collapse; */ margin-left:auto; margin-right:auto;  clear:both; }
.content_table td, .content_table th { text-align:center; /* border-top:1px solid #EFEFEF; border-left:1px solid #EFEFEF; */ padding:0.3em; }
.content_table th { background-color:#4D6BB3; color:#FFFFFF; line-height: 1.7em; font-weight:normal;}
.content_table td { padding-left:5px; /* text-align:left; */ line-height: 1.7em; }
.content_table td.contents { width:100%; height:400px; overflow:auto; }
.content_table th, .content_table td { vertical-align:middle; }

.content_table select { height:19px; /* border:#CCCCCC solid 1px; */ vertical-align:middle; line-height: 1.8em; padding-left:0px; }
.content_table select option { margin-right:10px; }

</style>

</head>
<body>

<div id="main_wrap">
	<div id="middle_wrap">
		<div id="content_wrap">
			
			<div style="width: 502px; height: 166px; margin-left: auto; margin-right: auto;
						position: relative; top: 100px;">
								
			<div class="login_title_warp">
				<div style="margin-top: 15px">
					<h2>My Home Page</h2>
				</div>			
			</div>
			
			<div id="login_wrap">
				
				<form action="loginAf.do" name="frmFrom" id="_frmForm" method="post">
					
					<table class="content_table" style="width: 75%; border: none;">
					<colgroup>
						<col style="width:30%">
						<col style="width:70%">
					</colgroup>
					
					<tr align="center" >
						<!-- <th style="background: #eeeeee; color:#3e5fba">아이디</th> -->
						<td colspan="2" style="padding-left: 64px">&nbsp;<input type="text" id="_userid" name="id" data-msg="ID를 "
									size="20px" title="아이디"  placeholder="아이디">
							<input type="checkbox" id="chk_save_id"><span style="color: white">&nbsp;ID 저장</span>
						</td>
					</tr>
					
					<tr align="center">
						<!-- <th style="background: #eeeeee; color:#3e5fba">패스워드</th> -->
						<td colspan="2" >&nbsp;<input type="text" id="_pwd" name="pwd" data-msg="Password를 "
									size="20px" title="패스워드"  placeholder="패스워드">							
						</td>					
					</tr>
					
					<tr>
						<td colspan="2" style="height: 20px; text-align: center;">
						<span>
							<a href="#none" id="_btnLogin" title="로그인">
								<img alt="" src="./image/login_btn.jpg" width="80">
							</a>
							
							<a href="#none" id="_btnRegi" title="회원가입">
								<img alt="" src="./image/regi.jpg" width="80">
							</a>						
						</span>
						</td>					
					</tr>						
					</table>				
				</form>			
			</div>
			</div>		
		</div>	
	</div>
</div>

<script type="text/javascript">
$("#_btnLogin").click(function(){
	//alert("login click");

	if($("#_userid").val().trim() == ""){
		alert($("#_userid").attr("data-msg") + "입력해 주십시오");
		$("#_userid").focus();
	}
	else if($("#_pwd").val().trim() == ""){
		alert("Password를 입력해 주십시오");
		$("#_pwd").focus();
	}
	else{
		$("#_frmForm").attr({"action":"loginAf.do", "target":"_self"}).submit();
	}	
});

let user_id = $.cookie("user_id");
if(user_id != null){
	//alert("쿠키 있음");
	$("#_userid").val( user_id );
	$("#chk_save_id").attr("checked", "checked");	
}

$("#chk_save_id").click(function(){

	if( $("#chk_save_id").is(":checked") ){	// 첵크 되었을 때
		if( $("#_userid").val().trim() == ""){
			alert("id를 입력해 주십시오");
			$("#chk_save_id").prop("checked", false);
		}
		else{
			$.cookie("user_id", $("#_userid").val(), { expires:356, path:'/' });
		}
	}
	else{
		alert("쿠키 삭제");
		$.removeCookie("user_id", {path:'/'});
	}	
});

$("#_btnRegi").click(function(){
	location.href = "regi.do";
});




</script>


</body>
</html>





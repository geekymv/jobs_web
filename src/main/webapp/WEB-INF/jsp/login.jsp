<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>用户登录</title>
<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<style type="text/css">
	.error_info {
		color: red;
		font-size: 16px;
	}

</style>

</head>
<body>
<div class='signup_container'>

    <h1 class='signup_title'>用户登录</h1>
    <img src="<c:url value='/resources/img/people.png'/>" id="admin" />
    <div class="error_info">
    </div>
    <form>
    <div id="signup_forms" class="signup_forms clearfix">
            <div class="signup_form_form" id="signup_form">
                    <div class="form_row first_row">
                        <label for="signup_name">请输入用户名</label>
                        <input type="text" name="account" placeholder="请输入用户名" id="account" required="required" autofocus="autofocus"/>
                    </div>
                    <div class="form_row">
                        <label for="signup_password">请输入密码</label>
                        <input type="password" name="password" placeholder="请输入密码" id="password" required="required" />
                    </div>
           </div>
    </div>
    <div class="login-btn-set">
		<div class='rem'>记住我</div> 
		<input type="button" value="" id="login-btn" class='login-btn' />
	</div>
	</form>
</div>
<script type="text/javascript">
	/*
	function document.onkeydown(event){
		if(event.keyCode==13){
			document.getElementById("button").click();
			return false;
		}	
	}
	*/
	
	$(function(){
	    $('.rem').click(function(){
	        $(this).toggleClass('selected');
	    });
	    
	    $(".login-btn").click(function(){
	    	$.ajax({
	    		url: contextPath + "/login",
	    		type: "POST",
	    		data: {"account": $("#account").val(), "password": $("#password").val()},
	    		dataType: "text",
	    		success: function(data) {
	    			if(data != "error") {
	    				window.location.href = contextPath + "/index";
	    			}else {
	    				$(".error_info").html("用户名或密码错误！");
	    			}
	    			/*
	    			if(data == "error") {
	    				$(".error_info").html("用户名或密码错误！");
	    			}else if (data == "student") {
						alert("student");	    				
	    			}else if(data == "employer") {
	    				alert("employer");
	    			}else if(data == "admin") {
	    				alert("admin");
	    			}
	    			*/
	    		}
	    	});
	    });
	});
</script>
</body>
</html>
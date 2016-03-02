<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>添加用工单位</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 210px;
		}
		.form {
			margin-top: 10px;
			margin-left: 240px;
		}
		.error-info {
			color: red;
		}		
	</style>
	
	<link href="<c:url value='/resources/css/zzsc.css'/>" rel="stylesheet"/>	
	<script src="<c:url value='/resources/js/showlist.js'/>"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

<body>
	<div class="container">
		<jsp:include page="../inc/nav.jsp"></jsp:include>
		
		<div class="row row-top">
    	<div class="col-md-2">
    		<div class="panel panel-primary">
    		  <div class="panel-heading">功能导航</div>	
			  <jsp:include page="left-sider.jsp"></jsp:include>	
			</div>
      	</div>
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">添加用工单位</div>
	          <div class="row">
	          <div class="form">
	          <form id="add_form" class="form-horizontal" method="post">
				<div class="form-group">	
					<label for="account" class="col-sm-2 control-label">登录账号</label>  
					<div class="col-md-4">
					  <input type="text" name="account" id="account" class="form-control" autofocus="autofocus" required="required"/>
					</div> 
			  	</div>
			  	<div class="form-group">	
					<label for="password" class="col-sm-2 control-label">登录密码</label>  
					<div class="col-md-4">
					  <input type="password" id="password" name="pwd" class="form-control" required="required"/>
					</div> 
			  	</div>
			  	<div class="form-group">	
					<label for="repassword" class="col-sm-2 control-label">密码确认</label>  
					<div class="col-md-4">
					  <input type="password" id="repassword" name="repassword" class="form-control" required="required"/>
					</div> 
			  	</div>
			  	<div class="form-group">
				    <label for="name" class="col-sm-2 control-label">单位名称</label>
				    <div class="col-md-4">
				      <input type="text" class="form-control focus" id="name" name="name" required="required">
				    </div>
				</div>
				<div class="form-group">
				    <label for="mobile" class="col-sm-2 control-label">电话号码</label>
				    <div class="col-md-4">
				      <input type="text" class="form-control" id="mobile" name="mobile" required="required">
				    </div>
				</div>
				<div class="form-group">
				    <label for="teacher" class="col-sm-2 control-label">负责老师</label>
				    <div class="col-md-4">
				      <input type="text" class="form-control focus" id="teacher" name="teacher" required="required"/>
				    </div>
				</div>
				<div class="form-group">
				    <label for="postNum" class="col-sm-2 control-label">岗位数</label>
				    <div class="col-md-4">
				      <input type="text" id="postNum" class="form-control" id="postNum" name="postNum" required="required"/>
				    </div>
				</div>
			  	<div class="form-group">
				    <label for="totalMoney" class="col-sm-2 control-label">月总金额(元)</label>
				    <div class="col-md-4">
				      <input type="text" id="totalMoney" class="form-control" id="totalMoney" name="totalMoney"/>
				    </div>
				</div>

			  	<div class="form-group">
				    <label for="remarks" class="col-sm-2 control-label">备注信息</label>
				    <div class="col-md-4">
					    <textarea class="form-control" rows="2" name="remarks"></textarea>
				    </div>
				</div>
			  	 <div class="form-group">
				    <div class="col-sm-offset-3 col-sm-4">
				      <button type="button" id="addEmployer" class="btn btn-primary">添加</button>
				    </div>
				</div>
	    	</form>
	        </div>
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div>
   </div><!-- /.container -->
   
   <div class="footer">
	   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   	$(function(){
   		
   		$('#addEmployer').click(function(){
			// 输入验证
   			var account = $("#account").val();
   			if($.trim(account) == "") {
   				alert("账号不能为空！");
   				$("#account").focus();
   				return false;
   			}
   			//验证密码是否一致
   			var password = $("#password").val();
   			var repassword = $("#repassword").val();
   			
   			if($.trim(password) == ""){
   				alert("密码不能为空！");
   				$("#password").focus();
   				return false;
   			}
   			if($.trim(repassword) == ""){
   				alert("重复密码不能为空！");
   				$("#repassword").focus();
   				return false;
   			}
   			// 密码一致
   			if($.trim(password) != $.trim(repassword)) {
   				alert("两次输入的密码不一致！");
   				$("#repassword").focus();
   				return false;
   			}
   			
   			// 单位名称
   			var name = $('#name').val();
   			if($.trim(name) == '') {
   				alert('单位名称不能为空！');
   				$('#name').focus();
   				return;
   			}
   			
   			// 电话号码
   			var mobile = $('#mobile').val();
   			if($.trim(mobile) == '') {
				alert('电话号码不能为空！');
				$('#mobile').focus();
				return;
   			}
   			var reg = /(^(\d{3,4}-)?\d{7,8})$|(1[0-9]{10})/;	// 电话号码与手机号码同时验证
   			if(!reg.test(mobile)) {
   				alert('电话号码不合法！');
   				$("#mobile").focus();
   				return;
   			}
   			
   			var teacher = $('#teacher').val();
   			if($.trim(teacher) == '') {
				alert('负责老师不能为空！');
				$('#teacher').focus();
				return;
   			}
   			
   			
   			//验证岗位数是否合法：必须是正整数
   			var postNum = $("#postNum").val();
   			if($.trim(postNum) == '') {
   				alert('岗位数不能为空！');
   				$("#postNum").focus();
   				return;
   			}
   			
   			var reg = /^(?:[1-9]\d*|0)$/; 
   		  	if(!reg.test(postNum)){
   		  		alert("岗位数必须是正整数！");
   		  		$("#postNum").focus();
   		  	 	return false;
   			}
   			
   		  	
   		  	// 月总金额不能为空
   		  	var totalMoney = $('#totalMoney').val();
   		  	if($.trim(totalMoney) == '') {
   		  		alert("月总金额不能为空");
   		  		$('#totalMoney').focus();
		  	 	return false;
   		  	}
   		  	
   			//验证月总金额的合法性：必须是正整数
   			var totalMoney = document.getElementById("totalMoney");
   			var total_value = totalMoney.value;
   			var r = "1234567890";
   			
   			for(var i = 0; i < total_value.length; i++) {
   				//开头不能是0
   				if(total_value.charAt(0) == 0){
   					alert("月总金额输入不合法，请输入正整数！");
   					totalMoney.focus();
   					return false;
   				}

   				var ch = total_value.charAt(i);
   				if(r.indexOf(ch) == -1) {
   					alert("月总金额输入不合法，请输入正整数！");
   					totalMoney.focus();
   					return false;
   				}
   			}
		
			// 验证账户名是否已经存在
	   		$.post(contextPath+'/admin/isExist', {'account':$('#account').val()}).done(function(data){
	   			if(data == 'isexist') {
	   				alert('账户名已经存在！');
	   				$("#account").focus();
	   				
	   			}else if(data == 'notexist') {	// 不存在
					// 提交表单数据
	   				var data = $("#add_form").serialize();
	   				data = decodeURIComponent(data,true); /* 解决中文乱码问题 */
	   				
	   				$.post(contextPath+'/admin/addemployer', data)
	   				.done(function(data){
	   					if(data == 'success'){
							alert('添加成功!');	
							// 跳转到用工单位列表
							window.location.href= contextPath+'/admin/employers';
	   					}else if(data == 'fail') {
							alert('添加失败');	   						
	   					}	
	   				}).fail(function(msg) {
	   					
	   				});
	   			}

	   		}).fail(function(msg){
	   			
	   		});
		});   		
   	});

   	function mycheck() {
		var account = $("#account").val();
		if($.trim(account) == "") {
			alert("账号不能为空！");
			$("#account").focus();
			return false;
		}
		//验证密码是否一致
		var password = document.getElementById("password");
		var repassword = document.getElementById("repassword");
		
		if(password.value == ""){
			alert("密码不能为空！");
			return false;
		}
		if(repassword.value == ""){
			alert("重复密码不能为空！");
			return false;
		}
		
		if(password.value != repassword.value) {
			alert("两次输入的密码不一致！");
			repassword.focus(); 
			return false;
		}
		
		//验证岗位数是否合法：必须是正整数
		var postNum = document.getElementById("postNum");
		var reg = /^(?:[1-9]\d*|0)$/; 
	  	if(!reg.test(postNum.value)){
	  		alert("岗位数必须是正整数！");
	  	 	postNum.focus();
	  	 	return false;
		  	}
		
		//验证月总金额的合法性：必须是正整数
		var totalMoney = document.getElementById("totalMoney");
		var total_value = totalMoney.value;
		var r = "1234567890";
		
		for(var i = 0; i < total_value.length; i++) {
			//开头不能是0
			if(total_value.charAt(0) == 0){
				alert("月总金额输入不合法，请输入正整数！");
				totalMoney.focus();
				return false;
			}

			var ch = total_value.charAt(i);
			if(r.indexOf(ch) == -1) {
				alert("月总金额输入不合法，请输入正整数！");
				totalMoney.focus();
				return false;
			}
		}
		
		return true;
   	}
   	
   
   </script>
   
   
   
   

</body>
</html>

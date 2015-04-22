<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>我的资料</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.div-top {
			margin-top: 8px;	
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
    <div class="row">
    	<div class="col-md-2">
			<div class="panel panel-primary">	 
			<div class="panel-heading">功能导航</div>
				<jsp:include page="left-sider.jsp"></jsp:include>
			</div>	
      	</div>
    
      	<div class="col-md-10">
      		<div class="panel panel-primary">
	          <div class="panel-heading">我的资料</div>
	     	  	<form class="form-horizontal" role="form" >
	     	  		<div class="form-group">
		        		<label class="col-md-4 control-label">登录账号：</label>
		        		<div  class="col-md-3 div-top">
		        			 ${employer.account}
		        			<input type="hidden" class="form-control" id="id" name="id" value="${employer.id }"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">单位名称：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="name" name="name" value="${employer.name}" maxlength="30" autofocus="autofocus"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">登录密码：</label>
		        		<div class="col-md-3">
		        			<input type="password" class="form-control" name="pwd" id="password" maxlength="20" />
		        			<span style="font-size: 9px; color: blue;">若不改密码，不用填写！</span>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">密码确认：</label>
		        		<div class="col-md-3">
		        			<input type="password" class="form-control" id="repassword" maxlength="20"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">电话号码：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="mobile" name="mobile" value="${employer.mobile}" maxlength="20"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="teacher" class="col-md-4 control-label">负责老师：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="teacher" name="teacher" value="${employer.teacher}" maxlength="20"/>
		      			</div>
	      			</div>
	      			<div class="form-group">
		      			<label class="col-md-4 control-label">总岗位数：</label>
		      			<div class="col-md-3 div-top">
		      				${employer.postNum }
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label class="col-md-4 control-label">月总金额：</label>
		      			<div class="col-md-3 div-top">
		      				${employer.totalMoney }
		        		</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">注册时间：</label>	       
		        		<div class="col-md-3 div-top" id="regDate">
		        		</div>
	        		</div>
					<div class="form-group">
						<label class="col-md-4 control-label">备注：</label>	       
		        		<div class="col-md-3">
			        		<textarea class="form-control" id="remarks" name="remarks">${employer.remarks }</textarea>	
		        		</div>
	        		</div>
	        		<div class="form-group">
			            <label class="col-md-4 control-label"></label>	
			            <div class="col-md-7">
			          	  <input type="button" id="edit" class="btn btn-primary" value="保存修改"/>
			            </div>
		         	</div>
		          	
		        </form>  
		    </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   <div class="footer">
   		<jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   	$(function(){
   		// 注册时间
   		var regDate = '${employer.regDate }';
   		$('#regDate').html(formatterDate(regDate));
   		
		// 更新
		$("#edit").click(function(){
			// TODO 输入验证
	   		var id = $("#id").val();
	   		var name = $("#name").val();
	   		var mobile = $("#mobile").val();
	   		var teacher = $("#teacher").val();
	   		var remarks = $("#remarks").val();
	   		var password = $("#password").val();
	   		var repassword = $("#repassword").val();
	   		
			// 验证用工单位名称
	   		if(name.trim() == "") {
				alert('用工单位名称为必填项！');
				$("#name").val("").focus();	// 清空并获得焦点
				return;
			}	   		
			// 验证密码
			if(repassword.trim() != ""){
				if(password.trim() == ""){
					alert("密码不能为空！");
					return;
				}
				if(repassword != password){
					alert("密码不一致！");
					return;
				}
			}
			
	   		var reg1 = /^((\d{4})?(\-)?\d{7,8}|\d{3}\-\d{6}|(\d{3}\-\d{7}-\d{3}))$/;
			var reg2 = /^1\d{10}/;
			if(mobile.trim() == "" || !reg1.test(mobile.trim()) || !reg2.test(mobile.trim())){
				alert('电话号码不合法！');
				return;
			}

			if(teacher.trim() == ""){
				alert('负责老师为必填项！');
				return;
			}
			
			var data = {"id":id, "name": name, "mobile": mobile,
					"teacher": teacher, "remarks":remarks,
					"pwd": password};
			
			$.post(contextPath + "/employer/edit", data, "text").done(function(data){
	   			if(data == "success"){
	   				alert("更新成功！");
	   			}
	   		}).fail(function(data){
	   			alert("更新失败！");
	   		});
		});
		
   		
   	});
   </script>

</body>
</html>

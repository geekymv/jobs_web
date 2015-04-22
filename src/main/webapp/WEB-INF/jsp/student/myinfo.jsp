<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">		
	<title>基本资料</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		ul li {
			line-height: 40px;
		}
		
		.left-sider a {
			font-weight: bold;
			text-align: center;
		}
		
	</style>
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
    		<jsp:include page="left-sider.jsp"></jsp:include>
      	</div>
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">我的资料</div>
	          	<form class="form-horizontal" role="form" id="form" >
	     	  		<div class="form-group div-top">
		        		<label for="num" class="col-md-4 control-label">学号：</label>
		        		<div  class="col-md-3">
		        			<input type="text" class="form-control" readonly="readonly" value="${student.num }"/>
		        			<input type="hidden" name="id" value="${student.id }">
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">姓名：</label>
		        		<div  class="col-md-3">
		        			<input type="text" class="form-control" id="name" name="name" autofocus="autofocus" value="${student.name }"/>
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
					  	<label for="gender" class="col-md-4 control-label">性别：</label>
					  	<div class="col-md-3">
					  		<c:choose>
					  			<c:when test="${student.gender == '男' }">
					  				 <label class="radio-inline control-label">
								  		<input type="radio" name="gender" id="male" value="男" checked="checked"> 男
									</label>
									<label class="radio-inline">
									  <input type="radio" name="gender" id="female" value="女"> 女
									</label>
					  			</c:when>
								<c:otherwise>
									<label class="radio-inline control-label">
								  		<input type="radio" name="gender" id="male" value="男"> 男
									</label>
									<label class="radio-inline">
									  <input type="radio" name="gender" id="female" value="女"  checked="checked"> 女
									</label>
								</c:otherwise>					  			
					  		
					  		</c:choose>
						 
						</div>
					</div>
					<div class="form-group">
					    <label for="college" class="col-sm-4 control-label">学院：</label>
					    <div class="col-sm-3">
					      <select class="form-control" id="college" name="collegeId">
						  </select>
					    </div>
					</div>
					<div class="form-group">
					    <label for="profession" class="col-sm-4 control-label">专业：</label>
					    <div class="col-sm-3">
					      <select class="form-control" id="profession" name="professionId">
						  </select>
					    </div>
					</div>
	        		<div class="form-group">
		        		<label for="mobile" class="col-md-4 control-label">手机号码：</label>
		        		<div  class="col-md-3">
		        			<input type="text" class="form-control" id="mobile" name="mobile" value="${student.mobile }"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="email" class="col-md-4 control-label">邮箱：</label>
		        		<div  class="col-md-3">
		        			<input type="text" class="form-control" id="email" name="email" value="${student.email }"/>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="introduce" class="col-md-4 control-label">自我介绍：</label>
		        		<div  class="col-md-3">
		        			<textarea id="introduce" name="introduce" class="form-control">${student.introduce }</textarea>
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label class="col-md-4 control-label">注册时间：</label>
		        		<div  class="col-md-3 div-top" id="regTime">
		        		</div>
	        		</div>
	        		<div class="form-group">
	        			<div class="col-md-10 div-top" id="regTime" style="text-align: center;">
		        			<button type="button" id="edit" name="" class="btn btn-primary">更新</button>
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
   		var params = {}
   		
		$(function(){
			// 注册时间处理
			var regTime = '${student.regTime }';
			$('#regTime').append(formatterDate(regTime));
			
			// 获取所有专业
			getColleges();
			// 专业改变事件
			$("#college").change(function(){
				params.colId = $("#college").val();
				getProfessions();
			});
			
			// 更新个人信息
			$('#edit').click(function(){
				// 输入验证
				var name = $('#name').val();
				if(name.trim() == '') {
					alert('姓名不能为空！') ;
					$('#name').focus();
					return;
				}
				
				// 密码
				var password = $('#password').val();
				var repassword = $('#repassword').val();
				// 验证密码
				if(repassword.trim() != ""){
					if(password.trim() == ""){
						alert("密码不能为空！");
						$('#password').focus();
						return;
					}
					if(repassword != password){
						alert("密码不一致！");
						$('#repassword').focus();
						return;
					}
				}
				
				// 手机号码
				var mobile = $('#mobile').val();
				if(mobile.trim() == '') {
					alert('手机号码不能为空！');
					$('#mobile').focus();
					return;
				}		
				
				// 邮箱验证
				var email = $('#email').val();
				if(email.trim() == '') {
					alert('邮箱不能为空！');					
					$('#email').focus();
				}
				
				
				var datas = $("#form").serialize();
   				datas = decodeURIComponent(datas, true); /* 解决中文乱码问题 */

   				$.post(contextPath+'/student/edit', datas).done(function(data){
					if(data == 'success') {
						alert("更新成功！");						
					}					
				}).fail(function(msg){
					
				});
			});
			
			
		});   
		
		// 获得所有学院
		function getColleges(){
			$.ajax({
				url: contextPath + "/getColleges",
				type: "post",
				dataType: "json",
				success: function(data) {
					var html = "";
					var collegeId = '${student.collegeId}';
					for(var i = 0; i < data.length; i++) {
						// 学生专业选择
						var pro = "<option value="+data[i].id+">" + data[i].name + "</option>";
						if(collegeId == data[i].id) {
							pro = "<option selected='selected' value="+data[i].id+">" + data[i].name + "</option>";
						}
						html += pro;
					}
					// 学生所在学院id
					params.colId = collegeId;
					getProfessions(); 
					
					$("#college").html(html);
				}
			});
		}
		
		// 根据学院id获得该学院的专业
		function getProfessions(){
			$.ajax({
				url: contextPath + "/getProfessions",
				data: params,
				type: "post",
				dataType: "json",
				success: function(data) {
					var html = "";
					var professionId = '${student.professionId}';
					for(var i = 0; i < data.length; i++) {
						var pro = "<option value="+data[i].id+">" + data[i].name + "</option>";
						if(professionId == data[i].id) {
							pro = "<option selected='selected' value="+data[i].id+">" + data[i].name + "</option>";
						}
						html += pro;
					}
					$("#profession").html(html);
				}
			});
		}
		
		
		
   </script>
</body>
</html>

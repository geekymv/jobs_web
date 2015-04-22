<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>学生注册</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">	
<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   <!--[if lt IE 9]>
     <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
     <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->
<style type="text/css">
body{
	height: 900px;
}
label {
	width: 10em;
	float: left;
}
label.error {
	float: none;
	color: red;
	padding-left: .5em;
	vertical-align: top;
}
p {
	clear: both;
}
.submit {
	margin-left: 12em;
}
em {
	padding-right: 1em;
	vertical-align: middle;
	color: red;
}
em.error {
	background: url("resources/img/unchecked.gif") no-repeat 0px 0px;
	padding-left: 16px;
}
em.success {
	background: url("resources/img/checked.gif") no-repeat 0px 0px;
	padding-left: 16px;
}

.tips, .fielderror {
	color: red;
}
</style>
<!-- 
<script type="text/javascript" src="<c:url value='/resources/validation/jquery-1.10.0.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/validation/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/validation/jquery.metadata.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/validation/messages_zh.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/register-validation.js'/>"></script>
 -->
</head>

<body>
<div class="container">
	<div class="row">
		<form class="form-horizontal" role="form">
		<fieldset>
			<legend>学生注册</legend>
		  <div class="form-group">
		    <label for="number" class="col-sm-4 control-label">学号<em>*</em></label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control focus" id="num" name="num" autofocus="autofocus" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-4 control-label">登录密码<em>*</em></label>
		   
		    <div class="col-sm-3">
		      <input type="password" class="form-control" id="pwd" name="pwd" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="repassword" class="col-sm-4 control-label">确认密码<em>*</em></label>
		    
		    <div class="col-sm-3">
		      <input type="password" class="form-control" id="repassword" name="repassword" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-4 control-label">姓名<em>*</em></label>
		    
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="name" name="name" />
		    </div>
		  </div>
		  <div class="form-group">
		  	<label for="gender" class="col-sm-4 control-label">性别<em>*</em></label>
		  	<div class="col-sm-3">
			  	<label class="radio-inline col-sm-5 control-label">
			  		<input type="radio" name="gender" id="male" value="男" checked="checked"> 男
				</label>
				<label class="radio-inline col-sm-5 ">
				  <input type="radio" name="gender" id="female" value="女"> 女
				</label>
			</div>
		  </div>
		  <div class="form-group">
		    <label for="mobile" class="col-sm-4 control-label">手机号码<em>*</em></label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="mobile" name="mobile" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="email" class="col-sm-4 control-label">邮箱<em>*</em></label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="email" name="email" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="college" class="col-sm-4 control-label">学院<em>*</em></label>
		    <div class="col-sm-3">
		      <select class="form-control" id="college" name="collegeId">
			  </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="profession" class="col-sm-4 control-label">专业<em>*</em></label>
		    <div class="col-sm-3">
		      <select class="form-control" id="profession" name="professionId">
			  </select>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="introduce" class="col-sm-4 control-label">自我介绍</label>
		    <div class="col-sm-3">
		    	<textarea class="form-control" rows="3" name="introduce"></textarea>
		    </div>
		  </div>
		  <%--
		  <div class="form-group">
		    <label for="college" class="col-sm-4 control-label">密码问题一<em>*</em></label>
		    <div class="col-sm-3">
		      <select class="form-control" id="question1" name="question1">
			  </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="college" class="col-sm-4 control-label">密保问题二<em>*</em></label>
		    <div class="col-sm-3">
		       <select class="form-control" id="question2" name="question2">
			   </select>
		    </div>
		  </div>
		  --%>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-4">
		      <button type="button" id="register" class="btn btn-default">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;
		      <button type="button" class="btn btn-default" onclick="window.location.href='${ctx}/index'">取消</button>
		    </div>
		  </div>
		  </fieldset>
		</form>

	</div>
</div>

<script type="text/javascript" src="<c:url value='/resources/scripts/register.js'/>"></script>

</body>
</html>

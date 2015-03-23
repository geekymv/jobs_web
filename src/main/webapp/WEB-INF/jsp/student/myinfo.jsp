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
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 240px;
		}
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
    <div class="row">
    	<div class="col-md-2">
    		<jsp:include page="left-sider.jsp"></jsp:include>
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">我的资料</div>
		     	 <ul>
		        	<li>学号：${student.num}</li>
		        	<li>姓名：${student.name }</li>
		        	<li>性别：${student.gender }</li>
		        	<li>学院：${student.college }</li>
		        	<li>专业：${student.profession }</li>
		        	<li>手机号码：${student.mobile }</li>
		        	<li>自我介绍：${student.introduce }</li>	
		        	<li>注册时间：<fmt:formatDate value="${student.regTime }" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		        </ul>	
		        <%--
		        <a href="student/preupdate.do" class="btn btn-primary">修改基本资料</a>	
		     	 --%>
		     </div>
    	</div>
	</div>
   </div><!-- /.container -->
   
   <div class="footer">
   	<jsp:include page="../main/footer.jsp"></jsp:include>
   </div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>学生列表</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		table th, td {
			text-align: center;
		}
		
		.mybtn {
			width: 50px;
			height: 27px;
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
	          <div class="panel-heading">学生列表</div>
	          <div class="panel-body">
	            <div style="text-align: center;">
					<form class="form-inline">
					  <div class="form-group">
					    <input type="text" class="form-control" id="content" name="content" placeholder="请输入学生学号" autofocus="autofocus" />
					  </div>
					  &nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="search">查询</button>
					</form>
				</div>	
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr id="head">
	                   	<th>序号</th> <th>学号</th> <th>姓名</th> <th>学院</th> <th>专业</th><th>操作</th> 
	                </tr>
	            </thead>
	            <tbody>
	            </tbody>
	          </table>
			<div class="panel-footer">
				<nav style="text-align: center;">
				    <ul id="page" class="pagination" data-first-btn-text="首页" data-last-btn-text="尾页"></ul>
				</nav>
			</div>	
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div><!-- /.container -->
   
   <%-- 学生信息模态框 --%>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="width: 660px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">学生资料</h4>
	      </div>
	      <div class="modal-body">
      		<form class="form-horizontal" role="form" id="form" >
     	  		<div class="form-group div-top">
	        		<label for="num" class="col-md-4 control-label">学号：</label>
	        		<div  class="col-md-5">
	        			<input type="text" class="form-control" id="num" name="num" />
	        			<input type="hidden" id="id" name="id" />
	        		</div>
	        		<div class='col-sm-3 div-top' id="stuIsExist" style="font-size: 9px; color: red; display: none;">学号已存在！</div>
        		</div>
        		<div class="form-group">
	        		<label for="name" class="col-md-4 control-label">姓名：</label>
	        		<div  class="col-md-5">
	        			<input type="text" class="form-control" id="name" name="name" autofocus="autofocus" value="${student.name }"/>
	        		</div>
        		</div>
        		
        		<div class="form-group">
	        		<label for="name" class="col-md-4 control-label">登录密码：</label>
	        		<div class="col-md-5">
	        			<input type="password" class="form-control" name="pwd" id="password" maxlength="20" />
	        		</div>
					<div class='col-sm-3 div-top' style="font-size: 9px; color: blue;">若不改密码，不用填写！</div>
        		</div>
        		<div class="form-group">
	        		<label for="name" class="col-md-4 control-label">密码确认：</label>
	        		<div class="col-md-5">
	        			<input type="password" class="form-control" id="repassword" maxlength="20"/>
	        		</div>
        		</div>
        		
        		<div class="form-group">
				  	<label for="gender" class="col-md-4 control-label">性别：</label>
				  	<div class="col-md-5">
		  				<label class="radio-inline control-label">
					  		<input type="radio" name="gender" id="male" value="男" checked="checked"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" id="female" value="女"> 女
						</label>
					</div>
				</div>
				<div class="form-group">
				    <label for="college" class="col-sm-4 control-label">学院：</label>
				    <div class="col-sm-5">
				      <select class="form-control" id="college" name="collegeId">
					  </select>
				    </div>
				</div>
				<div class="form-group">
				    <label for="profession" class="col-sm-4 control-label">专业：</label>
				    <div class="col-sm-5">
				      <select class="form-control" id="profession" name="professionId">
					  </select>
				    </div>
				</div>
        		<div class="form-group">
	        		<label for="mobile" class="col-md-4 control-label">手机号码：</label>
	        		<div  class="col-md-5">
	        			<input type="text" class="form-control" id="mobile" name="mobile" value="${student.mobile }"/>
	        		</div>
        		</div>
        		<div class="form-group">
	        		<label for="email" class="col-md-4 control-label">邮箱：</label>
	        		<div  class="col-md-5">
	        			<input type="text" class="form-control" id="email" name="email" value="${student.email }"/>
	        		</div>
        		</div>
        		<div class="form-group">
	        		<label for="introduce" class="col-md-4 control-label">自我介绍：</label>
	        		<div  class="col-md-5">
	        			<textarea id="introduce" name="introduce" class="form-control"></textarea>
	        		</div>
        		</div>
        		<div class="form-group">
	        		<label class="col-md-4 control-label">注册时间：</label>
	        		<div  class="col-md-5 div-top" id="regTime">
	        		</div>
        		</div>
        	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="update" >更新</button>
	      </div>
	    </div>
	  </div>
	</div>   
   
   <div class="footer">
   	<jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript" src="<c:url value='/resources/scripts/ui/admin/students.js'/>"></script>
</body>
</html>

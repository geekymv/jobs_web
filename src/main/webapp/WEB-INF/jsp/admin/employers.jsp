<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用工单位列表</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<link href="<c:url value='/resources/css/zzsc.css'/>" rel="stylesheet"/>	
	<script src="<c:url value='/resources/js/showlist.js'/>"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
   	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   	<!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
   	<![endif]-->
   	<style type="text/css">
   		table th, td {
   			text-align: center;
   		}
   		
   		.mybtn {
			width: 45px;
			height: 27px;
		}
		
		
   	</style>
   	
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
	          <div class="panel-heading">用工单位列表</div>
	          
	          <div class="panel-body">
	          	<div style="text-align: center;">
					<form class="form-inline">
					  <div class="form-group">
					    <input type="text" class="form-control" id="content" placeholder="请输入单位名称" autofocus="autofocus" />
					  </div>
					  &nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="search">查询</button>
					</form>
				</div>	
			  </div>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead id="head">
	                <tr>
	                   	 <th>序号</th> <th>登录账号</th> <th>单位名称</th> <th>电话号码</th> <th>负责老师</th>
			  			 <th>岗位数</th> <th>月总金额</th> <th>账号状态</th> <th>操作</th> 
	                </tr>
	            </thead>
	            
	            <tbody id="t_body">
	          
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
    <%-- 用工单位模态框 --%>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="width: 660px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">用工单位信息</h4>
	      </div>
	      <div class="modal-body">
      		<form class="form-horizontal" role="form" id="form" >
     	  	  <div class="form-group">
        		<label class="col-md-4 control-label">登录账号：</label>
        		<div class="col-md-5">
        			 <input type="text" name="account" id="account" class="form-control" />
        			<input type="hidden" class="form-control" id="id" name="id" />
        		</div>
        		<div class='col-sm-3 div-top' id="isExist" style="color: red; display: none;">该账号已存在！</div>
       		 </div>
       		 <div class="form-group">
        		<label for="name" class="col-md-4 control-label">单位名称：</label>
        		<div class="col-md-5">
        			<input type="text" class="form-control" id="name" name="name" maxlength="30"/>
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
        		<label for="name" class="col-md-4 control-label">电话号码：</label>
        		<div class="col-md-5">
        			<input type="text" class="form-control" id="mobile" name="mobile" maxlength="20"/>
        		</div>
       		 </div>
       		 <div class="form-group">
        		<label for="teacher" class="col-md-4 control-label">负责老师：</label>
        		<div class="col-md-5">
        			<input type="text" class="form-control" id="teacher" name="teacher" maxlength="20"/>
      			</div>
     			</div>
     			<div class="form-group">
      			<label class="col-md-4 control-label">总岗位数：</label>
      			<div class="col-md-5">
      				<input type="text" id="postNum" class="form-control" id="postNum" name="postNum" required="required"/>
        		</div>
       		 </div>
       		 <div class="form-group">
        		<label class="col-md-4 control-label">月总金额：</label>
      			<div class="col-md-5">
      				<input type="text" id="totalMoney" class="form-control" id="totalMoney" name="totalMoney"/>
        		</div>
			 </div>
			 <div class="form-group">
				<label class="col-md-4 control-label">注册时间：</label>	       
        		<div class="col-md-5 div-top" id="regDate">
        		</div>
       		 </div>
			 <div class="form-group">
				<label class="col-md-4 control-label">备注：</label>	       
        		<div class="col-md-5">
	        		<textarea class="form-control" id="remarks" name="remarks"></textarea>	
        		</div>
       		 </div>
        	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="update">更新</button>
	      </div>
	    </div>
	  </div>
	</div>   
   
   <div class="footer">
   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
    
   <script type="text/javascript" src="<c:url value='/resources/scripts/ui/admin/employers.js'/>"></script>

</body>
</html>














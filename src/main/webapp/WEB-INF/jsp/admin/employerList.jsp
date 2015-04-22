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
					    <label for="name">单位名称</label>
					    <input type="text" class="form-control" id="name" name="name" placeholder="请输入单位名称" autofocus="autofocus" />
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
   
   
   <div class="footer">
   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   	$(function(){
   		
   		$("#page").page({
		    remote: {
		        url: contextPath + '/admin/employerList',
		        callback: function (result) {
		            var datas = result.datas;
			        var length = datas.length;
			        var html = "";
			       	//  如果没有数据，隐藏表头
		        	if(datas == null || length == 0){
						$("#head").hide();	
						html = "<div style='text-align:center;'>暂无数据...</div>";
		        	}else {
		        		$("#head").show();
		        		for(var i = 0; i < length; i++) {
							var data = datas[i];
							html += "<tr>"
								+ "<td>"+ (i+1) +"</td>"	
								+ "<td>"+ data.account +"</td>"	
								+ "<td>"+ data.name +"</td>"	
								+ "<td>"+ data.mobile +"</td>"	
								+ "<td>"+ data.teacher +"</td>"	
								+ "<td>"+ data.postNum +"</td>"	
								+ "<td>"+ data.totalMoney +"</td>"	
								+ "<td>"+ data.status +"</td>"	
								+ "<td>"
								+	"<button id='edit' class='btn btn-primary btn-sm mybtn'>编辑</button>&nbsp;&nbsp;"
								+	"<button id='delete' class='btn btn-primary btn-sm mybtn'>删除</button>"
								+ "</td>"	
								+ "</tr>";
			            }
		        	}
			    
			       	$("#t_body").html(html);
		        }
		    },

		    pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
		    pageSizeName: 'pageSize',       //请求参数，每页数量
			totalName: 'totalRecord'       //指定返回数据的总数据量
		});
   		
   		
   	});
   
   
   
   </script>
   

</body>
</html>














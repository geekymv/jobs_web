<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>工资列表</title>
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
    		vertical-align: bottom;
    	}
    	.mybtn {
			width: 50px;
			height: 27px;
		}
		
    </style>
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
	          <div class="panel-heading">工资列表</div>
	          <div class="panel-body">
				<div style="text-align: center;">
					<form class="form-inline">
					  <div class="form-group">
					    <label for="month">请选择月份</label>
					    <input type="text" class="form-control" id="month" name="month" placeholder="请选择月份"
					     onClick="WdatePicker({dateFmt:'yyyy-MM', maxDate:'%y-%M', isShowClear:false})" />
					  </div>
					  &nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="download">下载</button>&nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="search">查询</button>
					</form>
				</div>	
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead id="head">
	                <tr>
	                	<th>学号</th> <th>姓名</th> <th>工作时间</th> <th>基本工资</th>
	                	<th>工具费</th> <th>奖金</th> <th>月份</th> <th>备注</th> <th>选择操作</th> 
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
		
   		page();
   		
   		// 下载工资
   		$("#download").click(function(){
   			var month = $('#month').val();
   			if(month.trim() == '') {
   				alert('请选择月份！');
   				return;
   			}
			window.location.href= contextPath + "/download/" + month;		
   		});
   		
   		
   		$('#search').click(function(){
   			$('#page').page( 'destroy' )
			page();  			
   		});
   		
   	});
   	
   	function page() {
   		$("#page").page({
		    remote: {
		        url: contextPath + '/employer/salaryList',
		        params: {"month": $('#month').val()},
		        callback: function (result) {
		            //回调函数，result 为 请求返回的数据，绑定数据
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
								+ "<td>"+ data.num +"</td>"	
								+ "<td>"+ data.name +"</td>"	
								+ "<td>"+ data.worktime +"</td>"	
								+ "<td>"+ data.salary +"</td>"	
								+ "<td>"+ data.toolFee +"</td>"	
								+ "<td>"+ data.bonus +"</td>"	
								+ "<td>"+ data.month +"</td>"	
								+ "<td>"+ data.remarks +"</td>"	
								+ "<td>"
								+	"<button id='edit' class='btn btn-primary mybtn'>编辑</button>&nbsp;&nbsp;"
								+	"<button id='delete' class='btn btn-primary mybtn'>删除</button>"
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
   	}
   	
   
   </script>
   
 
</body>
</html>

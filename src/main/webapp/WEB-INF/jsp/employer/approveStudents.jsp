<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>待审核学生列表</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		
		table th, td {
			text-align: center;
			vertical-align: bottom;
		}
		
		div.nostudent {
			font-size: 14px;
			color: blue;
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
    <div class="row">
    	<div class="col-md-2">
			<div class="panel panel-primary">	 
			<div class="panel-heading">功能导航</div>
				<jsp:include page="left-sider.jsp"></jsp:include>
			</div>	
      	</div>
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">待审核学生列表</div>
	          <div class="panel-body">
	            <p>&nbsp;</p>
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr id="head">
	                   	<th>序号</th> <th>学号</th> <th>姓名</th> <th>联系方式</th> <th>专业</th> <th>岗位名称</th> <th>报名时间</th> <th>操作</th> 
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
   
   <div class="footer">
   	<jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
	
	<script type="text/javascript">
   		$(function(){
			$("#page").page({
			    remote: {
			        url: contextPath + '/employer/approveStudents',  //请求地址
			        callback: function (result) {
						$("tbody").empty();
			        	var datas = result.datas;
			        	var length = datas.length;
			        	//  如果没有数据，隐藏表头
			        	if(datas == null || length == 0){
							$("#head").hide();			        		
							$("tbody").html("<div class='nostudent'>暂无待审核的学生</div>");
			        	}else {
			        		$("#head").show();	
			        		
			        		var html = "";
	 			            for(var i = 0; i < length; i++) {
								var data = datas[i];
								html += "<tr>"
									+ "<td>"+ (i+1) +"</td>"	
									+ "<td>"+ data.num +"</td>"	
									+ "<td>"+ data.name +"</td>"	
									+ "<td>"+ data.mobile +"</td>"	
									+ "<td>"+ data.profession +"</td>"	
									+ "<td title="+data.postName+">"+ contentSubStr(data.postName) +"</td>"	
									+ "<td>"+ formatterDate(data.applyDate) +"</td>"	
									+ "<td>"
									+ "<button class='btn btn-primary btn-sm mybtn' onclick='hire("+data.stuId + "," +data.recId + ","+ 1 +")'>&nbsp;录用&nbsp;</button>&nbsp;&nbsp;"
									+ "<button class='btn btn-primary btn-sm mybtn' onclick='hire("+data.stuId + "," +data.recId + ","+ -1 +")'>不录用</button></td>" 
									+ "</tr>";
				            }
	 			            
	 			            $("tbody").html(html);
		 			            
			        	}
 			            
 			            // glyphicon glyphicon-ok-sign
						// glyphicon glyphicon-remove-sign
			        }
			    },
			    pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
			    pageSizeName: 'pageSize',       //请求参数，每页数量
				totalName: 'totalRecord'       //指定返回数据的总数据量
			});
			
			
   		});
   		// status -1不录用，1录用
   		function hire(stuId, recId, status) {
   			$.ajax({
   				url: contextPath + '/employer/approve',
   				type: 'post',
   				data: {'stuId': stuId, 'recId': recId, 'status': status},
   				dataType: 'text',
   				success: function(data){
	   				if(data == 'success') {
	   					alert('审核成功！');
						window.location.reload();
	   				}
   				}
   			});
   		}

   	</script>

</body>
</html>

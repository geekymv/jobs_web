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
    <div class="row">
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
	            <p>
	            	温馨提示：<br/>
	            	①当学生离职后，需要解聘该学生，否则该学生不能继续报名本单位发布的招聘信息！
	            </p>
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr id="head">
	                   	<th>序号</th> <th>学号</th> <th>姓名</th> <th>专业</th><th>操作</th> 
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
			        url: contextPath + '/employer/studentPage',  //请求地址
			        callback: function (result) {
						$("tbody").empty();
			        	var datas = result.datas;
			        	var length = datas.length;
			        	var html = "";
			        	//  如果没有数据，隐藏表头
			        	if(datas == null || length == 0){
							$("#head").hide();	
							html = "<div style='text-align:center;color:blue;'>暂无学生...</div>";
			        	}else {
			        		$("#head").show();	
		        		    for(var i = 0; i < length; i++) {
								var data = datas[i];
								var status = data.status;
								if("1" == status) {
									status = "在职";				
								}else if("-1" == status) {
									status = "离职";
								}
								
								html += "<tr>"
									+ "<td>"+ (i+1) +"</td>"	
									+ "<td>"+ data.num +"</td>"	
									+ "<td>"+ data.name +"</td>"	
									+ "<td>"+ data.profession +"</td>"	
									+ "<td>"+ data.postName +"</td>"	
									+ "<td>"+ data.salary +"</td>"
									+ "<td>"+ formatterDate(data.date) +"</td>"
									+ "<td><button class='btn btn-primary btn-sm mybtn' onclick='layoff("+ data.id +","+ data.num +")'>解聘</button></td>" 	
									+ "</tr>";
				            }
			        	}
 			            $("tbody").html(html);
			        }
			    },
			    pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
			    pageSizeName: 'pageSize',       //请求参数，每页数量
				totalName: 'totalRecord'       //指定返回数据的总数据量
			});
		
   		});
	
   		function layoff(stuId, stuNum) {
   			var res = confirm('确定要解聘学号是'+ stuNum +'的学生吗？')
			if(res) {
				// 解聘学生
				$.ajax({
					url: contextPath + '/employer/layoff',
					data: {'stuId': stuId}
				}).done(function(data){
					if(data == 'success') {
						alert('解聘成功！')
						window.location.reload();
					}
				}).fail(function(){
					alert('解聘失败！');
				});
			} 			
   		}
   		
   	</script>

</body>
</html>

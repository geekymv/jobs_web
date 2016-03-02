<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">		
	<title>招聘列表</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.pagination a {
		    cursor: pointer;
		    -moz-user-select: none;
		    -webkit-user-select: none;
		    -ms-user-select: none;
		    -khtml-user-select: none;
		    user-select: none;
		}
		
		table td, th {
			text-align: center;
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
	          <div class="panel-heading">招聘列表</div>
	          <div class="panel-body">
	          </div>
			  
			   <table class="table table-bordered table-hover table-condensed">
          		<thead id="head">
	                <tr>
	                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布时间</th> <th>截止日期</th> <th>基本工资</th> <th>查看详情</th>
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
			        url: contextPath + '/employer/myRecruits',
			        callback: function (result) {
			            //回调函数，result 为 请求返回的数据，绑定数据
			            var datas = result.datas;
 			            var length = datas.length;
 			            
 			           var html = "";
 			           
 			       		//  如果没有数据，隐藏表头
			        	if(datas == null || length == 0){
							$("#head").hide();	
							html = "<div style='text-align:center;'><a href='${ctx}/employer/publish'>您还没有发布招聘信息，马上去发布吧...</a></div>";
			        	}else {
			        		$("#head").show();
			        		for(var i = 0; i < length; i++) {
								var data = datas[i];
								html += "<tr>"
									+ "<td>"+ contentSubStr(data.title, 15) +"<input type='hidden' id='id' value='"+data.id+"'/></td>"	
									+ "<td>"+ contentSubStr(data.postName) +"</td>"	
									+ "<td>"+ formatterDate(data.releaseDate) +"</td>"	
									+ "<td>"+ formatterDate(data.endDate) +"</td>"	
									+ "<td>"+ data.salary +"</td>"	
									+ "<td><span title='查看' class='glyphicon glyphicon-eye-open myspan' onclick='show(this)'></span></td>"	
								//	+ "<td><a href='${ctx}/employer/detail/"+data.id+"' class='glyphicon glyphicon-pencil myspan'></a></td>"	
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
   		
   		function show(t) {
   			var $this = $(t);
   			var id = $this.parent().parent().find('#id').val();
   			window.location.href = contextPath+"/employer/detail/" + id;
   		}
   
   </script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">		
	<title>学生首页</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.left-sider a {
			font-weight: bold;
			text-align: center;
		}
		
		.pagination a {
		    cursor: pointer;
		    -moz-user-select: none;
		    -webkit-user-select: none;
		    -ms-user-select: none;
		    -khtml-user-select: none;
		    user-select: none;
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
	          <div class="panel-heading">个人首页</div>
	          <div class="panel-body">
	          </div>
	          <table class="table table-bordered table-hover table-condensed">
          		<thead>
	                <tr>
	                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布单位</th>
			  			<th>发布时间</th> <th>截止日期</th>  <th>查看详情</th>
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
			//	pageSize: 1,
			//	btnCount: 11, // 按钮数需要设置成奇数
				alwaysShowPage: true,
			    remote: {
			        url: contextPath + '/recruits',  //请求地址
			        callback: function (result) {
			            var datas = result.datas;
 			            var length = datas.length;
			            var html = "";
 			            for(var i = 0; i < length; i++) {
							var data = datas[i];
							html += "<tr>"
								+ "<td title="+data.title+">"+ contentSubStr(data.title) +"</td>"	
								+ "<td title="+data.postName+">"+ contentSubStr(data.postName) +"</td>"	
								+ "<td>"+ data.empName +"</td>"	
								+ "<td>"+ formatterDate(data.releaseDate) +"</td>"	
								+ "<td>"+ formatterDate(data.endDate) +"</td>"	
								+ "<td><a href='${ctx}/student/detail/"+data.id+"'>查看详情</a></td>"	
								+ "</tr>";
			            }
 			            $("tbody").html(html);
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

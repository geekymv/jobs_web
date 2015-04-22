<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>首页</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" />
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.custom{
			height:51px;
		}
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 450px;
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
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		  <div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 			     
               data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
              
			  <a class="navbar-brand" href="${ctx }/index">
              	<img alt="首页" src="<c:url value='/resources/img/index.png'/>" height="25"/>
              	首页
              </a>
			</div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
                <li><a href="explain.html" target="_blank">系统简介</a></li>
                <li><a href="gyhk.htm" target="_blank">开发团队</a></li>
                <li><a href="help.html" target="_blank">帮助中心</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
           	<c:if test="${user != null }">
           	<li role="presentation" class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" style="cursor: pointer;">
              		${user.name }
                   <span class="caret"></span>
                 </a>
                 <ul class="dropdown-menu" role="menu">
                   <li><a href="${ctx }/home">进入我的主页</a></li>
                 </ul>
            </li>
           	</c:if>

           	<c:if test="${user == null }">
           		<li>
            	<a href="${ctx }/login">登录 <span class="glyphicon glyphicon-log-in"></span></a>
           		</li>
           	</c:if>
           	
            <li class="divider-vertical"></li>
            <li>
            	<c:if test="${user != null }">
            		<a href="${ctx }/logout">退出 <span class="glyphicon glyphicon-log-out"></span></a>
            	</c:if>
            	<c:if test="${user == null }">
	            	<a href="${ctx }/register">注册 <span class="glyphicon glyphicon-user"></span></a>
            	</c:if>
            </li>
          </ul>
               
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <!-- 以上是导航菜单-->
    
    <!--空白处-->
    <div class="custom">
    </div>

    <div class="row row-top">
    	<div class="col-md-2">
      		<img src="<c:url value='/resources/img/hello.jpg'/>" alt="这是一张图片" title="这是一张图片吗" class="img-thumbnail">
       </div>
      <div class="col-md-10">
        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	          </div>
	        
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
          		<thead>
	                <tr>
	                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布单位</th>
			  			<th>发布时间</th> <th>截止日期</th>  <th>查看详情</th>
	                </tr>
	            </thead>
	            <tbody id="list">
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
	<div class="bottom_box">
	    <div class="bottom">
	        <p> Copyright &copy; 2014 安徽农业大学学生资助管理中心All Rights Reserved 
	        <br>技术支持：<a href="gyhk.htm" target="_blank">嘿客科技传媒</a>.   联系邮箱：1784160856@qq.com</p>
	        <a href="${ctx }/register" class="register">
				<img src="<c:url value='/resources/img/btn_register.png'/>" width="112" height="39" />
			</a>
	        <a href="${ctx }/login" class="ask">
				<img src="<c:url value='/resources/img/btn_ask.png'/>" width="112" height="39" />
			</a>
	    </div>
	    <div class="close"></div>  
	</div>

	<img class="mini" src="<c:url value='/resources/img/mini.png'/>" width="65" height="37" />
	
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
								+ "<td>"+ data.title +"</td>"	
								+ "<td>"+ data.postName +"</td>"	
								+ "<td>"+ data.empName +"</td>"	
								+ "<td>"+ formatterDate(data.releaseDate) +"</td>"	
								+ "<td>"+ formatterDate(data.endDate) +"</td>"	
								+ "<td><a href='${ctx}/detail/"+data.id+"'>查看详情</a></td>"	
								+ "</tr>";
			            }
 			            $("tbody").html(html);
			        }
			    },
				pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
				pageSizeName: 'pageSize',       //请求参数，每页数量
				totalName: 'totalRecord'       //指定返回数据的总数据量
			});

			// 首页底部效果
			setTimeout(function(){
				  $(".bottom_box").slideDown("slow");
				},2000);
			
			$(".close").click(function(){
				$(".bottom_box").hide();	
				$(".mini").show(200);	
			})
			$(".mini").click(function(){
				$(this).hide();	
				$(".bottom_box").show();	
			})
				
   		});
 
		
	</script>

</body>
</html>

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
	<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" />	
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
              
			  <a class="navbar-brand" href="index.do">
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
                 <a href="stu-info.jsp" class="dropdown-toggle" data-toggle="dropdown">
              		用户：${user.name }
                   <span class="caret"></span>
                 </a>
                
                 <ul class="dropdown-menu" role="menu">
                   <li><a href="user/login-success.do">进入我的主页</a></li>
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
            		<a href="user/user-logout">退出 <span class="glyphicon glyphicon-log-out"></span></a>
            	</c:if>
            	<c:if test="${user == null }">
	            	<a href="register.jsp">注册 <span class="glyphicon glyphicon-user"></span></a>
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

    <div class="row">
    	<div class="col-md-2">
      		<img src="<c:url value='/resources/img/hello.jpg'/>" alt="这是一张图片" title="这是一张图片吗" class="img-thumbnail">
       </div>
      <div class="col-md-10">
        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	            <p>&nbsp;</p>
	          </div>
	        
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	          	<c:choose>
	          		<c:when test="${fn:length(pager.datas) == 0}">
	            			没有招聘信息！
	            	</c:when>
	          		<c:otherwise>
		          		<thead>
			                <tr>
			                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布单位</th>
					  			<th>发布时间</th> <th>截止日期</th>  <th>查看详情</th>
			                </tr>
			            </thead>
			            <tbody>
		           			<c:forEach items="${pager.datas }" var="recruit">
		           				<td>${recruit.title }</td> 
		            			<td>${recruit.postName }</td> 
		            			<td>${recruit.employer.name }</td>
		            			<td>
		            				<fmt:formatDate value="${recruit.releaseDate }" pattern="yyyy年MM月dd日 hh:mm:ss"/>
		            			</td>
		            			<td>
		            				<fmt:formatDate value="${recruit.endDate }" pattern="yyyy年MM月dd日"/>
		            			</td>
		            			
			  					<td><a href="index-details.do?id=${id }">查看</a></td>
		           			</c:forEach>
			            </tbody>
	          		</c:otherwise>
	          	</c:choose>
	          </table>
	        <c:if test="${pager.totalPage > 1}">
			<div class="panel-footer">
          		<!-- 
	          	分页显示
	          	maxPageItems:每页显示的行数，默认为10 
	          	maxIndexPages:在循环输出页码的时候，最大输出多少个页码，默认是10 
	           -->	
	          <nav style="text-align:center;">
			  <ul class="pagination">
			      <pg:pager url="${pageContext.request.contextPath }/stu/index" items="${pager.totalRecord }" export="currentPageNumber=pageNumber" maxPageItems="3">  
					   <%--  <li><a>总记录数${pager.totalRecord }</a></li>
					    <li><a>总页数${pager.totalPage }</a></li>
					    <li><a>当前页${currentPageNumber }</a></li> --%>
					    
					    <c:if test="${currentPageNumber != 1 }">
					    <pg:first>
					    	<li><a href="${pageUrl}">首页</a></li>
					    </pg:first>  
					    </c:if>

					    <pg:prev>
					    	<li><a href="${pageUrl }">上一页</a></li>
					    </pg:prev>  
		
					   <pg:pages>  
				         <c:choose>  
				            <c:when test="${currentPageNumber eq pageNumber}">  
				             	<li class="active"><a>${pageNumber }</a></li>
				            </c:when>  
				            <c:otherwise>  
				           		 <li><a href="${pageUrl }">${pageNumber }</a></li>
				            </c:otherwise>  
				         </c:choose>  
				   	   </pg:pages>  
		
					    <pg:next>  
					        <li><a href="${pageUrl }">下一页</a></li>
					    </pg:next>  
					    
					    <c:if test="${currentPageNumber != pager.totalPage }">
					    <pg:last>  
					         <li><a href="${pageUrl }">尾页</a></li>  
					    </pg:last>  
					    </c:if> 
					</pg:pager>  
				</ul>
				</nav>
            </div>
            </c:if>
	         
	         
	        </div> <!-- end of panel -->
      </div>
	</div>
   </div><!-- /.container -->
	<div class="bottom_box">
	    <div class="bottom">
	        <p> Copyright &copy; 2014 安徽农业大学学生资助管理中心All Rights Reserved 
	        <br>技术支持：<a href="gyhk.htm" target="_blank">嘿客科技传媒</a>.   联系邮箱：1784160856@qq.com</p>
	        <a href="register.jsp" target="_blank" class="register">
				<img src="img/btn_register.png" width="112" height="39" />
			</a>
	        <a href="login.jsp" class="ask">
				<img src="img/btn_ask.png" width="112" height="39" />
			</a>
	    </div>
	    <div class="close"></div>  
	</div>

	<img class="mini" src="img/mini.png" width="65" height="37" />

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
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

<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>我的工作</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.left-sider a {
			font-weight: bold;
			text-align: center;
		} 
		table th, td {
			text-align: center;
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
    <div class="row">
    	<div class="col-md-2">
	    	<jsp:include page="left-sider.jsp"></jsp:include>
      	</div>
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">我的工作</div>
	        <c:choose>
	        	<c:when test="${fn:length(jobs) == 0}">
	        		<a href="${ctx }/student/home">暂无工作！快去报名吧...</a>
	        	</c:when>
	        	<c:otherwise>
		          <table class="table table-bordered table-hover table-condensed">
		            <thead>
		                <tr>
		                   	<th>岗位名称</th> <th>所在单位</th> <th>报名时间</th> <th>基本工资</th> <th>状态</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<c:forEach items="${jobs }" var="job">
		            		<tr>
		            			<td>${job.recruitName }</td>
		            			<td>${job.employer }</td>
		            			<td><fmt:formatDate value="${job.date }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
		            			<td>${job.salary }</td>
		            			<td>
		            			<c:choose>
		            				<c:when test="${job.status  == 1}">
		            					在职
		            				</c:when>
	            					<c:when test="${job.status  == 0}">
		            					离职
		            				</c:when>
		            			</c:choose>
		            			</td>
		            		</tr>
		            	</c:forEach>
		            </tbody>
		          </table>
	        	</c:otherwise>
	        </c:choose>	
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div><!-- /.container -->
   <div class="footer">
   	<jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
</body>
</html>

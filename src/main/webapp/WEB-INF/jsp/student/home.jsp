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
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 400px;
		}
		
		.left-sider a {
			font-weight: bold;
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
	          <div class="panel-heading">个人首页</div>
	          <div class="panel-body">
	            <p>&nbsp;</p>
	          </div>
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
		           			<tr>
		           				<td>${recruit.title }</td> 
		            			<td>${recruit.postName }</td> 
		            			<td>${recruit.employer.name }</td>
		            			<td>
		            				<fmt:formatDate value="${recruit.releaseDate }" pattern="yyyy-MM-dd hh:mm:ss"/>
		            			</td>
		            			<td>
		            				<fmt:formatDate value="${recruit.endDate }" pattern="yyyy-MM-dd"/>
		            			</td>
			  					<td>
			  						<a href="<c:url value='detail/${recruit.id }'/>">查看</a>
			  					</td>
			  				</tr>	
		           			</c:forEach>
			            </tbody>
	          		</c:otherwise>
	          	</c:choose>
	          </table>
	          <div class="panel-footer">
	            <!-- 
	          	分页显示
	          	maxPageItems:每页显示的行数，默认为10 
	          	maxIndexPages:在循环输出页码的时候，最大输出多少个页码，默认是10 
	           -->	
	           <nav style="text-align:center;">
			  	<ul class="pagination">
			      <pg:pager url="${ctx }/student/home" items="${pager.totalRecord }" export="currentPageNumber=pageNumber" maxPageItems="5">  
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
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div><!-- /.container -->
   
   <div class="footer">
   	<jsp:include page="../main/footer.jsp"></jsp:include>
   </div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>招聘详情</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		.custom{
			height:51px;
		}
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 190px;
		}
		.left-sider a {
			font-weight: bold;
			text-align: center;
		}
		td span {
			font-weight: bold;
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
	          <div class="panel-heading">招聘信息详情</div>
	          <div class="panel-body">
	            <p>&nbsp;</p>
	          </div>
	        
	        <c:if test="${recruit == null }">
	            	没有招聘信息！
	        </c:if>
	        <c:if test="${recruit != null }">
	         	<input type="hidden" id="rId" value="${recruit.id}"/>
	         	<table class="table table-bordered table-hover table-condensed">
	         		<caption><span style="font-size: 18px; font-weight: bold;">招聘信息</span></caption>
	         		<tr>
	         			<td><span>招聘信息标题：</span>${recruit.title }</td>
	         			<td><span>发布单位：</span>${recruit.empName }</td>
	         		</tr>
	         		<tr>
	         			<td><span>岗位名称：</span>${recruit.postName }</td>
	         			<td><span>薪资待遇：</span>${recruit.salary }</td>
	         		</tr>
	         		<tr>
	         			<td><span>招聘人数：</span>${recruit.postNum }</td>
	         			<td><span>已报名人数：</span>${recruit.applyNum }</td>
	         		</tr>
	         		<tr>
	         			<td colspan="2">
		         			<span>工作要求：</span>
		         			<c:choose>
		         				<c:when test="${recruit.context  == null }">
		         					暂无
		         				</c:when>
		         				<c:otherwise>
		         					${recruit.context}
		         				</c:otherwise>
		         			</c:choose>
	         			</td>
	         		</tr>
					<tr>
						<td>
							<span>发布时间：</span>
							<fmt:formatDate value="${recruit.releaseDate }" pattern="yyyy-MM-dd hh:dd:ss"/>
						</td>
						<td>
							<span>截止时间：</span>
							<fmt:formatDate value="${recruit.endDate }" pattern="yyyy-MM-dd hh:dd:ss"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<span>备注：</span>
							<c:choose>
								<c:when test="${recruit.remarks == null}">
									无
								</c:when>
								<c:otherwise>
									${recruit.remarks}
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
	         	</table>
	         	
	         	<c:choose>
	         		<c:when test="${isApply == 'isApplyed' }">
	         			<button id="apply" class="btn btn-primary"
							 style="margin-top: 20px;margin-left: 400px; margin-bottom: 30px;">马上报名</button>
	         		</c:when>
	         		<c:otherwise>
	         			<span class="btn btn-success" style="margin-top: 20px;margin-left: 400px; margin-bottom: 30px;">我已报名</span>
	         		</c:otherwise>
	         	</c:choose>

	        </c:if>
    	</div>
		</div>
   </div>
   </div><!-- /.container -->
   
   <div class="footer">
   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   		$(function(){
   			$("#apply").click(function(){
   				$.ajax({
   					url: contextPath + "/student/apply",
   					type: "post",
   					data:{"recId": '${recruit.id}'},
   					success:function(data){
   						if(data == "success"){
   							alert("报名成功！");
   							window.location.reload();
   						}
   					}
   				});  
   			});
   		});
   </script>

</body>
</html>

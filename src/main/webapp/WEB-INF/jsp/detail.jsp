<%@ page language="java" import="java.util.*, com.heike.domain.pojo.Student" pageEncoding="utf-8"%>
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
		#students th, #students td{
			text-align: center;
		}
		
		td span {
			font-weight: bold;
		}
		
		.mybtn {
			margin-top: 20px;
			margin-left: 10px;
			margin-bottom: 30px;
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
                <li><a href="${ctx }/introduce" target="_blank">系统简介</a></li>
                <li><a href="javascript:;" target="_blank">开发团队</a></li>
                <li><a href="${ctx }/help" target="_blank">帮助中心</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
           	<c:if test="${user != null }">
	           	<li role="presentation" class="dropdown">
	                 <a href="stu-info.jsp" class="dropdown-toggle" data-toggle="dropdown">
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
	          <div class="panel-heading">招聘信息详情</div>
	          <div class="panel-body">
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
	         			
	         			<td width="200px;"><span>发布单位：</span>${recruit.empName }</td>
	         			 
	         		</tr>
	         		<tr>
	         			<td><span>岗位名称：</span>${recruit.postName }</td>
	         			<td width="200px;"><span>薪资待遇：</span>${recruit.salary }</td>
	         		</tr>
	         		<tr>
	         			<td><span>招聘人数：</span>${recruit.postNum }</td>
	         			<td width="200px;"><span>已报名人数：</span>${recruit.applyNum }</td>
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
							<span id="releaseDate">发布时间：</span>
						</td>
						<td width="200px;">
							<span id="endDate">截止时间：</span>
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
				
				<%-- 如果是学生显示报名功能 --%>
				<%
					Object obj = session.getAttribute("user");
					// 是学生显示我要报名功能
					if(obj instanceof Student) {
					%>
					<div style="text-align: center;">
						<button type="button" id="showStudents" class="btn btn-primary mybtn" >查看已报名学生</button>
						<button type="button" class="btn btn-primary mybtn" id="apply">我要报名</button>	
					</div>
					<%
					}else {
					%>
					<div style="text-align: center;">
						<button id="showStudents" class="btn btn-primary mybtn">查看已报名学生</button>
					</div>
					<%
					}
				%>
	        </c:if>
	        <div id="students"></div>
	        </div> <!-- end of panel -->
    	</div>
    
	</div>
   </div><!-- /.container -->
   
   <div class="footer">
   <jsp:include page="inc/footer.jsp"></jsp:include>
   </div>

<script type="text/javascript">
	$(function(){
		var apply = $('.col-md-10').find('#apply').attr('type');
	//	alert(typeof(apply))
		if(apply == undefined) {
			// 不是学生
		} else if(apply == 'button') {
			// 学生，判断学生是否已经报名了
			$.post(contextPath+"/student/isApply", {'recId': '${recruit.id}'}).done(function(msg){
				if(msg == 'isApplyed') {
					$('#apply').hide();
					$('#showStudents').after('<button class="btn btn-success mybtn">我已报名</button>');
				}else if(msg == 'notApply') {
					
				}
			}).fail(function(msg){
				
			});
		}
		
		// 日期处理
		var releaseDate = '${recruit.releaseDate }';	// 发布时间
		$("#releaseDate").after(formatterDate(releaseDate));
		var endDate = '${recruit.endDate }';	// 截止时间
		$("#endDate").after(formatterDate(endDate));
		
		// 我要报名
		$("#apply").click(function(){
				// 按钮不能点击
				$("#apply").attr('disabled', true);
				$.ajax({
					url: contextPath + "/student/apply",
					type: "post",
					data:{"recId": '${recruit.id}', 'empId': '${recruit.empId}'},
					success:function(data){
						// "onJob" 在职, "isApplyed" 已在该用工单位报名, "success"报名成功，"fail"报名失败
						if(data == 'isPastDue') {
							alert("已经过了报名时间了！");
							return;
						}
						if(data == "onJob") {
							alert("你已经在该用工单位任职了！");
							return;
						}
						if(data == "isApplyed") {
							alert("你已经在该用工单位报名了！");
							return;
						}
						if(data == "success"){
							alert("报名成功！");
							window.location.reload();
						}
						if(data == "fail"){
							alert("报名失败！");
							window.location.reload();
						}
					}
				});
				
				// 3秒后可以点击				
				setTimeout(function () {
					$("#apply").attr('disabled', false);
				}, 3000); 	
			});
		
		
		$("#showStudents").button().on("click", function() {
			$.post("${ctx}/getApplyStudents",
					{"id": $("#rId").val()}, 
					function(data){
				$("#students").empty();
				if(data == null || data.length == 0){
					alert("还没有学生报名！");
					return;
				}
				
				var html = "<table class='table table-bordered table-hover table-condensed'>"
					 + "<caption>学生信息</caption>"
					 + "<tr>"
					 + "<th>序号</th> <th>学号</th> <th>姓名</th> <th>专业</th> <th>报名时间</th> <th>审核结果</th>"
					 + "</tr>";
					var flag = "";
					for(var i = 0; i < data.length; i++){
						var vo = data[i];
						var num = vo.num;
						var name = vo.name;
						var profession = vo.profession;
						var applyDate = vo.applyDate;
						var status = vo.status;
						
						if(status == 0){	//等待处理
							flag = "等待审核";
						}else if(status == 1) {	//已通过
							flag = "已录用";
						}else if(status == -1) {
							flag = "未录用";
						}				
						
						html += "<tr>"
							 + "<td>" + (i+1) +"</td>"
							 + "<td align='center'>"+num+"</td>"+ "<td>"+name+"</td>"
							 + "<td>"+ profession +"</td>" 
							 + "<td>"+ formatterDate(applyDate)	+"</td>" 
							 + "<td><span style='color:#00CC33'>"+flag+"</span></td>"
							 + "</tr>";
					}
					html += "</table>";
					$("#students").append(html);
				});
		});
		
	});

	
</script>
</body>
</html>

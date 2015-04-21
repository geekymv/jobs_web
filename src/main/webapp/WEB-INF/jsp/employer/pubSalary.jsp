<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>提交工资</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>
	<style type="text/css">
		table th, td {
			text-align: center;
		}
		
		.mybtn {
			width: 70px;
			height: 27px;
		}
		
		.div-top {
			margin-top: 6px;
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
	          <div class="panel-heading">提交工资</div>
	          <div class="panel-body">
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr id="head">
	                   	<th>序号</th> <th>学号</th> <th>姓名</th> <th>专业</th> <th>岗位名称</th> <th>基本工资</th> <th>审核时间</th> <th>操作</th> 
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
   

<%--   
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>
 --%>
 
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">工资提交</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
           <div class="form-group">
           	 <div class="col-sm-2">
           	 </div> 
		 	 <div class="col-sm-7 alert alert-warning" style="width: 400px;" role="alert" id="tips">
			  <strong id="tip">提示</strong> 该月的工资已经提交了！！！
		  	</div>
		  </div>
         
          <div class="form-group">
		    <label for="num" class="col-sm-3 control-label">学号</label>
		    <div class="col-sm-7 div-top" id="num">
		    </div>
		    <input type="hidden" name="stuId" id="stuId" />
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-3 control-label">姓名</label>
		    <div class="col-sm-7 div-top" id="name">
		    </div>
		  </div>

          <div class="form-group">
		    <label for="month" class="col-sm-3 control-label">月份</label>
		    <div class="col-sm-7">
		      <input type="text" class="form-control" id="month" name="month" 
		      onClick="WdatePicker({dateFmt:'yyyy-MM', maxDate:'%y-%M', isShowClear:false})"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="worktime" class="col-sm-3 control-label">工作时间（小时）</label>
		    <div class="col-sm-7">
		      <input type="text" class="form-control" id="worktime" name="worktime">
		    </div>
		  </div>  
			
		  <div class="form-group">
		    <label for="salary" class="col-sm-3 control-label">基本工资（元/月）</label>
		    <div class="col-sm-7">
		      <input type="text" class="form-control" id="salary" name="salary">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="bonus" class="col-sm-3 control-label">奖金（元）</label>
		    <div class="col-sm-7">
		      <input type="text" class="form-control" id="bonus" name="bonus">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="toolFee" class="col-sm-3 control-label">工具费（元）</label>
		    <div class="col-sm-7">
		      <input type="text" class="form-control" id="toolFee" name="toolFee">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="remarks" class="col-sm-3 control-label">备注</label>
		    <div class="col-sm-7">
		      <textarea class="form-control" id="remarks" name="remarks"></textarea>
		    </div>
		  </div>
		</form>
      </div>
     
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="pubSalary">提交</button>
      </div>
    </div>
  </div>
</div>
   
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
							html = "<div style='text-align:center;color:blue;'>暂无数据...</div>";
			        	}else {
			        		$("#head").show();	
			        	}
 			            
			          
 			            for(var i = 0; i < length; i++) {
							var data = datas[i];
							var status = data.status;
							if("1" == status) {
								status = "在职";				
							}else if("-1" == status) {
								status = "离职";
							}
							
							html += "<tr>"
								+ "<td>"+ (i+1) +"<input type='hidden' id='_stuId' value='" +data.id+ "'></td>"	
								+ "<td id='_num'>"+ data.num +"</td>"	
								+ "<td id='_name'>"+ data.name +"</td>"	
								+ "<td>"+ data.profession +"</td>"	
								+ "<td>"+ data.postName +"</td>"	
								+ "<td>"+ data.salary +"</td>"
								+ "<td>"+ formatterDate(data.date) +"</td>"
								+ '<td><button class="btn btn-primary btn-sm" onclick="layoff(this)" data-toggle="modal" data-target="#myModal">提交工资</button></td>' 	
								+ "</tr>";
			            }
 			            
 			            $("tbody").html(html);
			        }
			    },
			    pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
			    pageSizeName: 'pageSize',       //请求参数，每页数量
				totalName: 'totalRecord'       //指定返回数据的总数据量
			});
			
   			
			$('#tips').hide();
   			// 工作时间获得焦点
   			$('#worktime').focus(function(){
   				var month = $('#month').val();
   				if(month.trim() == '') {
   					alert('请选择月份');
   					return;
   				}
   				
				var stuId = $('#stuId').val();
				var month = $('#month').val();
				// 判断当前月的工资是否已经提交
				$.ajax({
					url: contextPath + '/employer/isPubSalary',
					type: 'POST',
					data: {'stuId': stuId, 'month': month},
					dataType: 'text'
					
				}).done(function(data){
					if(data == 'isPublished') {
						$('#tips').show();
						$('#pubSalary').attr('disabled', 'disabled')
						
					}else if(data == 'noPublished') {
						$('#pubSalary').removeAttr('disabled')
						$('#tips').hide();
					}
					
				}).fail(function(){
					
				});

   			});
   		
			// 提交工资
			$('#pubSalary').click(function(){
				var stuId = $('#stuId').val();
				var month = $('#month').val();

				if(month.trim() == '') {
					alert('请选择月份！');
					return;
				}
				
				
				// 判断当前月的工资是否已经提交
				$.ajax({
					url: contextPath + '/employer/isPubSalary',
					type: 'POST',
					data: {'stuId': stuId, 'month': month},
					dataType: 'text'
					
				}).done(function(data){
					if(data == 'isPublished') {
						$('#tips').show();
						return;
					}else if(data == 'noPublished') {
						$('#tips').hide();
						// ==
						var fffds = /^\d+(\.\d+)?$/;	// 匹配非负浮点数(0、正浮点数)
						var zfds = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/; //匹配正浮点数
						var ffzs =   /^\d+$/; // 匹配非负整数
						
						// 工作时间是非负浮点数 、 0、 非负整数	
						var worktime = $('#worktime').val();
						if(worktime.trim() == "") {
							alert('工作时间不能为空！');
							$('#worktime').focus();
							return;
						}
						if(!ffzs.test(worktime) || !fffds.test(worktime)) {
							alert('工作时间不合法！');	
							$('#worktime').focus();
							return;
						}
						
						var salary = $('#salary').val();
						if(salary.trim() == "") {
							alert('基本工资不能为空！');
							$('#salary').focus();
							return;
						}
						if(!ffzs.test(salary) || !fffds.test(salary)) {
							alert('基本工资不合法！');	
							$('#salary').focus();
							return;
						}
						
						var bonus = $('#bonus').val();
						if(bonus.trim() == "") {
							alert('奖金不能为空！');
							$('#bonus').focus();
							return;
						}
						if(!ffzs.test(bonus) || !fffds.test(bonus)) {
							alert('奖金不合法！');	
							$('#salary').focus();
							return;
						}
						
						var toolFee = $('#toolFee').val();
						if(toolFee.trim() == "") {
							alert('工具费不能为空！');
							$('#toolFee').focus();
							return;
						}
						if(!ffzs.test(toolFee) || !fffds.test(toolFee)) {
							alert('工具费不合法！');	
							$('#toolFee').focus();
							return;
						}

						var remarks = $('#remarks').val();
						
						// 提交工资
						$.ajax({
							url: contextPath + '/employer/pubSalary',
							type: 'POST',
							data: {'stuId': stuId, 'month': month, 'worktime': worktime, 'salary': salary, 
								'bonus': bonus, 'toolFee': toolFee, 'remarks': remarks },
							dataType: 'text'
						}).done(function(data){
							if(data == 'success') {
								alert('提交成功！');
								$('#myModal').modal('hide')
							}	
							
						}).fail(function(){
							
						});						
						//===
					}
					
				}).fail(function(){
					
				});
				
			});
   			
		
   		});
	
   		
   		function layoff(t) {
			var $this = $(t)
			var $tr = $this.parent().parent();
			// 学号
			var num_val= $tr.find('#_num').text();
			// 姓名
			var name_val = $tr.find('#_name').text();
			// id
			var stuId = $tr.find('#_stuId').val();
			
			// 将学号、姓名和id显示在模态框上
			$('#num').html(num_val);
			$('#name').html(name_val);
			$('#stuId').val(stuId);
   		
   		}
   		
   		
   		
   	</script>

</body>
</html>

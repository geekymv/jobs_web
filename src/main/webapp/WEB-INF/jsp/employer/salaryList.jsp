<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>工资列表</title>
	<%@ include file="/WEB-INF/jsp/inc/style.jsp" %>

	<link href="<c:url value='/resources/css/zzsc.css'/>" rel="stylesheet"/>	
	<script src="<c:url value='/resources/js/showlist.js'/>"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	table th, td {
    		text-align: center;
    		vertical-align: bottom;
    	}
    	.mybtn {
			width: 50px;
			height: 27px;
		}
		
    </style>
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
	          <div class="panel-heading">工资列表</div>
	          <div class="panel-body">
				<div style="text-align: center;">
					<form class="form-inline">
					  <div class="form-group">
					    <label for="month">请选择月份</label>
					    <input type="text" class="form-control" id="content" name="month" placeholder="请选择月份"
					     onClick="WdatePicker({dateFmt:'yyyy-MM', maxDate:'%y-%M', isShowClear:false})" />
					  </div>
					  &nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="search">查询</button>
					  &nbsp;&nbsp;
					  <button type="button" class="btn btn-primary" id="download">下载</button> 
					</form>
				</div>	
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead id="head">
	                <tr>
	                	<th>学号</th> <th>姓名</th> <th>工作时间</th> <th>基本工资</th>
	                	<th>工具费</th> <th>奖金</th> <th>月份</th> <th>备注</th> <th>选择操作</th> 
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

<!-- 编辑工资Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">编辑工资</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <div class="form-group">
		    <label for="num" class="col-sm-3 control-label">学号</label>
		    <div class="col-sm-7 div-top" id="num">
		    </div>
		    <!-- 薪水id -->
		    <input type="hidden" name="id" id="salId" />
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-3 control-label">姓名</label>
		    <div class="col-sm-7 div-top" id="name">
		    </div>
		  </div>

          <div class="form-group">
		    <label for="month" class="col-sm-3 control-label">月份</label>
		    <div class="col-sm-7 div-top" id="month">
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
        <button type="button" class="btn btn-primary" id="updateSalary">更新</button>
      </div>
    </div>
  </div>
</div>
   
   <div class="footer">
	   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   	$(function(){
		
   		page();
   		
   		// 下载工资
   		$("#download").click(function(){
   			var month = $('#content').val();
   			if(month.trim() == '') {
   				alert('请选择月份！');
   				return;
   			}
			window.location.href= contextPath + "/download/" + month;		
   		});
   		
   		
   		$('#search').click(function(){
   			$('#page').page( 'destroy' )
			page();  			
   		});
   		
   		// 更新工资
   		$('#updateSalary').click(function(){
			// 数据合法性验证
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
				
			var id = $('#id').val();
			var remarks = $('#remarks').val();
			var month = $('#month').html();
			
			var datas = {'id': id, 'month': month, 'worktime': worktime, 'salary': salary, 
				'bonus': bonus, 'toolFee': toolFee, 'remarks': remarks };
			
			// 更新
			$.post(contextPath+'/employer/editSalary', datas).done(function(msg){
				if(msg == 'overspend') {
					alert('超支了！');
					return;
				}
				
				if(msg == 'success') {
					alert('更新成功！');
					// 关闭模态框
					$('#myModal').modal('hide');
					window.location.reload();
				}else if (msg == 'fail'){
					alert('更新失败！');
				}
			}).fail(function(msg){
				alert('服务器端错误！');
			});
			
			
   		});
   	});
   	
   	function page() {
   		$("#page").page({
		    remote: {
		        url: contextPath + '/employer/salaryList',
		        params: {"month": $('#content').val()},
		        callback: function (result) {
		            //回调函数，result 为 请求返回的数据，绑定数据
		            var datas = result.datas;
			        var length = datas.length;
			        var html = "";
			       	//  如果没有数据，隐藏表头
		        	if(datas == null || length == 0){
						$("#head").hide();	
						html = "<div style='text-align:center;'>当前月暂无数据...</div>";
		        	}else {
		        		$("#head").show();
		        		for(var i = 0; i < length; i++) {
							var data = datas[i];
							html += "<tr>"
								+ "<td id='num_'>"+ data.num +"</td>"	
								+ "<td id='name_'>"+ data.name +"</td>"	
								+ "<td id='worktime_'>"+ data.worktime +"</td>"	
								+ "<td id='salary_'>"+ data.salary +"</td>"	
								+ "<td id='toolFee_'>"+ data.toolFee +"</td>"	
								+ "<td id='bonus_'>"+ data.bonus +"</td>"	
								+ "<td id='month_'>"+ data.month +"</td>"	
								+ "<td id='remarks_'>"+ data.remarks +"</td>"	
								+ "<td>"
								+	"<button id='edit' onclick='edit(this)' class='btn btn-primary btn-sm mybtn'>编辑</button>&nbsp;&nbsp;"
								+	"<button id='delete' onclick='del(this)' class='btn btn-primary btn-sm mybtn'>删除</button>"
								+ "<input type='hidden' id='id' value='"+data.id+"' />"
								+ "</td>"	
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
   	}
   	
   	function edit(t) {
   		var $this = $(t);
   		var $tr = $this.parent().parent();
   		var id = $tr.find('#id').val();
   		var month = $tr.find('#month_').html().trim();
   		
   		$.post(contextPath+"/employer/isEdit", {'month': month}).done(function(msg){
			if('noEdit' == msg){
				alert('不可编辑！');
				return;
			}else if ('ok' == msg) {
				// 调用模态框
				$('#myModal').modal('show');
				var num = $tr.find('#num_').html().trim();
				var name = $tr.find('#name_').html().trim();
			//	var month = $tr.find('#month_').html().trim();
				var worktime = $tr.find('#worktime_').html().trim();
				var salary = $tr.find('#salary_').html().trim();
				var toolFee = $tr.find('#toolFee_').html().trim();
				var bonus = $tr.find('#bonus_').html().trim();
				var remarks = $tr.find('#remarks_').html().trim();
				
				$('#salId').attr('value', id);
				$('#num').html(num);
				$('#name').html(name);
				$('#month').html(month);
				$('#worktime').attr('value', worktime);
				$('#salary').attr('value', salary);
				$('#toolFee').attr('value', toolFee);
				$('#bonus').attr('value', bonus);
				$('#remarks').attr('value', remarks);
				
			}  			
   		}).fail(function(msg){
   			alert('服务器端错误！');
   		});
   	}
   	
   
   	
   
   </script>
   
 
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>专业列表</title>
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
   		}
   		
   		.mybtn {
			width: 45px;
			height: 27px;
		}
		
		
   	</style>
   	
	</head>

<body>
	<div class="container">
	
	<jsp:include page="../inc/nav.jsp"></jsp:include>
      
    <div class="row row-top">
       	<div class="col-md-2">
       		<div class="panel panel-primary">
    		  <div class="panel-heading">功能导航</div>	
			  <jsp:include page="left-sider.jsp"></jsp:include>	
			</div>
     	</div>
    
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">${dict.name }&nbsp;专业列表</div>
	          <div class="panel-body" style="text-align: center;">
	          	<button class="btn btn-success" id="addProfession">添加专业</button>
			  </div>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead id="head">
	                <tr>
	                   	 <th>序号</th> <th>专业名称</th> <th>操作</th>
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
    <%-- 用工单位模态框 --%>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="width: 660px;">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加专业</h4>
	      </div>
	      <div class="modal-body">
      		<form class="form-horizontal" role="form" id="form" >
     	  	  <div class="form-group">
        		<label class="col-md-4 control-label">专业名称：</label>
        		<div class="col-md-5">
        			 <input type="text" id="name" class="form-control" />
        			 <input type="hidden" id="pro_id" class="form-control" />
        		</div>
       		 </div>
        	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="add_profession">添加</button>
	      </div>
	    </div>
	  </div>
	</div>   
   
   <div class="footer">
   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
	
	<script type="text/javascript">
		$(function(){
			// 此事件在模态框被隐藏（并且同时在 CSS 过渡效果完成）之后被触发。
			$('#myModal').on('hidden.bs.modal', function (e) {
				window.location.reload();
			})
			
			// 添加专业
			$('#addProfession').click(function(){
				$('#myModal').modal('show');
			});
			
			$('#add_profession').click(function() {
				var name = $('#name').val();
				if($.trim(name) == '') {
					alert('专业名称不能为空！');
					$('#name').focus();
					return;
				}
				
				$.post(contextPath+'/admin/addProfession', 
						{'superiorId': '${dict.id}' , 'id': $('#pro_id').val(),  'name': name}).done(function(msg){
					if(msg == 'isExist') {
						alert('该专业已经存在！');
						return;
					}
					if(msg == 'success') {
						alert('操作成功！');
						$('#myModal').modal('hide');
						window.location.reload();
						
					}else if(msg == 'fail') {
						alert('操作失败！');
					}
					
				}).fail(function(){
					alert('服务器端错误！');
				});	
			});
			
			$.post(contextPath+'/getProfessions', {'colId': '${dict.id}'}).done(function(data){
				if(data == null) {
					return;
				}
				var len = data.length;
				var html = "";
				for(var i = 0; i < len; i++) {
					var pro = data[i];
					html += "<tr>"
						+ "<td>"+ (i+1) +"<input type='hidden' id='id' value='"+pro.id+"'></td>"
						+ "<td id='pro_name'>"+ pro.name +"</td>"
						+ "<td>"
							+ "&nbsp;&nbsp;<span title='编辑' class='glyphicon glyphicon-pencil myspan' onclick='edit(this)'></span>"
						//	+ "&nbsp;&nbsp;<span title='删除' class='glyphicon glyphicon-trash myspan' onclick='del(this)'></span>"
						
						+"</td>"
						+ "</tr>";
				}
				
				$('#t_body').html(html);
				
			}).fail(function(){
				alert('服务器端错误！');
			});			
			
		});
		
		// 编辑专业
		function edit(t) {
			var $this = $(t);
			var $tr =  $this.parent().parent();
			var proId = $tr.find('#id').val();
			var name = $tr.find('#pro_name').html();
			
		
			$('#myModal').modal('show');
			$('#myModalLabel').html('更新专业');
			$('#add_profession').html('更新');
			$('#name').val(name);
			$('#pro_id').val(proId);
		}
		
		// 删除专业
		function del(t) {
			var $this = $(t);
			var $tr =  $this.parent().parent();
			var proId = $tr.find('#id').val();
			if(confirm('确定要删除么？')) {
				$.post(contextPath+'/admin/deleteDict', {'id': proId}).done(function(msg){
					if(msg == 'success') {
						alert('操作成功！');
						window.location.reload();
						
					}else if(msg == 'fail') {
						alert('操作失败！');
					}
					
				}).fail(function(msg){
					alert('服务器端错误！');
				});
			}
		}
	
	</script>    

</body>
</html>














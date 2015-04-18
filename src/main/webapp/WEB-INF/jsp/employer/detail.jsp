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
			
			margin-top: 250px;
		}
		ul li {
			line-height: 40px;
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
	          <div class="panel-heading">招聘信息详情</div>
	            	<form class="form-horizontal" role="form" style="margin-top: 10px;">
	     	  		<div class="form-group">
		        		<label class="col-md-4 control-label">招聘标题：</label>
		        		<div  class="col-md-3">
		        			<input type="text" class="form-control" id="title" name="title" value="${recruit.title }" autofocus="autofocus" />
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">岗位名称：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="postName" name="postName" value="${recruit.postName }" />
		        			<input type="hidden" id="id" name="id" value="${recruit.id }" />
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">招聘人数：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="postNum" name="postNum" value="${recruit.postNum }" maxlength="3" />
		        		</div>
	        		</div>
	        		
	        		<div class="form-group">
		        		<label for="applyNum" class="col-md-4 control-label">报名人数：</label>
		        		<div class="col-md-3 div-top">
							${recruit.applyNum }人
		        		</div>
	        		</div>
	        		
	        		
	        		<div class="form-group">
		        		<label for="name" class="col-md-4 control-label">薪资待遇：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="salary" name="salary" value="${recruit.salary }" />
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="context" class="col-md-4 control-label">工作要求：</label>
		        		<div class="col-md-3">
		        			<textarea class="form-control" id="context" rows="5" id="context" name="context">${recruit.context }</textarea>	
		        		</div>
	        		</div>
	        		<div class="form-group">
		        		<label for="releaseDate" class="col-md-4 control-label">发布日期：</label>
		        		<div class="col-md-3 div-top" id="releaseDate">
		        			${recruit.releaseDate }
		      			</div>
	      			</div>
	        		<div class="form-group">
		        		<label for="endDate" class="col-md-4 control-label">截止日期：</label>
		        		<div class="col-md-3">
		        			<input type="text" class="form-control" id="endDate" name="endDate" 
		        			 onFocus="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'%y-%M-%d', isShowClear:false, readOnly:true})" />
		      			</div>
	      			</div>
	        		<div class="form-group">
			            <label class="col-md-4 control-label"></label>	
			            <div class="col-md-7" id="is_applyed">
			          	  <input type="button" id="edit" class="btn btn-primary" value="更新"/>
			          	  &nbsp;
			          	  <input type="button" id="delete" class="btn btn-primary" value="删除"/>
			            </div>
		         	</div>
		        </form> 
	          
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div><!-- /.container -->
   
   <div class="footer">
	   <jsp:include page="../inc/footer.jsp"></jsp:include>
   </div>
   
   <script type="text/javascript">
   	$(function() {
		var endDate = '${recruit.endDate }';
		$("#endDate").attr("value", dateFormatter(endDate));
		
		var releaseDate = '${recruit.releaseDate }';
		$("#releaseDate").html(dateFormatter(releaseDate));
		
		// 判断该招聘信息是否被申请
		$.ajax({
			url: contextPath + '/employer/isApply',
			type: 'POST',
			data: {'recId': $("#id").val()},
			dataType: 'text',
			success: function(data) {
				if(data == 'isApplyed') {
					$('#title').attr('readonly', 'readonly')
					$('#postNum').attr('readonly', 'readonly')
					$('#postName').attr('readonly', 'readonly')
					$('#endDate').attr('readonly', 'readonly')
					$('#endDate').removeAttr('onFocus')
					$('#salary').attr('readonly', 'readonly')
					$('#context').attr('readonly', 'readonly')
					$("#is_applyed").html('<span color="red">已经被申请了，不可编辑</span>');
				}else if(data == 'notApplyed') {
				}					
			}
		});
		
		// 删除
		$("#delete").click(function() {
			$.ajax({
				url: contextPath + "/employer/deleteRecruit",
				data: {"id": $("#id").val()},
				type: "POST",
				success: function(data) {
					if(data == "success") {
						alert("删除成功！");
					}else if(data == "fail") {
						alert("删除失败！");						
					}
				}
			});	
		});
		
		// 编辑
		$("#edit").click(function() {
			// 标题
			var title = $("#title");
			if(title.val().trim() == "") {
				alert("标题不能为空！");
				title.focus();
				return;
			}
			// 岗位名称
			var postName = $("#postName");
			if(postName.val().trim() == "") {
				alert("岗位名称不能为空！");
				postName.focus();
				return;
			}
			// 正整数
			var reg = /^(?:[1-9]\d*|0)$/;
			// 招聘人数
			var postNum = $("#postNum");
			if(postNum.val().trim() == "") {
				alert("招聘人数不能为空！");
				postNum.focus();
				return;
			}
			if(!reg.test(postNum.val())) {
				alert("招聘人数非法！");
				postNum.focus();
				return;
			}

			// 薪资待遇
			var salary = $("#salary");
			if(salary.val().trim() == "") {
				alert("薪资待遇不能为空！");
				salary.focus();
				return;
			}
			
			// 工作要求
			var context = $("#context");
			if(context.val().trim() == "") {
				alert("工作要求不能为空！");
				context.focus();
				return;
			}
			
			// 截止日期
			var endDate = $("#endDate").val();
			if(endDate == "") {
				alert("截止日期不能为空！");
				return;
			}
			// 替换所有的'-'				
			endDate = endDate.replace(/-/g, "");
			endDate = endDate + "240000";
			
			var values = {"id": $("#id").val(), "title" : title.val(), "postName": postName.val(), "postNum": postNum.val(), 
					"salary": salary.val(), "context": context.val(), "endDate": endDate};	
			
			$.ajax({
				url: contextPath + "/employer/editRecruit",
				data: values,
				type: "POST",
				success: function(data) {
					if(data == "success") {
						alert("更新成功！");
					}else if(data == "fail") {
						alert("更新失败！");						
					}
				}
			});

		});
		
	
   	});
   	
   	function dateFormatter(time) {
   		if (time.length == 14) {
   			return time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
   					+ time.substring(6, 8);
   		}
   		return "&nbsp;";
   	}
   
   
   
   </script>

</body>
</html>



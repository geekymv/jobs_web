$(function(){
	
	// 此事件在模态框被隐藏（并且同时在 CSS 过渡效果完成）之后被触发。
	$('#myModal').on('hidden.bs.modal', function (e) {
		window.location.reload();
	})
	
	page();
	
	$('#search').click(function(){
		$('#page').page( 'destroy' )
		page();  			
	});
	
	/*
	 * 后台验证用工单位账号
	 * 不能和其他用工单位的账号重复
	 */
	$('#account').blur(function(){
		var id = $("#id").val();
		var account = $('#account').val();
		
   		$.post(contextPath+'/empIsExist', {'empId': id, 'account': account}).done(function(data){
   			if(data == 'isExist') {
   				$('#isExist').show();
   				$('#update').attr('disabled', 'disabled');
   			}else if (data == 'notExist') {
   				$('#isExist').hide();
   				$('#update').removeAttr('disabled');
   			}
   		}).fail(function(msg) {
   			alert('服务器端错误！');	
   		});
	});
	
	$('#update').click(function(){
		// 输入验证
		var id = $("#id").val();
		var account = $('#account').val();
   		var name = $("#name").val();
   		var mobile = $("#mobile").val();
   		var teacher = $("#teacher").val();
   		var remarks = $("#remarks").val();
   		var password = $("#password").val();
   		var repassword = $("#repassword").val();
   		
   		// 验证用工单位账号
   		if(account.trim() == '') {
   			alert('账号不能为空！');
   			$('#account').focus();
   			return;
   		}
   		
		// 验证用工单位名称
   		if(name.trim() == "") {
			alert('用工单位名称为必填项！');
			$("#name").val("").focus();	// 清空并获得焦点
			return;
		}	   		
		// 验证密码
		if(repassword.trim() != ""){
			if(password.trim() == ""){
				alert("密码不能为空！");
				$("#password").focus();
				return;
			}
			if(repassword != password){
				alert("密码不一致！");
				$("#repassword").focus();
				return;
			}
		}
		
		if(mobile.trim() == ''){
			alert('电话号码不能为空！');
			$("#mobile").focus();
			return;
		}
		var reg = /(^(\d{3,4}-)?\d{7,8})$|(1[0-9]{10})/;	// 电话号码与手机号码同时验证
		if(!reg.test(mobile)) {
			alert('电话号码不合法！');
			$("#mobile").focus();
			return;
		}

		if(teacher.trim() == ""){
			alert('负责老师为必填项！');
			$('#teacher').focus();
			return;
		}
		
		var datas = $("#form").serialize();
		datas = decodeURIComponent(datas, true); /* 解决中文乱码问题 */
		
		$.post(contextPath+"/admin/editEmployer", datas).done(function(data){
			if(data == 'success') {
				$('#myModal').modal('hide');
				window.location.reload();
			}

		}).fail(function(msg){
			alert('服务器端错误！');	
		});
		
	});
		
});

function page() {
	$("#page").page({
	    remote: {
	        url: contextPath + '/admin/employerList',
	        params: {"name": $('#content').val()},	// 单位名称
	        callback: function (result) {
	            var datas = result.datas;
		        var length = datas.length;
		        var html = "";
		       	//  如果没有数据，隐藏表头
	        	if(datas == null || length == 0){
					$("#head").hide();	
					html = "<div style='text-align:center;'>暂无数据...</div>";
	        	}else {
	        		$("#head").show();
	        		for(var i = 0; i < length; i++) {
						var data = datas[i];
						html += "<tr>"
							+ "<td>"+ (i+1) +"<input type='hidden' name='id' value='"+data.id+"'></td>"	
							+ "<td>"+ data.account +"</td>"	
							+ "<td>"+ data.name +"</td>"	
							+ "<td>"+ data.mobile +"</td>"	
							+ "<td>"+ data.teacher +"</td>"	
							+ "<td>"+ data.postNum +"</td>"	
							+ "<td>"+ data.totalMoney +"</td>"	
							+ "<td>"+ data.status +"</td>"	
							+ "<td>"
							+	"<button id='edit' onclick='edit(this)' class='btn btn-primary btn-sm mybtn' data-toggle='modal' data-target='#myModal'>编辑</button>&nbsp;&nbsp;"
							+ "</td>"	
							+ "</tr>";
						
						// +	"<button id='delete' onclick='del(this)' class='btn btn-primary btn-sm mybtn'>删除</button>"
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

// 编辑用工单位信息
function edit(t) {
	var $this = $(t);
	var id = $this.parent().parent().find('input[name="id"]').val();
	
	$.post(contextPath+'/empinfo', {'empId': id}).done(function(data){
		var id = data.id;
		var account = data.account;
		var name = data.name;
		var mobile = data.mobile;
		var teacher = data.teacher;
		var postNum = data.postNum;
		var totalMoney = data.totalMoney;
		var regDate = data.regDate;
		var remarks = data.remarks;
		
		$('#id').attr('value', id);
		$('#account').attr('value', account);
		$('#name').attr('value', name);
		$('#mobile').attr('value', mobile);
		$('#teacher').attr('value', teacher);
		$('#postNum').attr('value', postNum);
		$('#totalMoney').attr('value', totalMoney);
		$('#remarks').html(remarks);
		
		$('#regDate').html(formatterDate(regDate));
		
	}).fail(function(msg){
		alert('服务器端出错！');
	});
}

// 删除用工单位
function del(t) {
	var $this = $(t);
	alert($this);
}
   
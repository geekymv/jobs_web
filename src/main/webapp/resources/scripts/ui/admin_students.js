var params = {}

$(function(){
 	page();
	
	$('#search').click(function(){
		$('#page').page( 'destroy' )
		page();  			
	});

	// 专业改变事件
	$("#college").change(function(){
		params.colId = $("#college").val();
		getProfessions();
	});
});

function page() {
	$("#page").page({
	    remote: {
	        url: contextPath + '/admin//students',
	        params: {"content": $('#content').val()},
	        callback: function (result) {
				$("tbody").empty();
	        	var datas = result.datas;
	        	var length = datas.length;
	        	var html = "";
	        	//  如果没有数据，隐藏表头
	        	if(datas == null || length == 0){
					$("#head").hide();	
					html = "<div style='text-align:center;color:blue;'>暂无学生...</div>";
	        	}else {
	        		$("#head").show();	
        		    for(var i = 0; i < length; i++) {
						var data = datas[i];
						var status = data.status;
						if("1" == status) {
							status = "在职";				
						}else if("-1" == status) {
							status = "离职";
						}
						
						html += "<tr>"
							+ "<td>"+ (i+1) +"<input type='hidden' id='stuId' value="+data.id+"></td>"	
							+ "<td>"+ data.num +"</td>"	
							+ "<td>"+ data.name +"</td>"	
							+ "<td>"+ data.college +"</td>"
							+ "<td>"+ data.profession +"</td>"	
							+ "<td><button class='btn btn-primary btn-sm mybtn' onclick='edit(this)' data-toggle='modal' data-target='#myModal'>编辑</button></td>" 	
							+ "</tr>";
		            }
	        	}
	            $("tbody").html(html);
	        }
	    },
	    pageIndexName: 'pageIndex',     //请求参数，当前页数，索引从0开始
	    pageSizeName: 'pageSize',       //请求参数，每页数量
		totalName: 'totalRecord'       //指定返回数据的总数据量
	});
}

// 编辑
function edit(t) {
	var $this = $(t);
	var stuId = $this.parent().parent().find('#stuId').val();
	// 加载学生信息
	$.post(contextPath+'/stuinfo', {'stuId': stuId}).done(function(data){
		var collegeId = data.collegeId;
		// 获取所有学院
		getColleges(collegeId);
		
		var id = data.id;
		var num = data.num; // 学号
		var name = data.name; // 姓名
		var gender = data.gender;
		var mobile = data.mobile;
		var email = data.email; // 邮箱
		var regTime = data.regTime; // 注册时间
		var introduce = data.introduce; // 自我介绍
		
		$('#id').attr('value', id);
		$('#num').attr('value', num);
		$('#name').attr('value', name);
		// 性别回显   				
		$('input[name=gender]').each(function(i){
			var v = $(this).val();
			if(gender == v){
				$(this).attr('checked', true);
			}else {
				$(this).attr('checked', false);
			}
		});
		
		$('#mobile').attr('value', mobile);
		$('#email').attr('value', email);
		$('#regTime').html(formatterDate(regTime));
		$('#introduce').html(introduce);
		   				
	
	}).fail(function(msg){
	});
}

// 更新学生信息
$('#update').click(function(){
	var num = $('#num').val();
	if(num.trim() == ''){
		alert('学号不能为空！');	
		$('#num').focus();
		return;
	}
	
	// 输入验证
	var name = $('#name').val();
	if(name.trim() == '') {
		alert('姓名不能为空！') ;
		$('#name').focus();
		return;
	}
	
	// 密码
	var password = $('#password').val();
	var repassword = $('#repassword').val();
	// 验证密码
	if(repassword.trim() != ""){
		if(password.trim() == ""){
			alert("密码不能为空！");
			$('#password').focus();
			return;
		}
		if(repassword != password){
			alert("密码不一致！");
			$('#repassword').focus();
			return;
		}
	}
	
	// 手机号码
	var mobile = $('#mobile').val();
	if(mobile.trim() == '') {
		alert('手机号码不能为空！');
		$('#mobile').focus();
		return;
	}		
	
	// 邮箱验证
	var email = $('#email').val();
	if(email.trim() == '') {
		alert('邮箱不能为空！');					
		$('#email').focus();
	}
	
	var datas = $("#form").serialize();
	datas = decodeURIComponent(datas, true); /* 解决中文乱码问题 */
	
	$.post(contextPath+'/admin/editStudent', datas).done(function(data){
		if(data == 'success') {
			alert('更新成功！');
			$('#myModal').modal('hide');
			window.location.reload();
		}
	}).fail(function(msg){
		alert('服务器端错误！');
	});	
	
});

// 获得所有学院
function getColleges(collegeId){
	$.ajax({
		url: contextPath + "/getColleges",
		type: "post",
		dataType: "json",
		success: function(data) {
			var html = "";
			for(var i = 0; i < data.length; i++) {
				// 学生专业选择
				var pro = "<option value="+data[i].id+">" + data[i].name + "</option>";
				if(collegeId == data[i].id) {	// 学生所在学院id
					pro = "<option selected='selected' value="+data[i].id+">" + data[i].name + "</option>";
				}
				html += pro;
			}
			// 学生所在学院id
			params.colId = collegeId;
			getProfessions(); 
			
			$("#college").html(html);
		}
	});
}

// 根据学院id获得该学院的专业
function getProfessions(){
	$.ajax({
		url: contextPath + "/getProfessions",
		data: params,
		type: "post",
		dataType: "json",
		success: function(data) {
			var html = "";
			var professionId = '${student.professionId}';
			for(var i = 0; i < data.length; i++) {
				var pro = "<option value="+data[i].id+">" + data[i].name + "</option>";
				if(professionId == data[i].id) {
					pro = "<option selected='selected' value="+data[i].id+">" + data[i].name + "</option>";
				}
				html += pro;
			}
			$("#profession").html(html);
		}
	});
}
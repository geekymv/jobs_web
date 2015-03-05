(function() {
	var params = {};
	
	$(function(){
		getColleges();
		// 专业改变事件
		$("#college").change(function(){
			params.colId = $("#college").val();
			getProfessions();
		});
		
		
		$("#number").keyup(function(){
			var num = $("#number").val();
			if(isNaN(num)) {
				alert("不是数字");
			}else {
				console.log(1);
				isRegistered();
			}
			
			
		});
		$("#number").blur(function(){
			$(".tips").remove();
			isRegistered();
		});
	});
	
	// 获得所有学院
	function getColleges(){
		$.ajax({
			url: contextPath + "/getColleges",
			type: "post",
			dataType: "json",
			success: function(data) {
				var html = "";
				for(var i = 0; i < data.length; i++) {
					html += "<option value="+data[i].id+">" + data[i].name + "</option>";
				}
				// 加载第一个学院的专业
				params.colId = data[0].id;
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
				for(var i = 0; i < data.length; i++) {
					html += "<option value="+data[i].id+">" + data[i].name + "</option>";
				}
				$("#profession").html(html);
			}
		});
	}

	// 判断学号是否已经被注册
	function isRegistered(){
		var num = $("#number").val();
		$.ajax({
			url: contextPath + "/isRegistered",
			data: {"num": num},
			type: "post",
			dataType: "text",
			success: function(data) {
				if(data == "yes") {
					$("#number").parent().after("<div class='col-sm-3 tips'>学号已经注册了！<a href='login'>请点击登录</a></div>");
					$("#register").attr("disabled","disabled");
				}else if(data == "no"){
					$("#register").removeAttr("disabled");
					$(".tips").remove();
				}
			}
		});
		
	}
	

})();









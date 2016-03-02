
// 2015-10-10 12:13:14
function formatterDate(time) {
	if(time == null || $.trim(time) == '') {
		return "";
	}
	if (time.length == 14) {
		return time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
				+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				+ time.substring(10, 12);
		//+ ":" + time.substring(12, 14);
	}else if(time.length == 8) {
		return time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
		+ time.substring(6, 8);
	}
	return "";
}

// 字符串截取
function contentSubStr(data, length) {
	if(!length) {
		length = 10;
	}
	if(data && data.length > length) {
		return data.substr(0, length)+"...";
	}
	return data;
}

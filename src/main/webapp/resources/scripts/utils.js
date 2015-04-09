
// 2015-10-10 12:13:14
function formatterDate(time) {
	if (time.length == 14) {
		return time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
				+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				+ time.substring(10, 12) + ":" + time.substring(12, 14);
	}
	return "&nbsp;";
}


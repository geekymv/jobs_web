<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>	
<div class="panel panel-primary">
	<div class="panel-heading" style="text-align: center;">功能导航</div>
	<div class="list-group left-sider">
		<a href="${ctx }/student/myinfo" class="list-group-item">我的资料</a> 
		<a href="${ctx }/student/jobs" class="list-group-item">我的工作</a>
		<a href="${ctx }/student/records" class="list-group-item">报名记录</a>
		<a href="${ctx }/student/home" class="list-group-item">查看招聘</a> 
	</div>
</div>
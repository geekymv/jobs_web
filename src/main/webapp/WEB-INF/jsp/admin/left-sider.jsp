<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>	
<div class="left-sider">
  <div class="operate">
    <ul id="J_navlist">
    	<!-- 	
      <li>
        <h4 >个人资料</h4>
        <div class="list-item none">
          <p ><a href="admin/admin-preUpdatePwd.do" target="_self">修改密码</a></p>
        </div>
      </li>
       -->
      <li >
        <h4 >学生管理</h4>
        <div class="list-item none">
          <p ><a href="${ctx }/admin/students" target="_self">学生列表</a></p>
        </div>
      </li>
      <li >
        <h4 >单位管理</h4>
        <div class="list-item none">
          <p ><a href="${ctx }/admin/addemployer" target="_self">添加单位</a></p>
          <p ><a href="${ctx }/admin/employers" target="_self">单位列表</a></p>
        </div>
      </li>
      <li >
        <h4 >学院管理</h4>
        <div class="list-item none">
          <p ><a href="${ctx }/admin/colleges" target="_self">学院列表</a></p>
        </div>
      </li>
      <li >
        <h4 >工资管理</h4>
        <div class="list-item none">
          <p ><a href="${ctx }/admin/salaryList" target="_self">工资列表</a></p>
        </div>
      </li>
    </ul>
    <script type="text/javascript">
		navList(1);
	</script>
    </div>
  </div>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<div class="left-sider">
  <div class="operate">
    <ul id="J_navlist">
      <li>
        <h4 >个人资料</h4>
        <div class="list-item none">
          <p ><a href="${ctx }/employer/myinfo" target="_self">我的资料</a></p>
        </div>
      </li>
      <li >
        <h4 >招聘管理</h4>
        <div class="list-item none">
          <p ><a href="employer/emp-recruitList.do" target="_self">招聘列表</a></p>
          <p ><a href="employer/publish.do" target="_self">发布招聘</a></p>
        </div>
      </li>
      <li >
        <h4 >学生管理</h4>
        <div class="list-item none">
          <p><a href="${ctx }/employer/students" target="_self">学生列表</a></p>
        </div>
      </li>
      <li >
        <h4 >工资管理</h4>
        <div class="list-item none">
          <p ><a href="employer/emp-stuList.do" target="_self">发放工资</a></p>
          <p ><a href="employer/salary-list.do" target="_self">工资列表</a></p>
        </div>
      </li>
    </ul>
    <script type="text/javascript">
navList(1);
</script>
    </div>
 </div>

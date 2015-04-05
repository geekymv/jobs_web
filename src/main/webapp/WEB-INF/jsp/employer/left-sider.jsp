<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="left-sider">
  <div class="operate">
    <ul id="J_navlist">
      <li>
        <h4 >个人资料</h4>
        <div class="list-item none">
          <p ><a href="employer/emp-empInfo.do" target="_self">查看资料</a></p>
          <p ><a href="employer/update-preUpdatePwd.do" target="_self">修改密码</a></p>
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
          <p ><a href="employer/stu-listStudent.do" target="_self">学生列表</a></p>
        </div>
      </li>
      <li >
        <h4 >工资管理</h4>
        <div class="list-item none">
          <p ><a href="employer/emp-stuList.do" target="_self">发放工资</a></p>
          <p ><a href="employer/salary-list.do" target="_self">工资列表</a></p>
          <p ><a href="employer/emp-preLoadSalary.do">下载工资表</a></p>
        </div>
      </li>
    </ul>
    <script type="text/javascript">
navList(1);
</script>
    </div>
 </div>

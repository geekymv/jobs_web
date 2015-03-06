package com.heike.base;

public final class SysCode {
	/**
	 * 用户状态
	 * @author miying
	 */
	public static final class UserStatus {
		// 账号状态(1正常， 0冻结， -1删除)
		public static final int USER_NORMAL = 1;
		public static final int USER_FREEZE = 0;
		public static final int USER_DELETE = -1;
	}

	/**
	 * 招聘信息
	 * @author miying
	 */
	public static final class RecruitCode {
		/**
		 * 招聘信息状态-已发布
		 */
		public static final int RECRUIT_PUBLISHED = 1;
		
		/**
		 * 招聘信息状态-已关闭
		 */
		public static final int RECRUIT_CLOSED = 0;
		
		/**
		 * 招聘信息状态-已删除
		 */
		public static final int RECRUIT_DELETED = -1;
	}
	
	/**
	 * 用工单位
	 * @author miying
	 */
	public static final class EmployerCode {
		/**
		 * 管理员
		 */
		public static final int ADMIN_AUTHORITY = 1;
		
		/**
		 * 用工单位
		 */
		public static final int EMPLOYER_AUTHORITY = 2;
	}
	
	/**
	 * 字典
	 * @author miying
	 */
	public static final class DictCode {
		/**
		 * 学院
		 */
		public static final String COLLEGE_TYPE = "XUE_YUAN";

		/**
		 * 专业
		 */
		public static final String PROFESSION_TYPE = "ZHUAN_YE";
		
		/**
		 * 工资提交时间-开始时间
		 */
		public static final String SALARY_COMMIT_START = "START_DATE";
		
		/**
		 * 工资提交时间-结束时间
		 */
		public static final String SALARY_COMMIT_END = "END_DATE";
		
	}
}

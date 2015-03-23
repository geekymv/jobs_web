package com.heike.base;

public final class SysCode {
	/**
	 * 用户状态
	 * @author Geek_ymv
	 */
	public static final class UserStatus {
		// 账号状态(1正常， 0冻结， -1删除)
		public static final int USER_NORMAL = 1;
		public static final int USER_FREEZE = 0;
		public static final int USER_DELETE = -1;
	}
	
	/**
	 * 用工单位-学生
	 * @author Geek_ymv
	 *
	 */
	public static interface EmployerStudent {
		/**
		 * 在职
		 */
		public static final Integer ON_JOB = 1;
		
		/**
		 * 离职
		 */
		public static final Integer LEAVE_JOB = -1;
	}
	
	/**
	 * 招聘信息-学生
	 * @author Geek_ymv
	 */
	public static interface RecruitStudent {
	//	状态(1审核通过, 0等待审核, -1审核不通过)
		/**
		 * 等待审核
		 */
		public static final Integer WAIT = 0;
		/**
		 * 审核通过
		 */
		public static final Integer APPROVED = 1;
		/**
		 * 审核未通过
		 */
		public static final Integer UNAPPROVED = -1;
		
	}

	/**
	 * 招聘信息
	 * @author Geek_ymv
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
	 * @author Geek_ymv
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
	 * @author Geek_ymv
	 */
	public static interface DictCode {
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

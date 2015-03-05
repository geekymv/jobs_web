package com.heike.base;

public final class SysCode {

	public static final class Recruit {
		/**
		 * 招聘信息状态-已发布
		 */
		public static final int RECRUIT_PUBLISHED = 1;
		
		/**
		 * 招聘信息状态-已删除
		 */
		public static final int RECRUIT_DELETED = -1;
		
	}
	
	public static final class Employer {
		/**
		 * 管理员
		 */
		public static final int ADMIN_AUTHORITY = 1;
		
		/**
		 * 用工单位
		 */
		public static final int EMPLOYER_AUTHORITY = 2;
	}
}

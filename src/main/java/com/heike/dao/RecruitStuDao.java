package com.heike.dao;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.RecruitStu;

/**
 * 招聘信息-学生Dao
 * @author miying
 */
@Repository
public class RecruitStuDao extends HibernateDao<RecruitStu> {

	/**
	 * 保存
	 * @param recruitStu
	 */
	public void saveOrUpdate(RecruitStu recruitStu) {
		super.saveOrUpdate(recruitStu);
	}
	
	
	
}

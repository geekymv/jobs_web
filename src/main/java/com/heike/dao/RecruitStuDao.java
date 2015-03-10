package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.RecruitStu;

/**
 * 招聘信息-学生Dao
 * @author miying
 */
@Repository
@SuppressWarnings("unchecked")
public class RecruitStuDao extends HibernateDao<RecruitStu> {
	/**
	 * 保存
	 * @param recruitStu
	 */
	public void saveOrUpdate(RecruitStu recruitStu) {
		super.saveOrUpdate(recruitStu);
	}
	
	/**
	 * 根据招聘id查询
	 */
	public List<RecruitStu> queryById(Long id) {
		String hql = "from RecruitStu rs where rs.id = :id";
		List<RecruitStu> rss = (List<RecruitStu>)getSession().createQuery(hql) //
													.setLong("id", id) //
													.list();
		return rss;
	}
	
	
	
}

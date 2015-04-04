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
	 * 根据招聘id查询
	 */
	public List<RecruitStu> queryById(Long id) {
		String hql = "from RecruitStu rs where rs.recId = :id order by rs.id";
		List<RecruitStu> rss = (List<RecruitStu>)getSession().createQuery(hql) //
													.setLong("id", id) //
													.list();
		return rss;
	}
	
	/**
	 * 根据学生id和招聘信息id查询
	 * @param stuId 学生id
	 * @param recId 招聘信息id
	 * @return
	 */
	public RecruitStu queryByStuIdAndRecId(Long stuId, Long recId) {
		String hql = "from RecruitStu where recId = :recId and stuId = :stuId";
		return (RecruitStu) getSession().createQuery(hql)	//
					.setLong("recId", recId)	//
					.setLong("stuId", stuId)	//
					.uniqueResult();
	}
	
}

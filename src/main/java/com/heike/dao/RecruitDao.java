package com.heike.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;

/**
 * 招聘信息Dao
 * @author miying
 */
@Repository
public class RecruitDao extends HibernateDao<Recruit> {

	/**
	 * 更新已报名人数
	 * @param id 招聘信息id
	 * @param applyNum 已报名人数
	 * @return
	 */
	public int updateApplyNum(Long id, int applyNum) {
		String hql = "update Recruit set applyNum = :applyNum where id = :id";
		int result = getSession().createQuery(hql) //
					.setInteger("applyNum", applyNum) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	/**
	 * 更新招聘状态
	 * @param id 招聘信息id
	 * @param status 状态
	 * @return
	 */
	public int updateStatus(Long id, Integer status) {
		String hql = "update Recruit set status = :status where id = :id";
		int result = getSession().createQuery(hql) //
					.setInteger("status", status) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	/**
	 * 分页查询已发布的招聘信息
	 * @param pager
	 * @return
	 */
	public Pager<Recruit> queryByPage(Pager<Recruit> pager) {
		String hql = "from Recruit r where r.status = :status order by r.endDate desc";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", SysCode.RecruitCode.RECRUIT_PUBLISHED);
		
		return this.findByPage(hql, params, pager);
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Recruit queryById(Long id) {
//		String hql = "from Recruit r where r.id = :id";
//		return (Recruit) getSession().createQuery(hql)
//									.setLong("id", id)
//									.uniqueResult();
		return super.queryById(Recruit.class, id);
	}
}














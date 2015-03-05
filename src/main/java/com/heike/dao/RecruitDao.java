package com.heike.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;

@Repository
public class RecruitDao extends HibernateDao<Recruit> {

	public Pager<Recruit> queryByPage(Pager<Recruit> pager) {
		String hql = "from Recruit where status = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", SysCode.Recruit.RECRUIT_PUBLISHED);
		
		return this.findByPage(hql, params, pager);
	}
	
}














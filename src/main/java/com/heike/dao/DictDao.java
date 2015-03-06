package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.pojo.Dict;

/**
 * 字典Dao
 * @author miying
 */
@Repository
@SuppressWarnings("unchecked")
public class DictDao extends HibernateDao<Dict>{
	
	/**
	 * 
	 * @param dict
	 */
	public void saveOrUpdate(Dict dict) {
		getSession().saveOrUpdate(dict);
	}
	
	/**
	 * 查询所有的学院
	 * @return
	 */
	public List<Dict> queryColleges() {
		String hql = "from Dict d where d.type = :type";
		
		List<Dict> dicts = (List<Dict>)getSession().createQuery(hql)
										.setString("type", SysCode.DictCode.COLLEGE_TYPE)
										.list();
		return dicts;		
	}
	
	/**
	 * 根据学院id查询该学院所有的专业
	 * @return
	 */
	public List<Dict> queryProfessions(Long superiorId) {
		String hql = "from Dict d where d.type = :type and d.superiorId = :superiorId";
		
		List<Dict> dicts = (List<Dict>)getSession().createQuery(hql)
										.setString("type", SysCode.DictCode.PROFESSION_TYPE)
										.setLong("superiorId", superiorId)
										.list();
		return dicts;		
	}
	
	/**
	 * 根据类型查询
	 * @param type
	 * @return
	 */
	public Dict queryByType(String type) {
		String hql = "from Dict d where d.type = :type";
		return (Dict)getSession().createQuery(hql)	//
								.setString("type", type)	//
								.uniqueResult();
	}
	
	
	
}

package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.pojo.Dict;

/**
 * 字典Dao
 * 
 * @author miying
 */
@Repository
@SuppressWarnings("unchecked")
public class DictDao extends HibernateDao {

	/**
	 * 根据类型查询所有
	 * 
	 * @param type
	 *            类型
	 * @return
	 */
	public List<Dict> queryAllByType(String type) {
		String hql = "from Dict d where d.type = :type";

		List<Dict> dicts = (List<Dict>) getSession().createQuery(hql)
				.setString("type", type).list();
		return dicts;
	}

	/**
	 * 根据学院id查询该学院所有的专业
	 * 
	 * @return
	 */
	public List<Dict> queryProfessions(Long superiorId) {
		String hql = "from Dict d where d.type = :type and d.superiorId = :superiorId";

		List<Dict> dicts = (List<Dict>) getSession().createQuery(hql)
				.setString("type", SysCode.DictCode.PROFESSION_TYPE)
				.setLong("superiorId", superiorId).list();
		return dicts;
	}

	/**
	 * 根据类型查询
	 * 
	 * @param type
	 * @return
	 */
	public Dict queryByType(String type) {
		String hql = "from Dict d where d.type = :type";
		return (Dict) getSession().createQuery(hql) //
				.setString("type", type) //
				.uniqueResult();
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Dict queryById(Long id) {
		return super.queryById(Dict.class, id);
	}

	/**
	 * 根据名称和类型查询
	 * 
	 * @param dict
	 * @return
	 */
	public Dict queryByNameAndType(Dict dict) {
		String hql = "from Dict d where d.name = :name and d.type = :type";
		return (Dict) getSession().createQuery(hql)
				.setString("name", dict.getName())
				.setString("type", dict.getType()).uniqueResult();
	}

	/**
	 * 根据学院id和专业名称查询
	 * 
	 * @param dictDto
	 * @return
	 */
	public Dict queryColIdAndProName(Dict dict) {
		String hql = "from Dict d where d.superiorId = :superiorId and d.name = :name";

		return (Dict) getSession().createQuery(hql)
				.setLong("superiorId", dict.getSuperiorId()) // 学院id
				.setString("name", dict.getName()) // 专业名称
				.uniqueResult();
	}

	/**
	 * 根据id修改名称
	 * 
	 * @param id
	 * @return
	 */
	public int updateName(Dict dict) {
		String hql = "update Dict d set d.name = :name where d.id = :id";
		return getSession().createQuery(hql).setString("name", dict.getName())
				.setLong("id", dict.getId()).executeUpdate();
	}

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int delete(Long id) {
		String hql = "delete Dict d where d.id = :id";
		return getSession().createQuery(hql)	//
				.setLong("id", id)	//
				.executeUpdate();
	}

}

package com.heike.base;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.heike.domain.dto.Pager;

@SuppressWarnings("unchecked")
public abstract class HibernateDao {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 根据id查询
	 * @param t
	 * @param id
	 * @return
	 */
	public <T> T queryById(Class<T> cls, Long id) {
		return (T)getSession().get(cls, id);
	}
	
	/**
	 * 保存或更新
	 * @param t
	 */
	public <T> void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	
	/**
	 * 保存
	 * @param t
	 */
	public <T> Long save(T t) {
		return (Long)getSession().save(t);
	} 
	
	/**
	 * 分页查询
	 * @param hql
	 * @param params
	 * @param pager
	 * @return
	 */
	public <T> Pager<T> findByPage(String hql, Map<String, Object> params, Pager<T> pager){
		int currentPage = pager.getPageIndex() + 1;
		int pageSize = pager.getPageSize();
		int firstResult = (currentPage  - 1 ) * pageSize; 
		
		Query query = this.getSession().createQuery(hql).setProperties(params);
		List<T> ts = (List<T>)query.setFirstResult(firstResult) //
									.setMaxResults(pageSize) //
									.list(); 
		// 页面数据
		pager.setDatas(ts);
		// 截图"from"后面的hql语句
		hql = "from " + StringUtils.substringAfter(hql, "from");
		String countHql = "select count(*) " + hql;
		
		Long totalRecord = (Long) getSession().createQuery(countHql) //
											.setProperties(params) //
											.uniqueResult();
		// 总记录数
		pager.setTotalRecord(totalRecord.intValue());
		
		int totalPage = totalRecord.intValue() % pageSize == 0 ? 
					totalRecord.intValue() / pageSize : totalRecord.intValue() / pageSize + 1;
		// 总页数		
		pager.setTotalPage(totalPage );
		
		return pager;
	}

	
	
}






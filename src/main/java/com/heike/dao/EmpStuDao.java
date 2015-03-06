package com.heike.dao;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.EmpStu;

/**
 * 用工单位-学生Dao
 * @author miying
 */
@Repository
public class EmpStuDao extends HibernateDao<EmpStu> {
	/**
	 * 保存
	 * @param empStu
	 * @return
	 */
	public Long save(EmpStu empStu) {
		return (Long)getSession().save(empStu);
	}

	/**
	 * 更新学生在职状态
	 * @param status
	 */
	public int updateStatus(Integer status) {
		String hql = "update EmpStu set status = :status";
		int result = getSession().createQuery(hql)
						.setInteger("status", status)
						.executeUpdate();
		return result;
	}
	
	public EmpStu queryByEmpAndStu(Long empId, Long stuId) {
		
		return null;
	}
	
}








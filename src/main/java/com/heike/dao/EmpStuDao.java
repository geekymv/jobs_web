package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.pojo.EmpStu;
import com.heike.domain.vo.ApplyRecruitVO;

/**
 * 用工单位-学生Dao
 * @author miying
 */
@Repository
public class EmpStuDao extends HibernateDao {

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
	
	@SuppressWarnings("unchecked")
	public List<ApplyRecruitVO> findOnJob(Long stuId) {
		String hql = "select new com.heike.domain.vo.ApplyRecruitVO(rs.recId, r.postName, rs.applyDate, e.id, e.name, r.salary, es.status) "
				+ " from EmpStu es, RecruitStu rs, Employer e, Recruit r "
				+ " where es.stuId = :stuId and es.empId = r.empId "
				+ " and rs.recId = r.id and r.empId = e.id order by rs.applyDate desc";
			
		return (List<ApplyRecruitVO>)getSession().createQuery(hql)
											.setLong("stuId", stuId)	//
											.list();
	} 
	
}








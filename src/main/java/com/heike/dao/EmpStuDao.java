package com.heike.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.EmployerStudentVO;
import com.heike.domain.vo.RecruitVO;

/**
 * 用工单位-学生Dao
 * @author Geek_ymv
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
	
	/**
	 * 学生查看我的工作
	 * @param stuId
	 * @return
	 */
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

	/**
	 * 用工单位查看学生列表
	 * @param empId 用工单位id
	 * @return
	 */
	public void queryStudentList(Pager<EmployerStudentVO> pager, Long empId) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("select new com.heike.domain.vo.EmployerStudentVO(s.id, s.num, s.name, d.name, r.postName, r.salary , es.date, es.status) ")
			.append(" from EmpStu es, Student s,")
			.append(" RecruitStu rs, Recruit r, Dict d")
			.append(" where es.empId = :empId")
			.append(" and es.stuId = rs.stuId and es.stuId = s.id ")
			.append(" and rs.recId = r.id")
			.append(" and s.professionId = d.id")
			.append(" order by es.date desc");
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empId", empId);
		
		super.findByPage(builder.toString(), params, pager);

	}
	
}








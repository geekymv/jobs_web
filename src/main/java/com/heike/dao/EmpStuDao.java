package com.heike.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.EmployerStudentVO;

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
	public int updateStatus(Integer status, Long stuId, Long empId) {
		StringBuilder builder = new StringBuilder();
		builder.append("update EmpStu set status = :status")
			.append(" where stuId = :stuId and empId = :empId");	

		int result = getSession().createQuery(builder.toString())
						.setInteger("status", status)
						.setLong("stuId", stuId)
						.setLong("empId", empId)
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
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.vo.ApplyRecruitVO(rs.recId, r.postName, rs.applyDate, e.id, e.name, r.salary, es.status) ")
			.append(" from EmpStu es, RecruitStu rs, Employer e, Recruit r ")
			.append(" where es.stuId = :stuId and rs.stuId = es.stuId and es.empId = r.empId ")
			.append(" and rs.status = :status")
			.append(" and rs.recId = r.id and r.empId = e.id order by rs.applyDate desc");
		
//		String hql = ""
//				+ " from EmpStu es, RecruitStu rs, Employer e, Recruit r "
//				+ " where es.stuId = :stuId and rs.stuId = es.stuId and es.empId = r.empId "
//				+ " and rs.recId = r.id and r.empId = e.id order by rs.applyDate desc";
			
		return (List<ApplyRecruitVO>)getSession().createQuery(builder.toString())
											.setLong("stuId", stuId)	//
											.setInteger("status", SysCode.RecruitStudent.APPROVED)
											.list();
	} 

	/**
	 * 用工单位查看学生列表
	 * @param empId 用工单位id
	 * @return
	 */
	public void queryStudentList(Pager<EmployerStudentVO> pager, Long empId) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("select new com.heike.domain.vo.EmployerStudentVO(s.id, s.num, s.name, s.mobile, d.name, r.postName, r.salary , es.date, es.status) ")
			.append(" from EmpStu es, Student s,")
			.append(" RecruitStu rs, Recruit r, Dict d")
			.append(" where es.empId = :empId")
			.append(" and es.status = :status")
			.append(" and es.stuId = rs.stuId and es.stuId = s.id ")
			.append(" and rs.recId = r.id")
			.append(" and r.empId = es.empId")	// 用工单位发布的招聘信息
			.append(" and s.professionId = d.id")
			.append(" order by es.date desc");
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empId", empId);
		params.put("status", SysCode.EmployerStudent.ON_JOB);	// 在职
		
		super.findByPage(builder.toString(), params, pager);

	}
	
	/**
	 * 判断学生是否在该用工单位任职
	 * @param stuId
	 * @param empId
	 * @return true 在职，false 不在职
	 */
	public boolean isOnJob(Long stuId, Long empId) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("select count(*) from EmpStu es")
			.append(" where es.stuId = :stuId")
			.append(" and es.empId = :empId")
			.append(" and es.status = :status");
		
		long count = (Long) getSession().createQuery(builder.toString())
				.setLong("stuId", stuId)
				.setLong("empId", empId)
				.setInteger("status", SysCode.EmployerStudent.ON_JOB)
				.uniqueResult();	// 在职
		
		return Integer.valueOf(count+"") == 1 ? true : false;
	}
	
}








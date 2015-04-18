package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.dto.SalaryDto;

@Repository
public class SalaryDao extends HibernateDao{

	@SuppressWarnings("unchecked")
	public List<SalaryDto> queryList() {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(s.name, s.num, d.name, r.postName, "
				+ "e.name, sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId");

		return getSession().createQuery(builder.toString())
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalaryDto> queryList2(Long empId) {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(s.name, s.num, d.name, r.postName, "
				+ "sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId")
		.append(" and sl.empId = :empId");
		
		return getSession().createQuery(builder.toString())
				.setLong("empId", empId)
				.list();
	}
	
	
}


































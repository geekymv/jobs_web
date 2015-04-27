package com.heike.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.SalaryDto;
import com.heike.domain.dto.SalaryQueryDto;
import com.heike.domain.pojo.Salary;

@Repository
public class SalaryDao extends HibernateDao{
	
	public Salary query(SalaryQueryDto sqd) {
		
		String hql = "from Salary s where s.stuId = :stuId and "
				+ " s.empId = :empId and s.month = :month"
				+ " and s.status = :status";
		
		return (Salary) getSession().createQuery(hql)
				.setLong("stuId", sqd.getStuId())
				.setLong("empId", sqd.getEmpId())
				.setString("month", sqd.getMonth())
				.setInteger("status", SysCode.SalaryStatus.NORMA)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<SalaryDto> queryList(String month) {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(s.name, s.num, d.name, r.postName, "
				+ "e.name, sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where sl.month = :month and s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId");

		return getSession().createQuery(builder.toString())
				.setString("month", month)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalaryDto> queryList2(Long empId, String month) {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(s.name, s.num, d.name, r.postName, "
				+ "sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where sl.month = :month and s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId")
		.append(" and sl.empId = :empId");
		
		return getSession().createQuery(builder.toString())
				.setLong("empId", empId)
				.setString("month", month)
				.list();
	}

	/**
	 * 用工单位查询工资列表
	 * @param pager
	 * @param sqd
	 */
	public void queryByPage(Pager<SalaryDto> pager, SalaryQueryDto sqd) {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(sl.id, s.name, s.num, d.name, r.postName, "
				+ "e.name, sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks, sl.month)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where sl.month = :month and s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId")
		.append(" and sl.empId = :empId");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("month", sqd.getMonth());
		params.put("empId", sqd.getEmpId());
		
		findByPage(builder.toString(), params , pager);
	}
	
	/**
	 * 管理员查询工资列表
	 * @param pager
	 * @param sqd
	 */
	public void queryByPage2(Pager<SalaryDto> pager, SalaryQueryDto sqd) {
		StringBuilder builder = new StringBuilder("select new com.heike.domain.dto.SalaryDto");
		builder.append("(s.name, s.num, d.name, r.postName, "
				+ "e.name, sl.worktime, sl.salary, sl.toolFee, sl.bonus, sl.remarks, sl.month)")
		.append(" from Salary sl, Student s, Employer e, Recruit r, RecruitStu rs, Dict d")
		.append(" where sl.month = :month and s.professionId = d.id")
		.append(" and sl.stuId = s.id and sl.empId = e.id")
		.append(" and rs.recId = r.id and rs.stuId = sl.stuId")
		.append(" and r.empId = sl.empId");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("month", sqd.getMonth());
		
		findByPage(builder.toString(), params , pager);
	}
	
	/**
	 * 
	 * @param salary
	 * @return
	 */
	public int update(Salary salary) {
		StringBuilder builder = new StringBuilder();
		builder.append("update Salary set month = :month, worktime = :worktime, salary = :salary, bonus = :bonus, ")
			.append(" toolFee = :toolFee, remarks = :remarks")
			.append(" where id = :id");
		
		int res = getSession().createQuery(builder.toString())
					.setString("month", salary.getMonth())
					.setString("worktime", salary.getWorktime())
					.setString("salary", salary.getSalary())
					.setString("bonus", salary.getBonus())
					.setString("toolFee", salary.getToolFee())
					.setString("remarks", salary.getRemarks())
					.setLong("id", salary.getId())
					.executeUpdate();
		
		return res;
	}
	
	/**
	 * 根据用工单位id和月份查询
	 * 该用工单位本月已提交的工资
	 * 除了当前id
	 * @param empId
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Salary> queryByEmpIdAndMonthExceptId(Long empId, String month, Long id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new Salary(s.salary, s.bonus, s.toolFee) from Salary s")
			.append(" where s.empId = :empId and s.month = :month")
			.append(" and s.id != :id");
		
		return (List<Salary>)getSession().createQuery(builder.toString())
					.setLong("empId", empId)
					.setString("month", month)
					.setLong("id", id)
					.list();
					
	}
	
	/**
	 * 根据用工单位id和月份查询
	 * 该用工单位本月已提交的工资
	 * @param empId
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Salary> queryByEmpIdAndMonth(Long empId, String month, Long id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new Salary(s.salary, s.bonus, s.toolFee) from Salary s")
			.append(" where s.empId = :empId and s.month = :month");
		
		return (List<Salary>)getSession().createQuery(builder.toString())
					.setLong("empId", empId)
					.setString("month", month)
					.list();
					
	}
}








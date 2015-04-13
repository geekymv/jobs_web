package com.heike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.pojo.RecruitStu;
import com.heike.domain.vo.ApplyRecordVO;

/**
 * 招聘信息-学生Dao
 * @author miying
 */
@Repository
@SuppressWarnings("unchecked")
public class RecruitStuDao extends HibernateDao {
	
	/**
	 * 根据招聘id查询
	 */
	public List<RecruitStu> queryById(Long id) {
		String hql = "from RecruitStu rs where rs.recId = :id order by rs.id";
		List<RecruitStu> rss = (List<RecruitStu>)getSession().createQuery(hql) //
													.setLong("id", id) //
													.list();
		return rss;
	}
	
	/**
	 * 根据学生id和招聘信息id查询
	 * @param stuId 学生id
	 * @param recId 招聘信息id
	 * @return
	 */
	public RecruitStu queryByStuIdAndRecId(Long stuId, Long recId) {
		String hql = "from RecruitStu where recId = :recId and stuId = :stuId";
		return (RecruitStu) getSession().createQuery(hql)	//
					.setLong("recId", recId)	//
					.setLong("stuId", stuId)	//
					.uniqueResult();
	}
	
	/**
	 * 根据学生id查询该学生的报名记录
	 * @param stuId
	 * @return
	 */
	public List<ApplyRecordVO> queryApplyRecords(Long stuId) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.vo.ApplyRecordVO(r.postName, e.name, r.salary, rs.applyDate, rs.status)")
			.append(" from RecruitStu rs,")
			.append(" Recruit r, ")
			.append(" Employer e ")
			.append(" where rs.recId = r.id and r.empId = e.id and rs.stuId = :stuId order by rs.applyDate desc");
		
		return (List<ApplyRecordVO>)getSession().createQuery(builder.toString())
											.setLong("stuId", stuId).list();
		
	}
	
	/**
	 * 判断学生是否报名该用工单位的招聘信息
	 * @param stuId
	 * @param empId
	 * @return true 有待审核的招聘信息
	 */
	public boolean isApplyed(Long stuId, Long recId) {
		StringBuilder builder = new StringBuilder();
		builder.append("select count(*) from RecruitStu rs, Recruit r")
			.append(" where rs.stuId = :stuId")
			.append(" and rs.recId = :recId")
			.append(" and rs.status = :status");
		
		long count = (Long)getSession().createQuery(builder.toString())
				.setLong("stuId", stuId)
				.setLong("recId", recId)
				.setInteger("status", SysCode.RecruitStudent.WAIT) // 等待审核
				.uniqueResult();
		
		return Integer.parseInt(count + "") == 1 ? true : false;
	}
	
}

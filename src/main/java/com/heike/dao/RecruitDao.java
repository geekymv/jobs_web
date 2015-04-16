package com.heike.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.RecruitQueryDto;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.vo.RecruitVO;

/**
 * 招聘信息Dao
 * @author miying
 */
@Repository
public class RecruitDao extends HibernateDao {
	
	/**
	 * 根据招聘信息id查询报名学生数
	 */
	public int findApplyNum(Long recId) {
		String hql = "select applyNum from Recruit r where r.id = :id";
		int applyNum = (Integer)getSession().createQuery(hql)
					.setLong("id", recId).uniqueResult();
		
		return applyNum;
	}

	/**
	 * 更新已报名人数
	 * @param id 招聘信息id
	 * @return
	 */
	public int updateApplyNum(Long id) {
		String hql = "update Recruit set applyNum = applyNum+1 where id = :id";
		int result = getSession().createQuery(hql) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	/**
	 * 更新招聘状态
	 * @param id 招聘信息id
	 * @param status 状态
	 * @return
	 */
	public int updateStatus(Long id, Integer status) {
		String hql = "update Recruit set status = :status where id = :id";
		int result = getSession().createQuery(hql) //
					.setInteger("status", status) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	public int update(Recruit recruit) {
		StringBuilder builder = new StringBuilder();
		builder.append("update Recruit set title = :title, postName = :postName, postNum = :postNum,")
			.append(" salary = :salary, context = :context, endDate = :endDate")
			.append(" where id = :id");
		
		return getSession().createQuery(builder.toString())
				.setString("title", recruit.getTitle())
				.setString("postName", recruit.getPostName())
				.setInteger("postNum", recruit.getPostNum())
				.setString("salary", recruit.getSalary())
				.setString("context", recruit.getContext())
				.setString("endDate", recruit.getEndDate())
				.setLong("id", recruit.getId())
				.executeUpdate();
		
	}
	
	/**
	 * 分页查询已发布的招聘信息
	 * @param pager
	 * @return
	 */
	public void queryByPage(Pager<RecruitVO> pager) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.vo.RecruitVO(r.id, r.title, r.postName, r.releaseDate, r.endDate, r.salary, e.name)")
			.append(" from Recruit r, Employer e ")
			.append(" where r.empId = e.id and r.status = :status")
			.append(" order by r.endDate desc");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", SysCode.RecruitCode.RECRUIT_PUBLISHED);
		
		findByPage(builder.toString(), params, pager);

	}
	
	/**
	 * 分页查询已发布的招聘信息
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<RecruitVO> queryByPage(Pager<RecruitVO> pager, RecruitQueryDto dto) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.vo.RecruitVO(r.id, r.title, r.postName, r.releaseDate, r.endDate, r.salary, e.name)")
			.append(" from Recruit r, Employer e ")
			.append(" where r.empId = e.id and r.status = :status")
			.append(" and r.empId = :empId");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", SysCode.RecruitCode.RECRUIT_PUBLISHED);
		params.put("empId", dto.getEmpId());
		
		String startDate = dto.getStartDate();
		String endDate = dto.getEndDate();
		String title = dto.getTitle();
		
		if(StringUtils.isNotBlank(startDate)){
			builder.append(" and r.releaseDate >= :startDate");
			params.put("startDate", startDate);
		}
		if(StringUtils.isNotBlank(endDate)){
			builder.append(" and r.releaseDate <= :endDate");
			params.put("endDate", endDate);
		}
		if(StringUtils.isNotBlank(title)) {
			builder.append(" and r.title like '%"+ title + "%'");
		}
		
		builder.append(" order by r.endDate desc");
		
		return super.findByPage(builder.toString(), params, pager);

	}
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public RecruitVO queryById(Long id) {
		String hql = "select r.id as id, r.title as title, r.postName as postName, r.postNum as postNum, r.salary as salary, "
				+ " r.context as context, "
					+ " r.releaseDate as releaseDate, r.applyNum as applyNum, r.endDate as endDate,"
					+ " r.remarks as remarks, r.status as status,"
					+ " e.name as empName"
					+ " from Recruit r, Employer e" 
					+ " where r.empId = e.id and r.id = :id";
	
		return (RecruitVO)getSession()
				.createQuery(hql).setLong("id", id)
				.setResultTransformer(Transformers.aliasToBean(RecruitVO.class)).uniqueResult();
	}
	
}














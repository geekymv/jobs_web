package com.heike.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.base.SysCode;
import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Employer;
import com.heike.util.EncryptUtil;

@Repository
public class EmployerDao extends HibernateDao {
	
	/**
	 * 更新
	 * @param dto
	 */
	public void update(EmployerDto dto) {
		StringBuilder builder = new StringBuilder();
		builder.append("update Employer set name = :name");	// 用工单位名称
		
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("name", dto.getName());
		
		if(StringUtils.isNotBlank(dto.getPwd())){	// 更新密码
			builder.append(", pwd = :pwd");
			values.put("pwd", EncryptUtil.md5Encrypt(dto.getPwd()));
		}
		
		builder.append(", teacher =:teacher, mobile = :mobile, remarks = :remarks where id = :id");
		values.put("teacher", dto.getTeacher());
		values.put("mobile", dto.getMobile());
		values.put("remarks", dto.getRemarks());
		values.put("id", dto.getId());

		getSession().createQuery(builder.toString())
			.setProperties(values).executeUpdate();
	}
	
	/**
	 * 更新账号状态
	 * @param id 招聘信息id
	 * @param status 状态
	 * @return
	 */
	public int updateStatus(Long id, Integer status) {
		String hql = "update Employer set status = :status where id = :id";
		int result = getSession().createQuery(hql) //
					.setInteger("status", status) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	/**
	 * 更新密码
	 * @param id
	 * @param newPwd 新密码
	 * @return
	 */
	public int updatePassword(Long id, String newPwd) {
		String hql = "update Employer set pwd = :pwd where id = :id";
		int result = getSession().createQuery(hql) //
					.setString("pwd", newPwd) //
					.setLong("id", id) //
					.executeUpdate();
		return result;
	}
	
	/**
	 * 根据账号和密码查询
	 * @param account
	 * @param pwd
	 * @return
	 */
	public Employer queryByNumAndPwd(String account, String pwd) {
		String hql = "select new Employer(id, account, name, authority) from Employer e where e.status=1"
				+ " and e.account = :account and e.pwd = :pwd";
		Employer employer = (Employer) this.getSession()	//
										.createQuery(hql)	//
										.setString("account", account) //
										.setString("pwd", pwd) //
										.uniqueResult();
		return employer;
	}
	
	/**
	 * 根据账号查询
	 * @param account
	 * @return
	 */
	public Employer queryByAccount(String account) {
		String hql = "from Employer e where e.account = :account";
		return (Employer)getSession().createQuery(hql) //
					.setString("account", account) //
					.uniqueResult();
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Employer queryById(Long id) {
		return (Employer)getSession().get(Employer.class, id);
		
//		String hql = "from Employer e where e.id = :id";
//		return (Employer)getSession().createQuery(hql) //
//					.setLong("id", id) //
//					.uniqueResult();
		
	}
	
	/**
	 * 分页查询
	 * @param pager
	 * @param name 单位名称
	 */
	public void queryByPage(Pager<Employer> pager, String name) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new Employer(e.id, e.account, e.name, e.teacher, e.mobile, ")
			.append(" e.totalMoney, e.postNum, e.status) from Employer e")
			.append(" where e.authority = :authority");
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(name)) {
			builder.append(" and e.name like :name");
			params.put("name", "%"+ name +"%");
		}
	
		params.put("authority", SysCode.EmployerCode.EMPLOYER_AUTHORITY);
		
		findByPage(builder.toString(), params, pager);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

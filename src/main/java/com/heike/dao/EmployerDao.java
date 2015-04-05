package com.heike.dao;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.Employer;

@Repository
public class EmployerDao extends HibernateDao {
	
	/**
	 * 保存或更新
	 * @param employer
	 */
	public void saveOrUpdate(Employer employer) {
		getSession().saveOrUpdate(employer);
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

	
}

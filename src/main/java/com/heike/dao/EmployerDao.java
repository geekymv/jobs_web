package com.heike.dao;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.Employer;

@Repository
public class EmployerDao extends HibernateDao<Employer> {
	
	/**
	 * 根据账号和密码查询
	 * @param account
	 * @param pwd
	 * @return
	 */
	public Employer queryByNumAndPwd(String account, String pwd) {
		String hql = "select new Employer(account, name, authority) from Employer e where e.status=1"
				+ " and e.account = :account and e.pwd = :pwd";
		Employer employer = (Employer) this.getSession()	//
										.createQuery(hql)	//
										.setString("account", account) //
										.setString("pwd", pwd) //
										.uniqueResult();
		
		return employer;
	}
	
	
}

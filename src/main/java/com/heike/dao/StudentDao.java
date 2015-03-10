package com.heike.dao;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.pojo.Student;

@Repository
public class StudentDao extends HibernateDao<Student>{
	
	/**
	 * 根据学号和密码查询
	 * @param num 学号
	 * @param pwd 密码
	 * @return
	 */
	public Student queryByNumAndPwd(String num, String pwd) {
		String hql = "select new Student(num, name) from Student s where s.status=1"
				+ " and s.num = :num and s.pwd = :pwd";
		Student student = (Student) this.getSession()	//
										.createQuery(hql)	//
										.setString("num", num) //
										.setString("pwd", pwd) //
										.uniqueResult();
		return student;
	}
	
	/**
	 * 根据学号查询
	 * @param num
	 * @return
	 */
	public Student queryByNum(String num) {
		String hql = "select new Student(num, name) from Student s where s.status=1"
				+ " and s.num = :num";
		Student student = (Student) this.getSession()	//
										.createQuery(hql)	//
										.setString("num", num) //
										.uniqueResult();
		return student;
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Student queryById(Long id) {
		return super.queryById(Student.class, id);
	}
	
	/**
	 * 保存学生
	 * @param student
	 */
	public Long save(Student student) {
		return (Long)getSession().save(student);
	}

}

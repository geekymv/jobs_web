package com.heike.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.heike.base.HibernateDao;
import com.heike.domain.dto.Pager;
import com.heike.domain.dto.StudentDto;
import com.heike.domain.pojo.Student;
import com.heike.domain.vo.StudentVO;

@Repository
public class StudentDao extends HibernateDao {
	
	/**
	 * 分页查询
	 * @param pager
	 * @return
	 */
	public Pager<StudentDto> queryByPage(Pager<StudentDto> pager) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.dto.StudentDto(")
			.append(" s.id, s.num, s.name, d1.id, d1.name, d2.id, d2.name")
			.append(" )")
			.append(" from Student s, Dict d1, Dict d2 ")
			.append(" where s.collegeId = d1.id and s.professionId = d2.id ");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return this.findByPage(builder.toString(), params, pager);
	}
	
	
	/**
	 * 根据学号和密码查询
	 * @param num 学号
	 * @param pwd 密码
	 * @return
	 */
	public Student queryByNumAndPwd(String num, String pwd) {
		String hql = "select new Student(id, num, name) from Student s where s.status=1"
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
	 * @param num
	 * @return
	 */
	public StudentVO findById(Long id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select new com.heike.domain.vo.StudentVO(s.id, s.num, s.name, s.gender, d1.id, d1.name, d2.id, d2.name, s.mobile, s.email, s.introduce, s.regTime) ")
				.append(" from Student s, Dict d1, Dict d2 where s.id = :id and s.collegeId = d1.id ")
				.append(" and s.professionId = d2.id");
		
		return (StudentVO) getSession().createQuery(builder.toString())
					.setLong("id", id).uniqueResult();
	}
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Student queryById(Long id) {
		return super.queryById(Student.class, id);
	}
	
}

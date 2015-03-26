package com.heike.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmpStuDao;
import com.heike.dao.RecruitDao;
import com.heike.dao.RecruitStuDao;
import com.heike.dao.StudentDao;
import com.heike.domain.pojo.RecruitStu;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.StudentService;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.StudentVO;
import com.heike.util.EncryptUtil;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private RecruitStuDao recruitStuDao;
	@Autowired
	private EmpStuDao empStuDao;
	@Autowired
	private RecruitDao recruitDao;
	
	@Override
	public Student getByNum(String num) {
		return studentDao.queryByNum(num);
	}

	@Override
	public StudentVO getById(Long id) {
		return studentDao.findById(id);
	}
	
	
	@Override
	public Student register(Student student) {
		// 设置注册时间
		student.setRegTime(new Date());
		// 设置用户状态为正常
		student.setStatus(SysCode.UserStatus.USER_NORMAL);
		// 对密码加密
		student.setPwd(EncryptUtil.md5Encrypt(student.getPwd()));
		
		return studentDao.save(student) != null ? student : null;
		
	}
	
	@Override
	public void apply(Long stuId, Long recId) {
		RecruitStu rs = new RecruitStu();
		rs.setStuId(stuId);
		rs.setRecId(recId);
		rs.setApplyDate(new Date());
		rs.setStatus(SysCode.RecruitStudent.WAIT);	// 等待审核
		
		recruitStuDao.saveOrUpdate(rs);
		
		// 更新已报名人数
		recruitDao.updateApplyNum(recId);
		
	}
	
	@Override
	public List<ApplyRecruitVO> getOnJobList(Long stuId) {
		return empStuDao.findOnJob(stuId);
	}


}


















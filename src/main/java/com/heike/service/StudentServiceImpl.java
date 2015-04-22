package com.heike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmpStuDao;
import com.heike.dao.RecruitDao;
import com.heike.dao.RecruitStuDao;
import com.heike.dao.StudentDao;
import com.heike.domain.dto.ApplyDto;
import com.heike.domain.pojo.RecruitStu;
import com.heike.domain.pojo.Student;
import com.heike.domain.service.StudentService;
import com.heike.domain.vo.ApplyRecruitVO;
import com.heike.domain.vo.StudentVO;
import com.heike.util.DateUtils;
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
		student.setRegTime(DateUtils.getCurrentGaDate());
		// 设置用户状态为正常
		student.setStatus(SysCode.UserStatus.USER_NORMAL);
		// 对密码加密
		student.setPwd(EncryptUtil.md5Encrypt(student.getPwd()));
		
		return studentDao.save(student) != null ? student : null;
		
	}
	
	@Override
	public String apply(ApplyDto applyDto) {
		Long stuId = applyDto.getStuId();
		Long empId = applyDto.getEmpId();
		Long recId = applyDto.getRecId();
		
		// 判断招聘信息是否到截止日期了
		String endDate = recruitDao.getEndDate(recId);
		String nowDate = DateUtils.getCurrentGaDate();
		long e = Long.valueOf(endDate);
		long n = Long.valueOf(nowDate);
		if(e < n) {
			return "isPastDue";	// 过期
		}
		
		boolean res = empStuDao.isOnJob(stuId, empId);
		if(res) {
			return "onJob";	// 已在职
		}
		
		res = recruitStuDao.isApplyed(stuId, empId);
		if(res) {
			return "isApplyed";	// 已申请该用工单位的信息
		}
		
		RecruitStu rs = new RecruitStu();
		rs.setStuId(stuId);
		rs.setEmpId(empId);
		rs.setRecId(recId);
		rs.setApplyDate(DateUtils.getCurrentGaDate());
		rs.setStatus(SysCode.RecruitStudent.WAIT);	// 等待审核
		
		recruitStuDao.save(rs);
		
		// 更新已报名人数
		recruitDao.updateApplyNum(recId);
		
		return "success";
	}
	
	@Override
	public List<ApplyRecruitVO> getOnJobList(Long stuId) {
		return empStuDao.findOnJob(stuId);
	}

	@Override
	public boolean update(Student student) {
		int res = studentDao.update(student);
		return res == 1 ? true : false;
	}


}


















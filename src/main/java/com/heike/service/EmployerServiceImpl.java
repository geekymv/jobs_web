package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
import com.heike.dao.EmpStuDao;
import com.heike.dao.EmployerDao;
import com.heike.dao.RecruitStuDao;
import com.heike.domain.dto.ApproveDto;
import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.EmpStu;
import com.heike.domain.pojo.Employer;
import com.heike.domain.pojo.RecruitStu;
import com.heike.domain.service.EmployerService;
import com.heike.domain.vo.EmployerStudentVO;
import com.heike.domain.vo.RecruitStuVO;
import com.heike.util.DateUtils;

@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private EmpStuDao empStuDao;
	
	@Autowired
	private RecruitStuDao recruitStuDao;
	
	@Override
	public Employer getInfo(Long id) {
		return employerDao.queryById(id);
	}

	public void edit(EmployerDto dto) {
		employerDao.update(dto);
	}

	@Override
	public void getStudentPage(Pager<EmployerStudentVO> pager, Long empId) {
		empStuDao.queryStudentList(pager, empId);
	}

	@Override
	public void getWaitStudents(Pager<RecruitStuVO> pager, Long empId) {
		recruitStuDao.queryWaitStudents(pager, empId);
	}

	@Override
	public void approve(ApproveDto dto) {
		// 审核通过
		if(SysCode.RecruitStudent.APPROVED == dto.getStatus()) {
			EmpStu empStu = new EmpStu();
			empStu.setEmpId(dto.getEmpId());
			empStu.setStatus(SysCode.EmployerStudent.ON_JOB);
			empStu.setStuId(dto.getStuId());
			empStu.setDate(DateUtils.getCurrentGaDate());
			empStuDao.save(empStu);
			
			// 更新状态为审核通过
			RecruitStu rs = recruitStuDao.queryByStuIdAndRecId(dto.getStuId(), dto.getRecId());
			rs.setStatus(SysCode.RecruitStudent.APPROVED);
			recruitStuDao.saveOrUpdate(rs);
			
		}else {
			// 审核不通过
			RecruitStu rs = recruitStuDao.queryByStuIdAndRecId(dto.getStuId(), dto.getRecId());
			rs.setStatus(SysCode.RecruitStudent.UNAPPROVED);
			recruitStuDao.saveOrUpdate(rs);
		}
	}
	
}

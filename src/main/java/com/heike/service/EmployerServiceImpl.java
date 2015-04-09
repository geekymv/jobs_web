package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.EmpStuDao;
import com.heike.dao.EmployerDao;
import com.heike.domain.dto.EmployerDto;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Employer;
import com.heike.domain.service.EmployerService;
import com.heike.domain.vo.EmployerStudentVO;

@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private EmpStuDao empStuDao;
	
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
	
}

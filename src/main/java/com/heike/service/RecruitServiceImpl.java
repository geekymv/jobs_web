package com.heike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.RecruitDao;
import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;
import com.heike.domain.service.RecruitService;

@Service
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitDao recruitDao;
	
	public Pager<Recruit> list(int currentPage){
		Pager<Recruit> pager = new Pager<Recruit>();
		pager.setCurrentPage(currentPage);
		
		return recruitDao.queryByPage(pager);
	}

	public Recruit getById(Long id) {
		return recruitDao.queryById(id);
	}
	
}

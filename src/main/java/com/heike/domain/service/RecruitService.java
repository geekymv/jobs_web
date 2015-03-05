package com.heike.domain.service;

import com.heike.domain.dto.Pager;
import com.heike.domain.pojo.Recruit;

public interface RecruitService {

	public Pager<Recruit> list(int currentPage);
}

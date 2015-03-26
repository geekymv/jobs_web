package com.heike.domain.service;

import java.util.List;

import com.heike.domain.pojo.Dict;

public interface DictService {
	
	/**
	 * 根据类别查询
	 * @param type
	 * @return
	 */
	public List<Dict> list(String type);
	
	/**
	 * 新增
	 * @param dict
	 */
	public Dict add(Dict dict);
}

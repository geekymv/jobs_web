package com.heike.domain.service;

import java.util.List;

import com.heike.domain.pojo.Dict;

public interface DictService {
	
	public Dict findById(Long id);
	
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

	/**
	 * 添加学院
	 * @param dict
	 * @return "isExist" 已存在，  "success"添加成功， "fail"添加失败
	 */
	public String addCollege(Dict dict);
	
	/**
	 * 添加专业
	 * @param dto
	 * @return "isExist" 已存在，  "success"添加成功， "fail"添加失败
	 */
	public String addProfession(Dict dto);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
 }

package com.heike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.heike.dao.DictDao;
import com.heike.domain.pojo.Dict;
import com.heike.domain.service.DictService;

@Service
public class DictServiceImpl implements DictService {
	@Autowired
	private DictDao dictDao;

	/**
	 * @Cacheable 可以用在方法或者类级别
	 * 当用于方法级别时，只缓存当前方法的返回值，
	 * 当用于类级别时，这个类的所有方法的返回值都将被缓存
	 * value="queryCache"对应于ehcache.xml里的缓存名字
	 * key = 参数 + 方法名,key="#type+'list'"
	 */
	@Cacheable(value="queryCache")  
	@Override
	public List<Dict> list() {
		return dictDao.queryColleges();
	}

}























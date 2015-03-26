package com.heike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.heike.dao.DictDao;
import com.heike.domain.pojo.Dict;
import com.heike.domain.service.DictService;

/**
 * Spring Cache
 * http://jinnianshilongnian.iteye.com/blog/2001040
 * @author Geek_ymv
 */
@Service
public class DictServiceImpl implements DictService {
	@Autowired
	private DictDao dictDao;

	/**
	 * @Cacheable 可以用在方法或者类级别
	 * 当用于方法级别时，只缓存当前方法的返回值，
	 * 当用于类级别时，这个类的所有方法的返回值都将被缓存
	 * value="queryCache"对应于ehcache.xml里的缓存名字
	 * key = 参数 + 方法名,key="#params+'list'"
	 */
	@Cacheable(value="dictCache")
	@Override
	public List<Dict> list(String type) {
		return dictDao.queryAll2();
	}
	
	/**
	 * @CachePut 应用到写数据的方法上，如新增、修改方法
	 * 调用方法时会自动把相应的数据放入缓存
	 * @param dict
	 */
	@CachePut(value="dictCache", key="#dict.name")
//	@Caching(
//            put = {
//                    @CachePut(value = "dictCache", key = "#dict.name"),
//                    @CachePut(value = "dictCache", key = "#dict.type")
//            }
//    )
	public Dict add(Dict dict) {
		dictDao.save(dict);
		return dict;
	}

}























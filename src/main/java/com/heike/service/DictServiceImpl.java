package com.heike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.heike.base.SysCode;
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
//	@Cacheable(value="dictCache", key="#type")
	@Override
	public List<Dict> list(String type) {
		return dictDao.queryAllByType(type);
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
	
	@Override
	public String addCollege(Dict dict) {
		// 根据学院名称，判断该学院是否已经存在
		dict.setType(SysCode.DictCode.COLLEGE_TYPE);
		Dict d  = dictDao.queryByNameAndType(dict);
		if(d != null) {
			return "isExist";
		}

		dictDao.saveOrUpdate(dict);
		return "success";
	}

	@Override
	public Dict findById(Long id) {
		return dictDao.queryById(id);
	}

	@Override
	public String addProfession(Dict dict) {
		// 判断该学院是否已经有这个专业
	//	Long colId = dict.getSuperiorId();
	//	String proName = dict.getName();
		
		Dict d = dictDao.queryColIdAndProName(dict);
		if(d != null) {
			return "isExist";
		}
		
		// 新建专业
//		Dict dict = new Dict();
//		dict.setName(proName);
//		dict.setSuperiorId(colId);
		dict.setType(SysCode.DictCode.PROFESSION_TYPE);
		dictDao.saveOrUpdate(dict);

		return "success";
	}

	@Override
	public boolean delete(Long id) {
		int res = dictDao.delete(id);
		return res == 1 ? true : false;
	}

 
}























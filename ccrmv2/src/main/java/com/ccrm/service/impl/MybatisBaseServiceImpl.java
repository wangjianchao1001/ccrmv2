package com.ccrm.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccrm.dao.BaseDao;
import com.ccrm.dto.Pager;
import com.ccrm.service.BaseService;

/**
 * service基础实现类
 */

@Service
public class MybatisBaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	@Autowired
	private BaseDao<T, PK> baseDao;

	@Override
	public T getById(PK pk) {
		return baseDao.getById(pk);
	}

	@Override
	public int getTotalCount(T obj) {
		if (null == obj) {
			throw new NullPointerException("entity bean is null");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", obj);

		return baseDao.getTotalCount(params);
	}

	@Override
	public List<T> findList(T obj) {
		if (null == obj) {
			throw new NullPointerException("entity bean is null");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("model", obj);

		return baseDao.findList(obj);
	}

	@Override
	public Pager findPageList(T obj, Integer pageNumber, Integer pageSize) {
		int total = getTotalCount(obj);
		pageSize = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		int totalPage = (total + pageSize - 1) / pageSize;
		pageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber > totalPage ? totalPage : pageNumber;
		Pager pager = new Pager(pageNumber, pageSize, total);
		pager.setBegin((pageNumber-1)*pageSize);
		pager.setEnd(pageNumber*pageSize);
		if (total > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("model", obj);
			params.put("pager", pager);
			List<T> list = baseDao.findPageList(params);
			pager.setDatas(list); // 数据库集合
		}
		return pager;
	}

	@Override
	public int save(T obj) {
		if (null == obj) {
			throw new NullPointerException("entity bean is null");
		}
		return baseDao.save(obj);
	}

	@Override
	public int update(T obj) {
		if (null == obj) {
			throw new NullPointerException("entity bean is null");
		}

		return baseDao.update(obj);
	}

	@Override
	public int delete(PK pk) {

		return baseDao.delete(pk);
	}

}

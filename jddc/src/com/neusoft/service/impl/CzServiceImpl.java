package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.CzMapper;
import com.neusoft.service.ICzService;
import com.neusoft.vo.Cz;

@Transactional
@Service("ICzService")
public class CzServiceImpl implements ICzService{
	
	@Autowired
	CzMapper czMapper;

	@Override
	public Cz getCzById(String cid) {
		// TODO Auto-generated method stub
		return czMapper.getCzById(cid);
	}

	@Override
	public List<Cz> getAllCz(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return czMapper.getAllCz(map);
	}

	@Override
	public int addCz(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return czMapper.addCz(map);
	}

	@Override
	public int deleteCz(String cid) {
		// TODO Auto-generated method stub
		return czMapper.deleteCz(cid);
	}

	@Override
	public int editCz(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return czMapper.editCz(map);
	}

	@Override
	public int queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return czMapper.queryCount(map);
	}

}

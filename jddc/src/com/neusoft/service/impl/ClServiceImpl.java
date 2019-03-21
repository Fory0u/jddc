package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.ClMapper;
import com.neusoft.service.IClService;
import com.neusoft.vo.Cl;

@Transactional
@Service("IClService")
public class ClServiceImpl implements IClService{
	
	@Autowired
	ClMapper clMapper;

	@Override
	public Cl getClById(String cid) {
		// TODO Auto-generated method stub
		return clMapper.getClById(cid);
	}

	@Override
	public List<Cl> getAllCl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return clMapper.getAllCl(map);
	}

	@Override
	public int addCl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return clMapper.addCl(map);
	}

	@Override
	public int deleteCl(String cid) {
		// TODO Auto-generated method stub
		return clMapper.deleteCl(cid);
	}

	@Override
	public int editCl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return clMapper.editCl(map);
	}
	@Override
	public int queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return clMapper.queryCount(map);
	}
}

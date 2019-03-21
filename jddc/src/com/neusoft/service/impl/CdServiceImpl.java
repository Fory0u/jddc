package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.CdMapper;
import com.neusoft.service.ICdService;
import com.neusoft.vo.Cd;

@Transactional
@Service("ICdService")
public class CdServiceImpl implements ICdService{
	
	@Autowired
	CdMapper cdMapper;

	@Override
	public Cd getCdById(String cid) {
		// TODO Auto-generated method stub
		return cdMapper.getCdById(cid);
	}

	@Override
	public List<Cd> getAllCd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cdMapper.getAllCd(map);
	}

	@Override
	public int addCd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cdMapper.addCd(map);
	}

	@Override
	public int deleteCd(String cid) {
		// TODO Auto-generated method stub
		return cdMapper.deleteCd(cid);
	}

	@Override
	public int editCd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cdMapper.editCd(map);
	}

	@Override
	public int queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cdMapper.queryCount(map);
	}

}

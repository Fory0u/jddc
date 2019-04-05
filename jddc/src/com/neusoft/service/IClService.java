package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cl;

public interface IClService {
	Cl getClById(String cid);

	List<Cl> getAllCl(Map<String, Object> map);

	int editCl(Map<String, Object> map);

	int addCl(Map<String, Object> map);

	int deleteCl(String cid);

	int queryCount(Map<String, Object> map);
}

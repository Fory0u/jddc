package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cz;

public interface CzMapper {
	Cz getCzById(String cid);
	List<Cz> getAllCz(Map<String, Object> map);
	
	int editCz(Map<String, Object> map);
	
	int addCz(Map<String, Object> map);

	int deleteCz(String cid);
	int queryCount(Map<String, Object> map);
}

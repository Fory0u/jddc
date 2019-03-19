package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cz;

public interface OrderMapper {
	Cz getCzById(String cid);
	List<Cz> getAllCz();
	
	int editCz(Map<String, Object> map);
	
	int addCz(Map<String, Object> map);

	int deleteCz(String cid);
}

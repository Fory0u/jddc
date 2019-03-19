package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cl;

public interface ClMapper {
	Cl getClById(String cid);
	List<Cl> getAllCl();
	
	int editCl(Map<String, Object> map);
	
	int addCl(Map<String, Object> map);

	int deleteCl(String cid);
}

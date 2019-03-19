package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Cd;

public interface CdMapper {
	Cd getCdById(String cid);
	List<Cd> getAllCd();
	
	int editCd(Map<String, Object> map);
	
	int addCd(Map<String, Object> map);

	int deleteCd(String cid);
}

package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.Cd;

public interface CdMapper {
	Cd getCdById(@Param("cid")String cid);
	List<Cd> getAllCd(@Param("map")Map<String, Object> map);
	
	int editCd(@Param("map")Map<String, Object> map);
	
	int addCd(@Param("map")Map<String, Object> map);

	int deleteCd(@Param("cid")String cid);
	int queryCount(@Param("map")Map<String, Object> map);
	
	
	
	String selectDdzt(@Param("ddzt")String ddzt);
}

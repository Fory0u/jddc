package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.Cz;

public interface CzMapper {
	Cz getCzById(@Param("cid")String cid);
	List<Cz> getAllCz(@Param("map")Map<String, Object> map);
	
	int editCz(@Param("map")Map<String, Object> map);
	
	int addCz(@Param("map")Map<String, Object> map);

	int deleteCz(@Param("cid")String cid);
	int queryCount(@Param("map")Map<String, Object> map);
	
	String selectCzzt(@Param("czzt")String czzt);
	int updateCzztByDDid(@Param("czzt")String czzt,@Param("cid")String cid);
	int updateCzztByCZid(@Param("czzt")String czzt, @Param("czid")String czid);
	
	
	
}

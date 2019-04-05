package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.Cl;

public interface ClMapper {
	Cl getClById(@Param("cid") String cid);

	List<Cl> getAllCl(@Param("map") Map<String, Object> map);

	int editCl(@Param("map") Map<String, Object> map);

	int addCl(@Param("map") Map<String, Object> map);

	int deleteCl(@Param("cid") String cid);

	int queryCount(@Param("map") Map<String, Object> map);
}

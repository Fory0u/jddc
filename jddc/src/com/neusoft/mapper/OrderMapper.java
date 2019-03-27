package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.Order;

public interface OrderMapper {
	Order getOrderById(@Param("cid")String cid);
	List<Order> getAllOrder(@Param("map")Map<String, Object> map);
	
	int editOrder(@Param("map")Map<String, Object> map);
	
	int addOrder(@Param("map")Map<String, Object> map);

	int deleteOrder(@Param("cid")String cid);
	
	int queryCount(@Param("map")Map<String, Object> map);
	
	int queryCountOrdersByRyid(@Param("map")Map<String, Object> map);
	
}

package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.vo.Order;

public interface OrderMapper {
	Order getOrderById(String cid);
	List<Order> getAllOrder(Map<String, Object> map);
	
	int editOrder(Map<String, Object> map);
	
	int addOrder(Map<String, Object> map);

	int deleteOrder(String cid);
	
	int queryCount(Map<String, Object> map);
}

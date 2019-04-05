package com.neusoft.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.vo.Order;

public interface IOrderService {
	Order getOrderById(String cid);

	List<Map<String, Object>> getAllOrder(Map<String, Object> map);

	int editOrder(Map<String, Object> map);

	int addOrder(Order o);

	int deleteOrder(String cid);

	int queryCount(Map<String, Object> map);

	int queryCountOrdersByRyid(Map<String, Object> map);
}

package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.OrderMapper;
import com.neusoft.service.IOrderService;
import com.neusoft.vo.Order;

@Transactional
@Service("IOrderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	OrderMapper orderMapper;

	@Override
	public Order getOrderById(String cid) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderById(cid);
	}

	@Override
	public List<Map<String, Object>> getAllOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderMapper.getAllOrder(map);
	}

	@Override
	public int addOrder(Order o) {
		// TODO Auto-generated method stub
		return orderMapper.addOrder(o);
	}

	@Override
	public int deleteOrder(String cid) {
		// TODO Auto-generated method stub
		return orderMapper.deleteOrder(cid);
	}

	@Override
	public int editOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderMapper.editOrder(map);
	}

	@Override
	public int queryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderMapper.queryCount(map);
	}

	@Override
	public int queryCountOrdersByRyid(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderMapper.queryCountOrdersByRyid(map);
	}

}

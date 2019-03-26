package com.neusoft.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.service.ICdService;
import com.neusoft.service.IOrderService;
import com.neusoft.util.OrderUtil;
import com.neusoft.vo.Cd;
import com.neusoft.vo.Order;
@Controller
@RequestMapping("order.do")
public class OrderController {
	
	@Autowired
	IOrderService iOrderService;
	@Autowired
	OrderUtil orderUtil;
	
	@RequestMapping(params="listOrder")
	public String listOrder(Integer index,ModelMap modelmap ){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		int count=iOrderService.queryCount(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		map.put("start", (index-1)*size);
		map.put("size", size);
		
		List<Order> orders=iOrderService.getAllOrder(map);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("orders", orders);
		return "ordersList";
	}
	
	@RequestMapping(params="addOrder")
	public String addOrder(String user,String czmc,String dcxx,String dcsl,String ddzt,ModelMap modelmap ){
		
		Map<String,Object> order = orderUtil.getOrder(dcxx, dcsl);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("user",user);
		map.put("czmc",czmc);
		map.put("dcxx",dcxx);
		map.put("dcsl", dcsl);
		map.put("zs", (Integer)order.get("zs"));
		map.put("zj", (Float)order.get("zj"));
		map.put("dcsj", new Date());
		int count = iOrderService.addOrder(map);
		if(count >0){
			return "redirect:order.do?listOrder";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="editOrder")
	public String editOrder(String cid,String user,String czmc,String dcxx,String dcsl,String ddzt,ModelMap modelmap ){
		Map<String,Object> order = orderUtil.getOrder(dcxx, dcsl);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cid",cid);
		map.put("user",user);
		map.put("czmc",czmc);
		map.put("dcxx",dcxx);
		map.put("dcsl", dcsl);
		map.put("zs", (Integer)order.get("zs"));
		map.put("zj", (Float)order.get("zj"));
		map.put("dcsj", new Date());
		int count = iOrderService.editOrder(map);
		if(count >0){
			return "redirect:order.do?listOrder";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="deleteOrder")
	public String deleteOrder(String cid,ModelMap modelmap ){
		int count = iOrderService.deleteOrder(cid);
		if(count >0){
			return "redirect:order.do?listOrder";
		}else{
			return "no";
		}
	}
	
	
}

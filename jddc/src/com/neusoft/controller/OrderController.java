package com.neusoft.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.mapper.CdMapper;
import com.neusoft.mapper.CzMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.service.IOrderService;
import com.neusoft.vo.Cd;
import com.neusoft.vo.Order;
@Controller
@RequestMapping("order.do")
public class OrderController {
	
	@Autowired
	IOrderService iOrderService;
	
	@Autowired
	CdMapper cdMapper;
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	CzMapper czMapper;
	
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
		List<Map<String,Object>> orders=iOrderService.getAllOrder(map);
		//将orders中的代码进行映射
		getOrderList(orders);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("orders", orders);
		return "ordersList";
	}
	@RequestMapping(params="listOrderByRyid")
	public String listOrderByRyid(Integer index,String ryid,ModelMap modelmap ){
		int size=5;
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("ryid", ryid);
		int count=iOrderService.queryCountOrdersByRyid(map);
		int total=count%size==0?count/size:count/size+1;
		if(index==null){
			index=1;
		}
		map.put("start", (index-1)*size);
		map.put("size", size);
		List<Map<String,Object>> orders=iOrderService.getAllOrder(map);
		//将orders中的代码进行映射
		getOrderList(orders);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("orders", orders);
		return "/qt/djgl";
	}
	@RequestMapping(params="addOrder")
	public String addOrder(@RequestBody Map<String,Object> map ,ModelMap modelmap ){
		getOrder(map);
//		map.put("dcsj", new Date());
		int count = iOrderService.addOrder(map); 
		if(count >0){
			if("qt".equals(map.get("qt"))){
				return "redirect:order.do?listOrderByRyid&ryid="+(String)map.get("ryid")+"&index="+(String)map.get("index");
			}
			return "redirect:order.do?listOrder";
		}else{
			return "no";
		}
	}
	@RequestMapping(params="editOrder")
	public String editOrder(@RequestBody Map<String,Object> map,ModelMap modelmap ){
		getOrder(map);
//		map.put("dcsj", new Date());
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
	public Map<String, Object> getOrder(Map<String,Object> map) {
		// TODO Auto-generated method stub
		String dcxx =(String)map.get("dcxx");
		String dcsl =(String)map.get("dcsl");
		String[] dcxxArr =  new String[]{};
		String[] dcslArr =  new String[]{};
		Float zj =0.0f; 
		Integer zs = 0;
		if(dcxx != null ){
			dcxxArr = dcxx.split("\\;+");
			dcxx = StringUtils.join(dcxxArr,";");
		}
		if(dcsl != null ){
			dcslArr = dcsl.split("\\;+");
			dcsl = StringUtils.join(dcslArr,";");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = cdMapper.getCdById(dcxxArr[i]);
			zj += cd.getFJg()*Integer.parseInt(dcslArr[i]);
		}
		for (int i = 0; i < dcslArr.length; i++) {
			zs += Integer.parseInt(dcslArr[i]);
		}
		map.put("zs", zs);
		map.put("zj", zj);
		map.put("dcxx", dcxx);
		map.put("dcsl", dcsl);
		return map;
	}
	
	
	public void getOrderList(List<Map<String,Object>> orders){

//		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < orders.size(); i++) {
			for (Entry<String, Object> entry : orders.get(i).entrySet()) {
				if( "c_ddzt".equals(entry.getKey())){
					entry.setValue(cdMapper.selectDdzt((String)entry.getValue()));
				}
				if( "c_user".equals(entry.getKey())){
					entry.setValue(userMapper.detailUser((String)entry.getValue()).getCName());
				}
				if( "c_czmc".equals(entry.getKey())){
					entry.setValue(czMapper.getCzById((String)entry.getValue()).getCCzmc());
				}
				if( "c_dcxx".equals(entry.getKey())){
					entry.setValue(getDcxx((String)entry.getValue()));
				}
			}
			
		}
		
		
//		return orders;
	}
	private String getDcxx(String dcxx) {
		// TODO Auto-generated method stub
		String[] dcxxArr =  new String[]{};
		StringBuffer dcxxStr = new StringBuffer();
		if(dcxx != null ){
			dcxxArr = dcxx.split("\\;+");
			dcxx = StringUtils.join(dcxxArr,";");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = cdMapper.getCdById(dcxxArr[i]);
			dcxxStr.append(cd.getCCdmc()).append(";");
		}
		return dcxxStr.toString();
		
	}
	
	
	
	
//	@Test
//	public void test(){
//		String[] dcslArr =  "1;;2;;3;;".split("\\;+");
//		System.out.println(dcslArr.length);
//		for (int i = 0; i < dcslArr.length; i++) {
//			System.out.println(dcslArr[i]);
//			
//		}
//	}
	
}

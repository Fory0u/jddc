package com.neusoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.mapper.CdMapper;
import com.neusoft.mapper.CzMapper;
import com.neusoft.mapper.OrderMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.service.IOrderService;
import com.neusoft.vo.Cd;
import com.neusoft.vo.Order;
import com.neusoft.vo.User;

@Controller
@RequestMapping("/order.do")
public class OrderController {

	@Autowired
	IOrderService iOrderService;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	CdMapper cdMapper;
	@Autowired
	UserMapper userMapper;

	@Autowired
	CzMapper czMapper;

	@RequestMapping(params = "listOrder")
	public String listOrder(Integer index, ModelMap modelmap) {
		int size = 5;
		Map<String, Object> map = new HashMap<String, Object>();
		int count = iOrderService.queryCount(map);
		int total = count % size == 0 ? count / size : count / size + 1;
		if (index == null) {
			index = 1;
		}
		map.put("start", (index - 1) * size);
		map.put("size", size);
		List<Map<String, Object>> orders = iOrderService.getAllOrder(map);
		// 将orders中的代码进行映射
		getOrderList(orders);
		modelmap.put("index", index);
		modelmap.put("total", total);
		modelmap.put("orders", orders);
		return "ordersList";
	}

	@RequestMapping(params = "listOrderByRyid")
	public String listOrderByRyid(Integer index, String ryid, ModelMap modelmap) {
		// int size=5;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", ryid);
		// int count=iOrderService.queryCountOrdersByRyid(map);
		// int total=count%size==0?count/size:count/size+1;
		// if(index==null){
		// index=1;
		// }
		// map.put("start", (index-1)*size);
		// map.put("size", size);
		List<Map<String, Object>> orders = iOrderService.getAllOrder(map);
		// 将orders中的代码进行映射
		getOrderList(orders);
		// modelmap.put("index", index);
		// modelmap.put("total", total);
		modelmap.put("orders", orders);
		return "/qt/ddgl";
	}

	@RequestMapping(params = "ddjs")
	public String ddjs(String orderId, ModelMap modelmap, HttpSession session) {
		Order o = iOrderService.getOrderById(orderId);
		// 把订单拆成每个菜单
		List<Map<String, Object>> listOrder = orderToListOrder(o);
		modelmap.put("orderList", listOrder);
		modelmap.put("order", o);
		return "qt/ddjs";
	}

	/***
	 * 把订单拆成每个菜单
	 * 
	 * @param o
	 * @return
	 */
	private List<Map<String, Object>> orderToListOrder(Order o) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String dcxx = o.getCDcxx();
		String dcsl = o.getCDcsl();
		String[] dcxxArr = new String[] {};
		String[] dcslArr = new String[] {};
		if (dcxx != null) {
			dcxxArr = dcxx.split("\\;+");
			// dcxx = StringUtils.join(dcxxArr, ";");
		}
		if (dcsl != null) {
			dcslArr = dcsl.split("\\;+");
			// dcsl = StringUtils.join(dcslArr, ";");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = cdMapper.getCdById(dcxxArr[i]);
			Map<String, Object> map = cdToMap(cd, dcslArr[i]);
			list.add(map);
			// zj += cd.getFJg() * Integer.parseInt(dcslArr[i]);
		}

		return list;
	}

	private Map<String, Object> cdToMap(Cd cd, String dcsl) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cdmc", cd.getCCdmc());
		map.put("cl", cd.getCCl());
		map.put("cid", cd.getCId());
		map.put("jg", cd.getFJg());
		map.put("dcsl", dcsl);
		map.put("xj", cd.getFJg() * Integer.parseInt(dcsl));
		return map;
	}

	@ResponseBody
	@RequestMapping(params = "addOrder")
	public Object addOrder(@RequestBody Map<String, Object> map,
			ModelMap modelmap, HttpSession session) {
		Map<String, String> rs = new HashMap<String, String>();
		getOrder(map);
		// map.put("dcsj", new Date());
		Order o = mapToOrder(map);
		int count = iOrderService.addOrder(o);
		int countCzzt = czMapper
				.updateCzztByCZid("2", (String) map.get("czmc"));

		if (count > 0 && countCzzt > 0) {
			if ("qt".equals(map.get("qt"))) {
				rs.put("index", ((Integer) map.get("index") == null ? ""
						: ((Integer) map.get("index")).toString()));
				rs.put("orderId", o.getCId());
				return rs;
			}
			return "redirect:order.do?listOrder";
		} else {
			return "no";
		}
	}

	/***
	 * 确认订单信息
	 * 
	 * @param map
	 * @param modelmap
	 * @param session
	 * @return 前台订单列表
	 */
	@ResponseBody
	@RequestMapping(params = "qrdd")
	public Object qrdd(@RequestBody Map<String, Object> map, ModelMap modelmap,
			HttpSession session) {
		Map<String, String> rs = new HashMap<String, String>();
		getOrder(map);
		User user = (User) session.getAttribute("loginUser");
		if(user == null)   return "no" ;
		int count = iOrderService.editOrder(map);
		int countCzzt = czMapper.updateCzztByCZid("2", (String) map.get("czmc"));
		// 删除session中的餐桌
		session.removeAttribute("cz");
		if (count > 0 && countCzzt > 0 && "qt".equals(map.get("qt"))) {
			rs.put("index", ((Integer) map.get("index") == null ? "": ((Integer) map.get("index")).toString()));
			rs.put("status", "生成订单成功！");
			rs.put("userId",user.getCId());
			return rs;
		} else {
			return "no";
		}
	}

	// @RequestMapping(params = "test")
	// public void test(@RequestBody Map<String, Object> map) {
	// Order o =mapToOrder(map);
	// Order o = new Order();
	// o.setCUser((String) map.get("user"));
	// int count = orderMapper.addOrder1(o);
	// System.out.println(o.getCId());
	// }

	public Order mapToOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Order o = new Order();
		o.setCDcxx((String) map.get("dcxx"));
		o.setCDcsl((String) map.get("dcsl"));
		o.setCUser((String) map.get("user"));
		o.setCDdzt((String) map.get("ddzt"));
		o.setCCzmc((String) map.get("czmc"));
		o.setNZs((Integer) map.get("zs"));
		o.setFZj((Float) map.get("zj"));
		return o;
	}

	@RequestMapping(params = "editOrder")
	public String editOrder(@RequestBody Map<String, Object> map,
			ModelMap modelmap) {
		getOrder(map);
		// map.put("dcsj", new Date());
		int count = iOrderService.editOrder(map);
		if (count > 0) {
			return "redirect:order.do?listOrder";
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "editOrderDdzt")
	public String editOrderDdzt(String ddzt, String cid, ModelMap modelmap,
			HttpSession session) {
		// getOrder(map);
		// map.put("dcsj", new Date());
		User user = (User) session.getAttribute("loginUser");
		if(user == null)   return "login" ;
		int count = orderMapper.editOrderDdzt(ddzt, cid);
		int countCzzt = czMapper.updateCzztByDDid("1", cid);
		// 删除session中的餐桌
		session.removeAttribute("cz");
		if (count > 0 && countCzzt > 0) {
			return "redirect:order.do?listOrderByRyid&ryid=" + user.getCId();
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "deleteOrderQt")
	public String deleteOrderQt(String cid, ModelMap modelmap,
			HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		if(user == null)   return "login" ;
		int count = iOrderService.deleteOrder(cid);
		if (count > 0) {
			return "redirect:order.do?listOrderByRyid&ryid=" + user.getCId();
		} else {
			return "no";
		}
	}

	@RequestMapping(params = "deleteOrder")
	public String deleteOrder(String cid, ModelMap modelmap) {
		int count = iOrderService.deleteOrder(cid);
		if (count > 0) {
			return "redirect:order.do?listOrder";
		} else {
			return "no";
		}
	}

	public Map<String, Object> getOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String dcxx = (String) map.get("dcxx");
		String dcsl = (String) map.get("dcsl");
		String[] dcxxArr = new String[] {};
		String[] dcslArr = new String[] {};
		Float zj = 9.0f;
		Integer zs = 0;
		if (dcxx != null) {
			dcxxArr = dcxx.split("\\;+");
			dcxx = StringUtils.join(dcxxArr, ";");
		}
		if (dcsl != null) {
			dcslArr = dcsl.split("\\;+");
			dcsl = StringUtils.join(dcslArr, ";");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = cdMapper.getCdById(dcxxArr[i]);
			zj += cd.getFJg() * Integer.parseInt(dcslArr[i]);
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

	public void getOrderList(List<Map<String, Object>> orders) {

		// List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

		for (int i = 0; i < orders.size(); i++) {
			for (Entry<String, Object> entry : orders.get(i).entrySet()) {
				if ("c_ddzt".equals(entry.getKey())) {
					entry.setValue(cdMapper.selectDdzt((String) entry
							.getValue()));
				}
				if ("c_user".equals(entry.getKey())) {
					entry.setValue(userMapper.detailUser(
							(String) entry.getValue()).getCName());
				}
				if ("c_czmc".equals(entry.getKey())) {
					entry.setValue(czMapper
							.getCzById((String) entry.getValue()).getCCzmc());
				}
				if ("c_dcxx".equals(entry.getKey())) {
					entry.setValue(getDcxx((String) entry.getValue()));
				}
			}

		}

		// return orders;
	}

	private String getDcxx(String dcxx) {
		// TODO Auto-generated method stub
		String[] dcxxArr = new String[] {};
		StringBuffer dcxxStr = new StringBuffer();
		if (dcxx != null) {
			dcxxArr = dcxx.split("\\;+");
			dcxx = StringUtils.join(dcxxArr, ";");
		}
		for (int i = 0; i < dcxxArr.length; i++) {
			Cd cd = cdMapper.getCdById(dcxxArr[i]);
			dcxxStr.append(cd.getCCdmc()).append(";");
		}
		return dcxxStr.toString();

	}

	// @Test
	// public void test(){
	// String[] dcslArr = "1;;2;;3;;".split("\\;+");
	// System.out.println(dcslArr.length);
	// for (int i = 0; i < dcslArr.length; i++) {
	// System.out.println(dcslArr[i]);
	//
	// }
	// }

}
